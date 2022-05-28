package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Message;
import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MessageService;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChatController {

    private MessageService messageService;
    private MovieService movieService;


    @Autowired
    public ChatController(MessageService messageService, MovieService movieService) {
        this.messageService = messageService;
        this.movieService = movieService;
    }

    @GetMapping("/films/{film-id}/chat")
    public String chat(@PathVariable("film-id") int filmId, Model model) {
        Movie movie = movieService.getMovieById(filmId);
        List<Message> messages = messageService.getLastTwentyMessages(filmId);
        model.addAttribute("messages", messages);
        model.addAttribute("movie", movie);
        return "chat3";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        messageService.save(message);
        return message;
    }

    @GetMapping("/films/{film-id}/chat/messages")
    @ResponseBody
    public Map<String, Object> showMessages(@PathVariable("film-id") int filmId, Model model) {
        List<Message> messages = messageService.getLastTwentyMessages(filmId);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("messages", messages);
        return result;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getUser().getLogin());
//        String clientIp = (String) headerAccessor.getSessionAttributes().get("ip");
//        message.getUser().setId(authenticationService.authUser(message.getUser(), clientIp));
        return message;
    }

}
