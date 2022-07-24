package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Movie;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAll(Model model);
    void saveMovie(Movie movie);
    Movie getMovieById(int movieId);
    int getMovieIdByTitle(String title);
}
