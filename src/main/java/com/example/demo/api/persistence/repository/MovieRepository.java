package com.example.demo.api.persistence.repository;

import com.example.demo.api.persistence.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @EntityGraph(attributePaths = {"actores", "generos"})
    Optional<Movie> findById(Integer id);
}
