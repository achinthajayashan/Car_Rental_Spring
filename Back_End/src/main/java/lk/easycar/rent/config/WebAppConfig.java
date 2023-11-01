package lk.easycar.rent.config;

import com.google.protobuf.StringValue;
import lk.easycar.rent.advisor.AppWideExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class},basePackages = {"lk.easycar.rent.controller","lk.easycar.rent.advisor"})
public class WebAppConfig implements WebMvcConfigurer {
    public WebAppConfig(){
//        System.out.println("This is Web App Config");
//        File sourceCodeDir = new File(System.getProperty("user.dir")).getParentFile().getParentFile();
//        System.out.println(sourceCodeDir+File.separator+"Projects"+File.separator+"Easy Car Rental"+File.separator+"Front_End");

        String projectPath = System.getProperty("user.dir");
        Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Projects/Easy Car Rental/Front_End");
        System.out.println(sourceCodePath);

//        String projectBaseDir = System.getProperty("project.dir");
//        System.out.println("Project Base Directory: " + projectBaseDir);

    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        return multipartResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
    }
}
