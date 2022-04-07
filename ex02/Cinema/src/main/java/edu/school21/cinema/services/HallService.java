package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;
import java.util.List;
import org.springframework.ui.Model;

public interface HallService {
    public List getAllHalls(Model model);
    public void saveHall(Hall hall);
    public Hall getHallById(int id);

}
