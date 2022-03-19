package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieService {
    public List<Movie> getAll(Model model);
    public void saveMovie(Movie model);
    public Movie getMovieById(int movieId);
    public int getMovieIdByTitle(String movieTitle);
}
