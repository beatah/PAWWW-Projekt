/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Adam Wasilczuk
 */
@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;
    private String title;
   
    @ManyToMany
    @JoinTable(
            name = "GENRE_MOVIE",
            joinColumns = {
                @JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "GENRE_ID")}
    )
    private Collection<Genre> genre;

    @ManyToMany
    @JoinTable(
            name = "DIRECTOR_MOVIE",
            joinColumns = {
                @JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "DIRECTOR_ID")}
    )
    private Collection<Director> director;
    private Integer year;
    private Integer runtime;
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Collection<Review> reviews;
    private double rating;
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Collection<UserRating> userRating;
    @ManyToMany
    @JoinTable(
            name = "CAST_MOVIE",
            joinColumns = {
                @JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "CAST_ID")}
    )
    private Collection<Cast> cast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Collection<Genre> genre) {
        this.genre = genre;
    }

    public Collection<Director> getDirector() {
        return director;
    }

    public void setDirector(Collection<Director> director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Collection<UserRating> getUserRating() {
        return userRating;
    }

    public void setUserRating(Collection<UserRating> userRating) {
        this.userRating = userRating;
    }

}
