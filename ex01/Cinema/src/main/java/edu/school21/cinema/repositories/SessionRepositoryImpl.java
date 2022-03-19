package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class SessionRepositoryImpl implements SessionRepository {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void saveSession(Session session) {
        entityManager.persist(session);
    }

    @Override
    public List<Session> getAll() {
        return entityManager.createQuery("from Session", Session.class).getResultList();
    }

    @Override
    public List<Session> getAllSessionsByMovieTitle(String movieTitle) {

        Query query = entityManager.createQuery("SELECT new Session(s.sessionId, s.time, m) " +
                        "FROM Session s JOIN Movie m ON s.movie.id = m.id " +
                        "WHERE m.title = " + "'" + movieTitle + "'", Session.class);

        return query.getResultList();
    }

    @Override
    public Session getSessionBySessionId(int id) {
        return entityManager.createQuery("from Session where sessionId = " + id, Session.class).getSingleResult();
    }

}
