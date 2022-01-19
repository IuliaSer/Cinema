package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HallDAOImpl implements HallDAO {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Hall> findAll() {
        return entityManager.createQuery("from Hall", Hall.class).getResultList();
    }

    @Transactional
    public void save(Hall entity) {
        entityManager.persist(entity);
    }
}
