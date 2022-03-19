package edu.school21.cinema.models.dto;

import edu.school21.cinema.models.Movie;

public class MovieDto {
    private int id;
    private String name;
    private String posterUrl;

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getTitle();
        this.posterUrl = movie.getImageUrl();
    }

    public MovieDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
