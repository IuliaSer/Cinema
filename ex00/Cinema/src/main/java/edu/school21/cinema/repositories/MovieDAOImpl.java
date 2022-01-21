package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO{

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<Movie> getAll(Model model) {
        return entityManager.createQuery("from Movie", Movie.class).getResultList();
    }

    @Override
    public void saveMovie(Movie movie) {
        entityManager.persist(movie);
    }
}
