package edu.school21.cinema.model.dto;

import edu.school21.cinema.model.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDto {
    private int id;
    private String name;
    private String posterUrl;

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getTitle();
//        this.posterUrl = movie.getImageUrl();
    }

}
