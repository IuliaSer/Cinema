package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.repositories.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieDAO movieDAO;

    @Override
    public List<Movie> getAll(Model model) {
        return movieDAO.getAll(model);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieDAO.saveMovie(movie);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }

    @Override
    public int getMovieIdByTitle(String title) {
        return movieDAO.getMovieIdByTitle(title);
    }


}
