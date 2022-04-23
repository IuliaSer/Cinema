package edu.school21.cinema.models;

import javax.persistence.Entity;

@Entity
public class Message {
    private int user_id;

    private int message_id;

    private int movie_id;

    private String content;


}
