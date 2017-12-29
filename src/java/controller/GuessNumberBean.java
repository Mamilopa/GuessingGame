package controller;

import java.io.Serializable;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "guessNumberBean")//how we refer to this class from xhtml
@SessionScoped
public class GuessNumberBean implements Serializable {

    private int RANDOMNUMBER;
    private int max = 10;
    private int min = 1;
    private int userGuess;
    private String response;
    private String image;

    public GuessNumberBean() {
        Random random = new Random();
        RANDOMNUMBER = random.nextInt(max) + 1;
    }

    public String reset() {//to reset and start a new game
        RANDOMNUMBER=0;
        Random random = new Random();
        RANDOMNUMBER = random.nextInt(max) + 1;
        return "index";
    }

    public String getResponse() {

        if (userGuess == RANDOMNUMBER) {
            return "You are right!";
        } else if (userGuess < RANDOMNUMBER) {
            return "Number is too low";
        } else {
            return "Number is too high";
        }

    }

    public String getImage() {

        if (userGuess == RANDOMNUMBER) {
            return "resources/img/correct.gif";
        } else {
            return "resources/img/wrong.gif";
        }
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

}
