package com.patika.paycore.Project.service;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Movie;
import com.patika.paycore.Project.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(Integer id) {
        Optional<Movie> byId = movieRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Movie"));
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovie(Integer id) {
        movieRepository.delete(getMovie(id));
        return true;
    }
}
