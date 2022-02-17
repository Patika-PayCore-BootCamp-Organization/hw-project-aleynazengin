package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.MovieDTO;
import com.patika.paycore.Project.model.entity.Movie;
import com.patika.paycore.Project.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public String welcome() {
        return "Welcome to Movie Service!";
    }

    @GetMapping(value = "/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable @Min(1) Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping(value = "/create")
    public void saveMovie(@Valid @RequestBody MovieDTO movie) {
        movieService.addMovie(movie);
    }

    @PutMapping(value = "/update")
    public Movie updateMovie(@Valid @RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteMovie(@RequestParam @Min(1) Integer id) {
        return movieService.deleteMovie(id);
    }

}
