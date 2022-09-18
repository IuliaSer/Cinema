package edu.school21.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.MultipartConfig;

@Configuration
@EnableTransactionManagement
@MultipartConfig
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

    @Value("${uploadPath}")
    private String path;

    @Bean()
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("CinemaUnit");
    }

    @Bean()
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public String uploadPath() {
        return path;
    }
}
