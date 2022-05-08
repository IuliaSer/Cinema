package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Message;

import java.util.List;

public interface MessageRepository {
    void save(Message message);
    List<Message> getLastTwentyMessages(int filmId);

}