package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    private SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

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
