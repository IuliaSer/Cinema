package edu.school21.cinema.servlets;

import edu.school21.cinema.model.Movie;
import edu.school21.cinema.services.MovieService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    private final String uploadPath;

    public MovieController(String uploadPath) {
        this.uploadPath = uploadPath;
    }

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

    @GetMapping("/movies/{id}/image")
    @ResponseBody
    public byte[] getContent(@PathVariable("id") String id) {
        Movie movie = movieService.getMovieById(Integer.parseInt(id));
//            return FileUtils.readFileToByteArray(new File(uploadPath + "/" + movie.getImageUrl()));
        return null;
    }

    @PostMapping("/admin/panel/films/saveFilm")
    public String saveMovie(@ModelAttribute("movie") Movie movie, @RequestParam("image") MultipartFile file) {
        try {
            Files.createDirectories(Paths.get(uploadPath));
            String uuidFile = UUID.nameUUIDFromBytes(file.getBytes()).toString();
            String resultFileName = uuidFile + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            File newFile = new File(uploadPath + "/" + resultFileName);
            file.transferTo(newFile);

            byte[] fileContent = FileUtils.readFileToByteArray(newFile);
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
//            movie.setImageUrl(encodedString);

            movieService.saveMovie(movie);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/panel/films";
    }

}
