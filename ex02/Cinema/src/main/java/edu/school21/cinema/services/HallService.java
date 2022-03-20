package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;
import org.springframework.ui.Model;

import java.util.List;

public interface HallService {
    public List getAllHalls(Model model);
    public void saveHall(Hall hall);
    public Hall getHallById(int id);

}
