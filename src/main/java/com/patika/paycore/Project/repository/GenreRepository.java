package com.patika.paycore.Project.repository;

import com.patika.paycore.Project.model.entity.Genre;
import com.patika.paycore.Project.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
