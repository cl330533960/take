package xin.cymall.common.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
import xin.cymall.common.ftp.FTPInfoVo;

import java.io.*;

/**
 *@Desc 参照一期进行FTP改写
 *@Author luoxiaojiang
 *@Date 2019年4月16日
 *@Version 1.0
 */
public class FtpUtil {

	/**
	 * 方法名：getFileFromFtp
	 * 
	 * @param ftpInfoVo
	 * @throws 返回类型：File
	 *           说明：从ftp服务器下载文件到本地 
	 */
	public static File getFileFromFtp(FTPInfoVo ftpInfoVo) {
		File localFile = null;
		FTPClient ftp = new FTPClient();
//		ftp.setControlEncoding("iso-8859-1");
//		ftp.setCharset();
//		ResourceBundle bundle = ResourceBundle.getBundle("/ftp");
		// 主机ip
		String ftpHost = ftpInfoVo.getFtpHost();
		// 端口号
		int ftpPort = ftpInfoVo.getFtpPort();
		// ftp用户名
		String ftpUser = ftpInfoVo.getFtpUser();
		// ftp密码
		String ftpPassword = ftpInfoVo.getFtpPassword();
		// ftp中的目录
		String ftpPath = ftpInfoVo.getFtpPath();
		// 远程文件名
		String fileName = ftpInfoVo.getFileName();
		// 本地路径
		String localPath = ftpInfoVo.getLocalPath();
		// 本地文件名
		String localFileName = ftpInfoVo.getLocalFileName();
		try {
			int reply;
			// 1.连接服务器
			ftp.connect(ftpHost, ftpPort);
			// 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(ftpUser, ftpPassword);
			//设置二进制格式，防止编码转换，造成换行符失效
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 3.判断登陆是否成功
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			// 4.指定要下载的目录
//			ftp.changeWorkingDirectory(ftpPath);// 转移到FTP服务器目录  
			// 这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftp.enterLocalPassiveMode();
			// 5.遍历下载的目录
			FTPFile[] fs = ftp.listFiles(ftpPath);
			// 记录是否找到对应文件
			for (FTPFile ff : fs) {
				// 解决中文乱码问题，两次解码
				byte[] bytes = ff.getName().getBytes("iso-8859-1");
				String fn = new String(bytes, "gbk");
				if (fn.equals(fileName)) {
					// 如果本地文件夹不存在则创建
					File fileDirectory = new File(localPath);

					if (!fileDirectory.isDirectory()) {
						fileDirectory.mkdirs();
					}
					// 6.写操作，将其写入到本地文件中
					localFile = new File(localPath, localFileName);
					if (localFile.exists()) {
						localFile.delete();
					}
					localFile.createNewFile();
					// 本地统一保存为LES_PAYINFO_TEMP.csv文件，已经存在则直接覆盖
					OutputStream is = new FileOutputStream(localFile);
					boolean b = ftp.retrieveFile(ftpPath+"/"+ff.getName(), is);
					
					is.flush();
					
					is.close();
				}
			}
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return localFile;
	}

	/**
	 * 方法名：getFileFromFtp
	 *
	 * @param ftpInfoVo
	 * @throws 返回类型：InputStream
	 *           说明：从ftp服务器下载文件到本地
	 */
	public static InputStream getInputStreamFromFtp(FTPInfoVo ftpInfoVo) {
		FTPClient ftp = new FTPClient();
//		ftp.setControlEncoding("iso-8859-1");
//		ftp.setCharset();
//		ResourceBundle bundle = ResourceBundle.getBundle("/ftp");
		// 主机ip
		String ftpHost = ftpInfoVo.getFtpHost();
		// 端口号
		int ftpPort = ftpInfoVo.getFtpPort();
		// ftp用户名
		String ftpUser = ftpInfoVo.getFtpUser();
		// ftp密码
		String ftpPassword = ftpInfoVo.getFtpPassword();
		// ftp中的目录
		String ftpPath = ftpInfoVo.getFtpPath();
		// 远程文件名
		String fileName = ftpInfoVo.getFileName();
		InputStream inputStream = null;
		try {
			int reply;
			// 1.连接服务器
			ftp.connect(ftpHost, ftpPort);
			// 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(ftpUser, ftpPassword);
			//设置二进制格式，防止编码转换，造成换行符失效
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 3.判断登陆是否成功
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			// 4.指定要下载的目录
//			ftp.changeWorkingDirectory(ftpPath);// 转移到FTP服务器目录
			// 这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftp.enterLocalPassiveMode();
			// 5.遍历下载的目录
			FTPFile[] fs = ftp.listFiles(ftpPath);
			// 记录是否找到对应文件
			for (FTPFile ff : fs) {
				// 解决中文乱码问题，两次解码
				byte[] bytes = ff.getName().getBytes("iso-8859-1");
				String fn = new String(bytes, "utf-8");
				if (fn.equals(fileName)) {
					inputStream = ftp.retrieveFileStream(new String((ftpPath + fileName).getBytes("utf-8"),"iso-8859-1"));
				}
			}
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return inputStream;
	}

	/**
	 * 方法名：uploadFile
	 * 
	 * @param ftpInfoVo
	 * @throws 返回类型：boolean
	 *             说明：上传文件到ftp服务器
	 */
	public static boolean uploadFile(FTPInfoVo ftpInfoVo) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
//		ResourceBundle bundle = ResourceBundle.getBundle("/ftp");
		// 主机ip
		String ftpHost = ftpInfoVo.getFtpHost();
		// 端口号
		int ftpPort = ftpInfoVo.getFtpPort();
		// ftp用户名
		String ftpUser = ftpInfoVo.getFtpUser();
		// ftp密码
		String ftpPassword = ftpInfoVo.getFtpPassword();
		// ftp中的目录
		String ftpPath = ftpInfoVo.getFtpPath();
		// 远程文件名
		String fileName = ftpInfoVo.getFileName();
		// 本地路径
		String localPath = ftpInfoVo.getLocalPath();
		// 本地文件名
		String localFileName = ftpInfoVo.getLocalFileName();
		try {
			int reply;
			// 1.连接服务器
			ftp.connect(ftpHost, ftpPort);
			// 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(ftpUser, ftpPassword);
			//设置二进制格式，防止编码转换，造成换行符失效
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 3.判断登陆是否成功
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return false;
			}
			// 创建服务器路径：默认不存在则创建，存在则不处理
			createDirecroty(ftpPath, ftp);
			ftp.changeWorkingDirectory(ftpPath);
			// 这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftp.enterLocalPassiveMode();
			FileInputStream input = new FileInputStream(new File(localPath, localFileName));
			// 解决中文乱码
			ftp.storeFile(new String(fileName.getBytes("UTF-8"), "ISO-8859-1"), input);
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return success;
	}


	/**
	 * 方法名：uploadFile
	 *
	 * @param ftpInfoVo
	 * @param file
	 * @throws 返回类型：boolean
	 *             说明：上传文件到ftp服务器
	 */
	public static boolean uploadFile(FTPInfoVo ftpInfoVo,MultipartFile file) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
//		ResourceBundle bundle = ResourceBundle.getBundle("/ftp");
		// 主机ip
		String ftpHost = ftpInfoVo.getFtpHost();
		// 端口号
		int ftpPort = ftpInfoVo.getFtpPort();
		// ftp用户名
		String ftpUser = ftpInfoVo.getFtpUser();
		// ftp密码
		String ftpPassword = ftpInfoVo.getFtpPassword();
		// ftp中的目录
		String ftpPath = ftpInfoVo.getFtpPath();
		// 远程文件名
		String fileName = ftpInfoVo.getFileName();
		try {
			int reply;
			// 1.连接服务器
			ftp.connect(ftpHost, ftpPort);
			// 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(ftpUser, ftpPassword);
			//设置二进制格式，防止编码转换，造成换行符失效
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 3.判断登陆是否成功
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return false;
			}
			// 创建服务器路径：默认不存在则创建，存在则不处理
			createDirecroty(ftpPath, ftp);
			ftp.changeWorkingDirectory(ftpPath);
			// 这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftp.enterLocalPassiveMode();
			FileInputStream input = (FileInputStream) file.getInputStream();
			// 解决中文乱码
			ftp.storeFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"), input);
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return success;
	}

	/**
	 * 方法名：createDirecroty
	 * 
	 * @param directory
	 * @param ftpClient
	 * @throws 返回类型：boolean
	 *            说明：上传文件到ftp服务器 
	 */
	public static boolean createDirecroty(String directory, FTPClient ftpClient) throws IOException {
		boolean success = true;
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			String path = "";
			String paths = "";
			while (true) {
				String subDirectory = new String(directory.substring(start, end).getBytes("GBK"), "iso-8859-1");
				path = path + "/" + subDirectory;
				if (ftpClient.listFiles(path).length <= 0) {
					ftpClient.makeDirectory(subDirectory);
				}
				ftpClient.changeWorkingDirectory(subDirectory);
				paths = paths + "/" + subDirectory;
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
	
	/**
	 * 移动ftp文件   LocalPath移动后目录 localFileName 移动后文件名
	 * @param ftpInfoVo 
	 * @return
	 */
	
	
	public static boolean moveFile(FTPInfoVo ftpInfoVo) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
//		ResourceBundle bundle = ResourceBundle.getBundle("/ftp");
		// 主机ip
		String ftpHost = ftpInfoVo.getFtpHost();
		// 端口号
		int ftpPort = ftpInfoVo.getFtpPort();
		// ftp用户名
		String ftpUser = ftpInfoVo.getFtpUser();
		// ftp密码
		String ftpPassword = ftpInfoVo.getFtpPassword();
		// ftp中的目录
		String ftpPath = ftpInfoVo.getFtpPath();
		// 远程文件名
		String fileName = ftpInfoVo.getFileName();
		// 本地路径
		String localPath = ftpInfoVo.getLocalPath();
		// 本地文件名
		String localFileName = ftpInfoVo.getLocalFileName();
		try {
			int reply;
			// 1.连接服务器
			ftp.connect(ftpHost, ftpPort);
			// 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(ftpUser, ftpPassword);
			// 设置二进制格式，防止编码转换，造成换行符失效
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 3.判断登陆是否成功
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return false;
			}
			// 创建服务器路径：默认不存在则创建，存在则不处理
			createDirecroty(ftpPath, ftp);
			ftp.changeWorkingDirectory(ftpPath);
			// 这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftp.enterLocalPassiveMode();

			// move file
			// 5.遍历下载的目录
			FTPFile[] fs = ftp.listFiles(ftpPath);
			// 记录是否找到对应文件
			for (FTPFile ff : fs) {
				// 解决中文乱码问题，两次解码
				byte[] bytes = ff.getName().getBytes("iso-8859-1");
				String fn = new String(bytes, "gbk");
				if (fn.equals(fileName)) {
					boolean b = ftp.rename(ftpPath+"/"+ff.getName(),ftpPath+"/"+localFileName);
				    System.out.println(b);
				}
			}
			

			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return success;
	}


	/*
	 * 测试FTP
	 */
	public static void main(String[] args) {
		/*上传start*/
		//上传文件 txt  excel  csv
		FTPInfoVo ftpInfoVo = new FTPInfoVo();
		ftpInfoVo.setFtpHost("10.150.2.146");//本地联想服务器地址
		ftpInfoVo.setFtpPort(21);//本地联想服务器ftp端口
		ftpInfoVo.setFtpUser("leo");//本地联想服务器ftp账户
		ftpInfoVo.setFtpPassword("leo");//本地联想服务器ftp账户密码
		ftpInfoVo.setLocalPath("C:/Users/EYUN_LXJ/Desktop/");//上传本地临时目录
		ftpInfoVo.setLocalFileName("用户批量20190513.csv");//上传本地临时文件
		ftpInfoVo.setFtpPath("/home/vsftpd/leo/");//上传ftp目录
		ftpInfoVo.setFileName("用户批量20190513ftp.csv");//上传到ftp保存的文件名
		System.out.println(FtpUtil.uploadFile(ftpInfoVo)); 
		/*上传end*/
//		ftpInfoVo.setLocalPath("C:/Users/EYUN_LXJ/Desktop/");
//		ftpInfoVo.setLocalPath("/del/");
//		System.out.println(FtpUtil.uploadFile(ftpInfoVo));  经过测试OK
//		System.out.println(FtpUtil.getFileFromFtp(ftpInfoVo));//经过测试OK
//		System.out.println(FtpUtil.moveFile(ftpInfoVo));
	}
}
