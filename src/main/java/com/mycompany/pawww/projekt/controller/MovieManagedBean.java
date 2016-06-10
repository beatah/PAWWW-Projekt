/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.controller;

import com.mycompany.pawww.projekt.bean.MovieDAO;
import com.mycompany.pawww.projekt.model.Movie;
import com.mycompany.pawww.projekt.model.Review;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "movieManagedBean")
@RequestScoped
public class MovieManagedBean implements Serializable {

    @EJB
    MovieDAO movieDAO;

    private Movie movie;
    private Movie selectedMovie;
    private List<Movie> movies;
    private List<Review> reviews;
    private List<Movie> top5;

    public List<Movie> getTop5() {
        List<Movie> top = (List<Movie>) movieDAO.getTop();
        return top;
    }

    public void setTop5(List<Movie> top5) {
        this.top5 = top5;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public String showMovie(Movie movie) {
        this.movie = movie;
        return "movie";
    }

    @PostConstruct
    public void init() {
        movies = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return (List<Movie>) movieDAO.getAll();
    }

    public void setMovie(List<Movie> movie) {
        this.movies = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Review> getReviews() {
        return (List<Review>) movie.getReviews();
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
