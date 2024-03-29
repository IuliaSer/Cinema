package edu.school21.cinema.service.impl;

import edu.school21.cinema.model.Movie;
import edu.school21.cinema.repository.MovieRepository;
import edu.school21.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll(Model model) {
        return movieRepository.getAll(model);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.saveMovie(movie);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieRepository.getMovieById(movieId);
    }

    @Override
    public int getMovieIdByTitle(String title) {
        return movieRepository.getMovieIdByTitle(title);
    }

}
