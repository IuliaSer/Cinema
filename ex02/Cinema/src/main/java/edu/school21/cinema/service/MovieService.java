package edu.school21.cinema.service;

import edu.school21.cinema.model.Movie;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieService {
    List<Movie> getAll(Model model);
    void saveMovie(Movie model);
    Movie getMovieById(int movieId);
    int getMovieIdByTitle(String movieTitle);
}
