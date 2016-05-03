/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.User;

/**
 *
 * @author Adam Wasilczuk
 */
public interface UserDAO {
    public User vaidateUsernamaPassword(String login, String password);
    public void create(User user);
}
