/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "parserController")
@RequestScoped
public class ParserController {

    private String output;
    private String title;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String titleSubmit() {
        StringBuilder apiUrl = new StringBuilder("http://www.omdbapi.com/?s=");
        apiUrl.append(title);
        output = CallURL.callURL(apiUrl.toString());
        return "titlelist";
    }

}
