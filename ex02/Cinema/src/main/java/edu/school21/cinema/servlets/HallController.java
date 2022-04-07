package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/admin/panel/halls")
    public String getAllHalls(Model model) {
        List<Hall> halls = hallService.getAllHalls(model);
        model.addAttribute("halls", halls);
        return "Halls";
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
        return "CreateHall";
    }
}
