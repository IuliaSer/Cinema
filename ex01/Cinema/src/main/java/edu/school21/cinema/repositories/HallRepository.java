package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;

import java.util.List;

public interface HallRepository {
    public List<Hall> getAllHalls();
    public void saveHall(Hall hall);
    public Hall getHallById(int id);

}
