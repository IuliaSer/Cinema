package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import java.util.List;
import org.springframework.ui.Model;

public interface MovieRepository {
    public List<Movie> getAll(Model model);
    public void saveMovie(Movie movie);
    public Movie getMovieById(int movieId);
    public int getMovieIdByTitle(String title);
}
