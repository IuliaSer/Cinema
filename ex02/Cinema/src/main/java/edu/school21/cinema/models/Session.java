package edu.school21.cinema.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
