package com.webstore.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Blazej on 24.01.2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.webstore")
@PropertySource({"classpath:config.properties", "classpath:ValidationMessages.properties"})

public class ApplicationConfig implements WebMvcConfigurer{


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("customLogin");
        //registry.addViewController("/userPage").setViewName("userPage");
        //registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
        rbms.setBasename("ValidationMessages");
       rbms.setDefaultEncoding("UTF-8");
        return rbms;
    }
//    @Bean
//    public LocalValidatorFactoryBean validatorFactoryBean(){
//        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
//        validatorFactoryBean.setValidationMessageSource(messageSource());
//        return validatorFactoryBean;
//    }
}
