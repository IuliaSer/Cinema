package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Movie;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.MovieService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class SessionController {
    @Autowired
    SessionService sessionService;

    @Autowired
    HallService hallService;

    @Autowired
    MovieService movieService;

    @GetMapping("/admin/panel/sessions")
    public String getAllSessions(Model model) {
        List<Session> sessions = sessionService.getAll(model);
        model.addAttribute("sessions", sessions);
        return "Sessions";
    }

    @GetMapping("/admin/panel/sessions/createSession")
    public String saveSession(Model model) {
        Session session = new Session();
        model.addAttribute("session", session);
        List<Movie> movies = movieService.getAll(model);
        model.addAttribute("movies", movies);

        List<Hall> halls = hallService.getAllHalls(model);
        model.addAttribute("halls", halls);
        return "CreateSession";
    }

    @PostMapping("/admin/panel/sessions")
    public String saveSession(@ModelAttribute("hallId") int hallId,
        @ModelAttribute("movieId") int movieId, @ModelAttribute("price") int price, @ModelAttribute("time") String date) throws ParseException {
        Movie movie = movieService.getMovieById(movieId);
        Hall hall = hallService.getHallById(hallId);
        String newDate = date.replace('T', ' ');
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Session session = new Session(movie, hall, formatter.parse(newDate), price);
        sessionService.saveSession(session);
        return "redirect:/admin/panel/sessions";
    }
}
