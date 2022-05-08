package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;

import java.util.List;

public interface HallRepository {
    List<Hall> getAllHalls();
    void saveHall(Hall hall);
    Hall getHallById(int id);

}
