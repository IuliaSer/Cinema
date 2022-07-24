package edu.school21.cinema.services;

import edu.school21.cinema.model.Session;

import java.util.List;

public interface SessionService {
    void saveSession(Session session);

    List<Session> getAll();

    List<Session> getAllSessionsByMovieTitle(String movieTitle);

    Session getSessionBySessionId(int id);

}
