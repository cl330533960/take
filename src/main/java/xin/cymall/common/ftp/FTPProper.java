package xin.cymall.common.ftp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName FTPProper
 * @Author cailei
 * @Description
 * @Date 2019/5/13 10:32
 **/

@Component
@ConfigurationProperties(prefix = "ftp")
@PropertySource("classpath:/ftp.properties")
public class FTPProper {
    private String host;
    private Integer port;
    private String user;
    private String password;

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Bean
    public FTPInfoVo getFTPInfo(){
        FTPInfoVo ftpInfoVo = new FTPInfoVo();
        ftpInfoVo.setFtpHost(host);
        ftpInfoVo.setFtpPort(port);
        ftpInfoVo.setFtpUser(user);
        ftpInfoVo.setFtpPassword(password);
        return ftpInfoVo;
    }
}
