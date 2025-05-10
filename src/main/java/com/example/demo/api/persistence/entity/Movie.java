package com.example.demo.api.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pelicula")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "ano")
    private String year;
    @Column(name = "calificacion")
    private String movieScore;
    @Column(name = "duracion")
    private String duration;
    @Column(name = "precio")
    private String price;
    @Column(name = "presupuesto")
    private String budget;
    @Column(name = "director")
    private String director;
    private String url;

    @ManyToMany
    @JoinTable(
        name = "pelicula_actor",
        joinColumns = @JoinColumn(name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
        name = "pelicula_genero",
        joinColumns = @JoinColumn(name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genre> genres;
}
