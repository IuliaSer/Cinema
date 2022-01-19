package edu.school21.cinema.config;

import edu.school21.cinema.repositories.HallDAO;
import edu.school21.cinema.repositories.HallDAOImpl;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.HallServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

//    @Value("${db.url}")
//    private String DB_URL;
//
//    @Value("${db.user}")
//    private String DB_USER;
//
//    @Value("${db.password}")
//    private String DB_PASSWORD;
//
//    @Value("${db.driver.name}")
//    private String DB_DRIVER_NAME;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource driver = new DriverManagerDataSource();
//        driver.setUrl(DB_URL);
//        driver.setUsername(DB_USER);
//        driver.setPassword(DB_PASSWORD);
//        driver.setDriverClassName(DB_DRIVER_NAME);
//        return driver;
//    }

    @Bean()
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("CinemaUnit");
    }

    @Bean()
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
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
