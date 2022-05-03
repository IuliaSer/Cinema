package edu.school21.cinema.services;

import edu.school21.cinema.models.Message;
import java.util.List;

public interface MessageService {
    void save(Message message);

    List<Message> getLastTwentyMessages(int filmId);
}
