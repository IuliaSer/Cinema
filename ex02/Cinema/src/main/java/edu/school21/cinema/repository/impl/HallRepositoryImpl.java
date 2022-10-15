package edu.school21.cinema.repository.impl;

import edu.school21.cinema.model.Hall;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import edu.school21.cinema.repository.HallRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HallRepositoryImpl implements HallRepository {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<Hall> getAllHalls() {
        return entityManager.createQuery("from Hall", Hall.class).getResultList();
    }

    @Override
    public void saveHall(Hall entity) {
        entityManager.persist(entity);
    }

    @Override
    public Hall getHallById(int id) {
        Query query = entityManager.createQuery("from Hall where id = " + id);
        List<Hall> list = query.getResultList();
        return list.get(0);
    }
}
