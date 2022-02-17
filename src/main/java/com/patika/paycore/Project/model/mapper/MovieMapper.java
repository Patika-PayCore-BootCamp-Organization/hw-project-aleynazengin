package com.patika.paycore.Project.model.mapper;

import com.patika.paycore.Project.model.MovieDTO;
import com.patika.paycore.Project.model.entity.Genre;
import com.patika.paycore.Project.model.entity.Movie;
import com.patika.paycore.Project.repository.GenreRepository;
import com.patika.paycore.Project.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieMapper {
    public static Movie toMovie(MovieDTO movieDto, Genre genre) {
        Movie movie= new Movie();
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setDuration(movieDto.getDuration());
        movie.setGenre(genre);
        return movie;
    }
}
