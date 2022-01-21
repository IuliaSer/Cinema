package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HallDAOImpl implements HallDAO {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<Hall> findAll() {
        return entityManager.createQuery("from Hall", Hall.class).getResultList();
    }

    @Override
    public void saveHall(Hall entity) {
        entityManager.persist(entity);
    }
}
