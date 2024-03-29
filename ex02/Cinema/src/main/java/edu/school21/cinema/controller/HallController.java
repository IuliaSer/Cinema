package edu.school21.cinema.controller;

import edu.school21.cinema.model.Hall;
import edu.school21.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/admin/panel/halls")
    public String getAllHalls(Model model) {
        List<Hall> halls = hallService.getAllHalls(model);
        model.addAttribute("halls", halls);
        return "halls";
    }

    @PostMapping("/admin/panel/halls")
    public String saveHall(@ModelAttribute ("hall") Hall hall) {
        hallService.saveHall(hall);
        return "redirect:/admin/panel/halls";
    }

    @GetMapping("/admin/panel/halls/createHall")
    public String create(Model model) {
        Hall hall = new Hall();
        model.addAttribute("hall", hall);
        return "createHall";
    }
}
