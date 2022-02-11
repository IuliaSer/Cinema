package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieDAO {
    public List<Movie> getAll(Model model);
    public void saveMovie(Movie movie);
    public Movie getMovieById(int movieId);

}
