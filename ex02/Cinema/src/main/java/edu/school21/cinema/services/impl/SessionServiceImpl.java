package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionRepository;
import edu.school21.cinema.services.SessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public void saveSession(Session session) {
        sessionRepository.saveSession(session);
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.getAll();
    }

    @Override
    public List<Session> getAllSessionsByMovieTitle(String movieTitle) {
        return sessionRepository.getAllSessionsByMovieTitle(movieTitle);
    }

    @Override
    public Session getSessionBySessionId(int id) {
        return sessionRepository.getSessionBySessionId(id);
    }
}
