package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping("/admin/panel/halls")
    public String showHalls(Model model) {
        List<Hall> halls = hallService.showListOfHalls(model);
        model.addAttribute("halls", halls);
        return "Halls";
    }

    @RequestMapping("/admin/panel/halls/createHall")
    public String create(Model model) {
        Hall hall = new Hall();
        model.addAttribute("hall", hall);
        return "CreateHall";
    }

    @RequestMapping("/admin/panel/halls/saveHall")
    public String saveHall(@ModelAttribute ("hall") Hall hall) {
        hallService.saveHall(hall);
        return "redirect: /admin/panel/halls";
    }
}
