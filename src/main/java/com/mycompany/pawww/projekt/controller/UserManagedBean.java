/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.controller;

import com.mycompany.pawww.projekt.bean.UserDAO;
import com.mycompany.pawww.projekt.mail.SendMailEjb;
import com.mycompany.pawww.projekt.model.User;
import com.mycompany.pawww.projekt.model.UserGroup;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    @EJB
    private SendMailEjb sendMailEjb;

    @EJB
    UserDAO userDAO;

//    private final Logger log = LoggerFactory.getLogger(UserManagedBean.class);
    private User user;
    private UIComponent loginInput;
    private UIComponent passwordInput;
    private String login;
    private String email;
    private String password;
    private String password2;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UIComponent getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(UIComponent passwordInput) {
        this.passwordInput = passwordInput;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public UIComponent getLoginInput() {
        return loginInput;
    }

    public void setLoginInput(UIComponent loginInput) {
        this.loginInput = loginInput;
    }

    @PostConstruct
    public void init() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String add() {
        if (checkDuplicate() && checkPassword()) {
            User u = new User();
            u.setLogin(login);
            u.setPassword(password);
            u.setEmail(user.getEmail());
            UserGroup group = new UserGroup();
            group.setId(2L);
            u.setUserGroup(group);
            userDAO.create(u);
//            log.log(Level.FINE, "Successful register new account");
            return "index";
        }
//        log.log(Level.FINE, "Error during registration process");
        return "registration";
    }

    public String addJQuery() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User u = new User();
        u.setLogin(req.getParameter("login"));
        u.setPassword(req.getParameter("password"));
        u.setEmail(req.getParameter("email"));
        UserGroup group = new UserGroup();
        group.setId(2L);
        u.setUserGroup(group);
        userDAO.create(u);
//            log.log(Level.FINE, "Successful register new account");
        return "index.xhtml";

//        log.log(Level.FINE, "Error during registration process");
//        return "registration";
    }

    public String login() {
        user = userDAO.vaidateUsernamaPassword(user.getLogin(), user.getPassword());
        if (user.getLogin() == null) {
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm:login", new FacesMessage("Wrong login or password"));
//            log.log(Level.FINE, "Error during login process");

            return "login";
        }
        sendMailEjb.sendMail(user.getEmail(), "Login notification",
                "There was successful login to your account at "
                + new Date());
//        log.info("Successfully logged in");
        return "index";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        log.log(Level.FINE, "Successful logged out");
        return "index?faces-redirect=true";
    }

    public boolean checkDuplicate() {
        List<User> users = (List<User>) userDAO.getAll();
        for (User u : users) {
            if (login.equals(u.getLogin())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(loginInput.getClientId(),
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "The username already exists.", null));
//                log.log(Level.FINE, "Found duplicate username");
                return false;
            }
        }
        return true;
    }

    public boolean checkPassword() {
        if (!password.equals(password2)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(passwordInput.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords don't match.", null));
            return false;
        }
        return true;
    }
}
