package edu.school21.cinema.services;

import edu.school21.cinema.model.Hall;
import org.springframework.ui.Model;

import java.util.List;

public interface HallService {
    List getAllHalls(Model model);
    void saveHall(Hall hall);
    Hall getHallById(int id);

}
