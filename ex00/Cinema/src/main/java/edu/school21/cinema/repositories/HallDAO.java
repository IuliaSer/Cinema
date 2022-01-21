package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;

import java.util.List;

public interface HallDAO {
    public List<Hall> findAll();
    public void saveHall(Hall hall);

}
