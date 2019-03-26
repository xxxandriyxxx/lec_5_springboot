package owu2018.lec_5_springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${custom.path}")
    String pathXXX;

//    String path = System.getProperty("user.home") + File.separator + "staticX" + File.separator;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.home") + File.separator + pathXXX + File.separator;
        //C:\Users\(current user)\(folder "StaticX")

        registry.addResourceHandler("/css/**").addResourceLocations("file:///" + path);
        registry.addResourceHandler("/js/**").addResourceLocations("file:///" + path);
    }
}
