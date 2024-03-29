package edu.school21.cinema.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int sessionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hall_id")
    private Hall hall;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date time;

    private int price;
    public Session(int sessionId, Date time, Movie movie) {
        this.sessionId = sessionId;
        this.movie = movie;
        this.time = time;
    }

    public Session(Movie movie, Hall hall, Date time, int price) {
        this.movie = movie;
        this.hall = hall;
        this.time = time;
        this.price = price;
    }
}
