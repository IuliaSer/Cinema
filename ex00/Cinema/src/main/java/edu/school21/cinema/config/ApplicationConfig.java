package edu.school21.cinema.config;

import edu.school21.cinema.repositories.HallDAO;
import edu.school21.cinema.repositories.HallDAOImpl;
import edu.school21.cinema.repositories.SessionDAO;
import edu.school21.cinema.repositories.SessionDAOimpl;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.HallServiceImpl;

import edu.school21.cinema.services.SessionService;
import edu.school21.cinema.services.SessionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
//@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

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
    public HallService hallService() {
        return new HallServiceImpl();
    }

    @Bean
    public HallDAO hallRepository() {
        return new HallDAOImpl();
    }

}
