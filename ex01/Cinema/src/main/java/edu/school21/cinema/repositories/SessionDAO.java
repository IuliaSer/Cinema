package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.models.Session;
import org.springframework.ui.Model;

import java.util.List;

public interface SessionDAO {
        void saveSession(Session session);
        List<Session> getAll();
        List<Session> getAllSessionsByMovieTitle(String movieTitle);
        Session getSessionBySessionId(int id);
    }
