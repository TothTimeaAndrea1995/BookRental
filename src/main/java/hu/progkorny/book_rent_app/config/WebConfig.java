package hu.progkorny.book_rent_app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "hu.progkorny.book_rent_app")
@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }
}