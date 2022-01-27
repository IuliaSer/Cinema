package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class SessionDAOimpl implements SessionDAO {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void saveSession(Session session) {
        entityManager.persist(session);
    }

    @Override
    public List<Session> getAll(Model model) {
        return entityManager.createQuery("from Session", Session.class).getResultList();
    }
}
