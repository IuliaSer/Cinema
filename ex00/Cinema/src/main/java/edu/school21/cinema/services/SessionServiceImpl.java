package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    SessionDAO sessionDAO;

    @Override
    public void saveSession(Session session) {
        sessionDAO.saveSession(session);
    }

    @Override
    public List<Session> getAll(Model model) {
        return sessionDAO.getAll(model);
    }
}
