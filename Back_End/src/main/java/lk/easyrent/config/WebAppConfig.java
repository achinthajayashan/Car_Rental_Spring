package lk.easyrent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.easyrent.controller"})
public class WebAppConfig {
    public WebAppConfig(){
        System.out.println("This is Web App Config");
    }
}
