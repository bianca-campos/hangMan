package Models;

import java.util.ArrayList;

public class Score extends EntityBase{
    private int score;
    private int idPlayer;
    private String namePlayer;

    /**
     * Constructor
     */
    public Score(int id, int score, int idPlayer, String namePlayer) {
        this.id = id;
        this.score = score;
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
    }

    public Score(){

    }

    /**
     * getters
     */
    public int getScore() {
        return score;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }



    /**
     * Setters
     */

    public void setScore(int score) {
        this.score = score;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    @Override
    public ArrayList<String> validate() {
        return null;
    }
}
