package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;

import java.util.List;

public interface HallDAO {
    public List<Hall> getAllHalls();
    public void saveHall(Hall hall);
    public Hall getHallById(int id);

}
