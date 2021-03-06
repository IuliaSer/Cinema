package edu.school21.cinema.servlets;

import edu.school21.cinema.model.Message;
import edu.school21.cinema.model.Movie;
import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.MessageService;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
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
        if (checkUser == null) {
            user.setId(userRepository.save(user));
        } else {
            user = checkUser;
        }
        message.getUser().setId(user.getId());
        messageService.save(message);
        return message;
    }

    @GetMapping("/films/{film-id}/messages")
    @ResponseBody
    public Map<String, Object> showMessages(@PathVariable("film-id") int filmId) {
        List<Message> messages = messageService.getLastTwentyMessages(filmId);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("messages", messages);
        return result;
    }

//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("username", message.getUser().getLogin());
////        String clientIp = (String) headerAccessor.getSessionAttributes().get("ip");
////        message.getUser().setId(authenticationService.authUser(message.getUser(), clientIp));
//        return message;
//    }

}
