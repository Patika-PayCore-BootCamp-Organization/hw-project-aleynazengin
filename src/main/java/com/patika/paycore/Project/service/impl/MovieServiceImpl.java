package com.patika.paycore.Project.service.impl;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.MovieDTO;
import com.patika.paycore.Project.model.entity.Movie;
import com.patika.paycore.Project.repository.MovieRepository;
import com.patika.paycore.Project.service.GenreService;
import com.patika.paycore.Project.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.patika.paycore.Project.model.mapper.MovieMapper.toMovie;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    private final GenreService genreService;

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
    public void addMovie(@Valid MovieDTO movieDTO) {
        movieRepository.save(toMovie(movieDTO,genreService.getGenre(movieDTO.getGenreId())));
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
