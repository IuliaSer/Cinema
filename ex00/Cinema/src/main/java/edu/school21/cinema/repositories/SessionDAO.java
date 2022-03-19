package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.ui.Model;

import java.util.List;

public interface SessionDAO {
    public void saveSession(Session session);

    List<Session> getAll(Model model);
}
