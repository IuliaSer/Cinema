package edu.school21.cinema.controller;

import edu.school21.cinema.model.Message;
import edu.school21.cinema.model.Movie;
import edu.school21.cinema.model.User;
import edu.school21.cinema.repository.UserRepository;
import edu.school21.cinema.service.MessageService;
import edu.school21.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChatController {

    private final MessageService messageService;
    private final MovieService movieService;
    private final UserRepository userRepository;

    @Autowired
    public ChatController(MessageService messageService, MovieService movieService, UserRepository userRepository) {
        this.messageService = messageService;
        this.movieService = movieService;
        this.userRepository = userRepository;
    }

    @GetMapping("/films/{film-id}/chat")
    public String chat(@PathVariable("film-id") int filmId, Model model) {
        Movie movie = movieService.getMovieById(filmId);
        List<Message> messages = messageService.getLastTwentyMessages(filmId);
        model.addAttribute("messages", messages);
        model.addAttribute("movie", movie);
        return "chat";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        User user = message.getUser();
        User checkUser = userRepository.findByLogin(user.getLogin());
        long id;
        if (checkUser == null) {
            id = userRepository.save(user);
            user.setId(id);
        } else {
            user = checkUser;
        }
        message.setUser(user);
        messageService.save(message);
        return message;
    }

    @GetMapping("/films/{film-id}/messages")
    public String showMessages(@PathVariable("film-id") int filmId, Model model) {
        List<Message> messages = messageService.getLastTwentyMessages(filmId);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("messages", messages);
        model.addAttribute("messages", messages);
        return "messages";
    }

}
