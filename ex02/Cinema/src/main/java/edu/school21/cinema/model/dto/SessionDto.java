package edu.school21.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.school21.cinema.model.Session;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SessionDto {
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dateTime;
    private MovieDto movieDto;

    public SessionDto(Session session) {
        this.id = session.getSessionId();
        this.dateTime = session.getTime();
        this.movieDto = new MovieDto(session.getMovie());
    }

}