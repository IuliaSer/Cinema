package edu.school21.cinema.service.impl;

import edu.school21.cinema.model.Hall;
import edu.school21.cinema.repository.HallRepository;
import edu.school21.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
public class HallServiceImpl implements HallService {

    private HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List getAllHalls(Model model) {
        List<Hall> halls = hallRepository.getAllHalls();
        return halls;
    }

    @Override
    public void saveHall(Hall hall) {
        hallRepository.saveHall(hall);
    }

    @Override
    public Hall getHallById(int id) {
        return hallRepository.getHallById(id);
    }

}
