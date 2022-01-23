package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/admin/panel/films")
    public String showHalls(Model model) {
        List<Movie> movies = movieService.getAll(model);
        model.addAttribute("movies", movies);
        return "Movies";
    }

    @RequestMapping("/admin/panel/films/addFilm")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "AddFilm";
    }

    @PostMapping("/admin/panel/films/saveFilm")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/admin/panel/films";
    }
}
