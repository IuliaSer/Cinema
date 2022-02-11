package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"edu.school21.cinema"}) // Scans the following packages for classes with @Controller annotations
    public class DispatcherConfig implements WebMvcConfigurer {
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Bean
        public FreeMarkerConfigurer freeMarkerConfigurer(){
            FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); //?
            freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/jsp/");

            return freeMarkerConfigurer;
        }

        @Bean
        public ViewResolver getViewResolver() {
            FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

            viewResolver.setPrefix("");
            viewResolver.setSuffix(".ftl");
            return viewResolver;
        }

        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver multipartResolver() {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
            multipartResolver.setMaxUploadSize(10000000);
            return multipartResolver;
        }
    }
