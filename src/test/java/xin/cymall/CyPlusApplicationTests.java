package xin.cymall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CyPlusApplicationTests {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void contextLoads() {
		String content = "Date:" + System.currentTimeMillis();
		//发送默认交换机对应的的队列kinson
		amqpTemplate.convertAndSend("kinson", content);
	}

}
