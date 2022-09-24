package edu.school21.cinema.repository;

import edu.school21.cinema.model.Message;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void save(Message message) {
        entityManager.merge(message);
    }

    @Override
    public List<Message> getLastTwentyMessages(int filmId) {
        return entityManager.createQuery("from Message where movie.id = " + filmId, Message.class).getResultList();
    }

}
