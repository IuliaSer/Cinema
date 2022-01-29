package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/admin/panel/films")
    public String showHalls(Model model) {
        List<Movie> movies = movieService.getAll(model);
        model.addAttribute("movies", movies);
        return "Movies";
    }

    @RequestMapping("/admin/panel/films/addFilm")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "AddFilm";
    }

    @PostMapping("/admin/panel/films/saveFilm")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/admin/panel/films";
    }

    @RequestMapping(value="/admin/panel/films/savePoster", method=RequestMethod.POST)
    public String savePoster(@RequestParam MultipartFile file, HttpSession session) throws IOException {
        System.out.println("Save poster");
        ServletContext context = session.getServletContext();
        String path = context.getRealPath();
        String filename = file.getOriginalFilename();

        System.out.println(path + " " + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        return "redirect:/admin/panel/films";
    }
}
