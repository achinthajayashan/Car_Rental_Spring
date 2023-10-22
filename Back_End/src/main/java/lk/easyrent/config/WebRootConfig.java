package lk.easyrent.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.easyrent.service")
public class WebRootConfig {
    public WebRootConfig(){
        System.out.println("this is web root config");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}