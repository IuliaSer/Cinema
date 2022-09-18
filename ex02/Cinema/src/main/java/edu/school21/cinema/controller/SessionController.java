package edu.school21.cinema.controller;

import edu.school21.cinema.model.Hall;
import edu.school21.cinema.model.Movie;
import edu.school21.cinema.model.Session;
import edu.school21.cinema.model.dto.SessionDto;
import edu.school21.cinema.service.HallService;
import edu.school21.cinema.service.MovieService;
import edu.school21.cinema.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
        List<Session> sessions = sessionService.getAll();
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
        Session session = new Session(1, movie, hall, formatter.parse(newDate), price); //kakoy id dobavit
        sessionService.saveSession(session);
        return "redirect:/admin/panel/sessions";
    }

    @GetMapping("/sessions")
    public String sessions() {
        return "SessionsSearch";
    }

    @GetMapping(value = "/sessions/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SessionDto> searchSessions(@RequestParam("movieTitle") String movieTitle) {
        List<Session> sessions = sessionService.getAllSessionsByMovieTitle(movieTitle);
        List<SessionDto> sessionDaos = new ArrayList<>();
        for (Session session : sessions) {
            sessionDaos.add(new SessionDto(session));
        }
        return sessionDaos;
    }

    @GetMapping(value = "/sessions/{id}")
    public String showSession(@PathVariable("id") int id, Model model) {
        Session session = sessionService.getSessionBySessionId(id);
        model.addAttribute("session", session);
        return "Session";
    }
}
