package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
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

    @Override
    public Movie getMovieById(int movieId) {
        Query query = entityManager.createQuery("from Movie where id = " + movieId);
        List<Movie> list = query.getResultList();
        return list.get(0);
    }
}
