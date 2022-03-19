package edu.school21.cinema.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.school21.cinema.models.Session;
import java.util.Date;

public class SessionDto {
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dateTime;
    private MovieDto movieDao;

    public SessionDto(Session session) {
        this.id = session.getSessionId();
        this.dateTime = session.getTime();
        movieDao = new MovieDto(session.getMovie());
    }

    public SessionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public MovieDto getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDto movieDao) {
        this.movieDao = movieDao;
    }
}