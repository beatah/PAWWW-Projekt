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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Beata
 */
@Entity
@NamedQuery(name = "User.validateLogin", 
        query = "SELECT u FROM User u "
                + "WHERE u.login = :login AND u.password = :password")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private String login;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Collection<Review> reviews;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Collection<UserRating> ratings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }


    
}
