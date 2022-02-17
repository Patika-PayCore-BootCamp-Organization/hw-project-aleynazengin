package com.patika.paycore.Project.service.impl;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Genre;
import com.patika.paycore.Project.model.entity.Movie;
import com.patika.paycore.Project.repository.GenreRepository;
import com.patika.paycore.Project.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre getGenre(Integer id) {
        Optional<Genre> byId = genreRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Genre"));
    }
}
