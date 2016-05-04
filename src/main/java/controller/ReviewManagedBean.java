/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mycompany.pawww.projekt.bean.MovieDAO;
import com.mycompany.pawww.projekt.model.Movie;
import com.mycompany.pawww.projekt.model.Review;
import com.mycompany.pawww.projekt.model.User;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "movieReview")
@SessionScoped
public class ReviewManagedBean implements Serializable {

    @EJB
    MovieDAO movieDAO;

    private Movie movie;
    private Long currentId;
    private Review review;

    @PostConstruct
    public void init() {
        review = new Review();
    }

    public void loadData() {
        movie = movieDAO.getMovieById(currentId);
    }

    public String addReview(User user) {
        review.setMovie(movie);
        review.setReviewDate(new Date());
        review.setUser(user);

        movieDAO.addReview(review);
        
        return "movie?faces-redirect=true";
    }

    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
