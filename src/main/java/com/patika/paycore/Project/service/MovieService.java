package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.MovieDTO;
import com.patika.paycore.Project.model.entity.Movie;

import javax.validation.Valid;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovie(Integer id);

    void addMovie(@Valid MovieDTO movieDTO);

    Movie updateMovie(Movie movie);

    boolean deleteMovie(Integer id);
}
