package edu.school21.cinema.repositories;

import edu.school21.cinema.model.User;

public interface UserRepository {
        public int save(User user);
        public User findByLogin(String login);
    }