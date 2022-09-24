package edu.school21.cinema.repository;

import edu.school21.cinema.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    @Transactional
    public Long save(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        try {
            return entityManager.createQuery("SELECT new User(u.id, u.login) FROM User u WHERE u.login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}