package edu.school21.cinema.repository;

import edu.school21.cinema.model.User;

public interface UserRepository {
        void save(User user);
        User findByLogin(String login);
}