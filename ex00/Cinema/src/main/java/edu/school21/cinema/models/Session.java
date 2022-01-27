package edu.school21.cinema.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int sessionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="movieId")
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hallId")
    private Hall hall;

    private String time;
    private int price;

    public Session() {}

    public Session(Movie movie, Hall hall, String time, int price) {
        this.movie = movie;
        this.hall = hall;
        this.time = time;
        this.price = price;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
