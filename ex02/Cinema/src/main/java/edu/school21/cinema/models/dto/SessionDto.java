package edu.school21.cinema.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.school21.cinema.models.Session;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
