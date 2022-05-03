package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Message;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void save(Message message) {
        entityManager.persist(message);
    }

    @Override
    public List<Message> getLastTwentyMessages(int filmId) {
        Query query = entityManager.createQuery("from Message LIMIT 10", Message.class);
        List<Message> list = query.getResultList();
        return list;
    }
}
