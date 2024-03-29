package edu.school21.cinema.service.impl;

import edu.school21.cinema.repository.MessageRepository;
import edu.school21.cinema.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.school21.cinema.model.Message;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getLastTwentyMessages(int filmId) {
        return messageRepository.getLastTwentyMessages(filmId);
    }
}
