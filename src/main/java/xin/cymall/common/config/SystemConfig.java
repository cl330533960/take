package xin.cymall.common.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/9/19.
 */
//@Configuration
public class SystemConfig {

//    @Bean
    public EmbeddedServletContainerFactory webServerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

            @Override
            public void customize(Connector connector) {
                System.out.println("systemConfig");
//                connector.setProperty("relaxedPathChars", "[]{}<>");
//                connector.setProperty("relaxedQueryChars", "[]{}<>");
            }
        });
        return factory;
    }
}
