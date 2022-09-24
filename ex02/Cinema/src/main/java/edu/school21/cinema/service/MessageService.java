package edu.school21.cinema.service;

import edu.school21.cinema.model.Message;
import java.util.List;

public interface MessageService {
    void save(Message message);
    List<Message> getLastTwentyMessages(int filmId);
}
