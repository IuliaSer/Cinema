package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping("/admin/panel/halls")
    public String showHalls(Model model) {
        System.out.println("I am here!");
        List<Hall> halls = hallService.showListOfHalls(model);
        model.addAttribute("halls", halls);
        return "Halls";
    }
}
