package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovie(Integer id);

    void addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    boolean deleteMovie(Integer id);
}
