package Models;

import java.util.ArrayList;

public class Level extends EntityBase {
    private String name;
    private int minLetter;
    private int maxLetter;
    private int numTry;
    private int ptLetter;
    private int extraPt;



    /**
     * Constructor
     */

    public Level(int id, String name, int minLetter, int maxLetter, int numTry, int ptLetter, int extraPt) {
        this.id = id;
        this.name = name;
        this.minLetter = minLetter;
        this.maxLetter = maxLetter;
        this.numTry = numTry;
        this.ptLetter = ptLetter;
        this.extraPt = extraPt;
    }

    public Level(){

    }

    public Level(int id, String name){
        this.id = id;
        this.name = name;
    }


    /**
     * getters
     */

    public String getName() {
        return name;
    }

    public int getMinLetter() {
        return minLetter;
    }

    public int getMaxLetter() {
        return maxLetter;
    }

    public int getNumTry() {
        return numTry;
    }

    public int getPtLetter() {
        return ptLetter;
    }

    public int getExtraPt() {
        return extraPt;
    }



    /**
     * Setters
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setMinLetter(int minLetter) {
        this.minLetter = minLetter;
    }

    public void setMaxLetter(int maxLetter) {
        this.maxLetter = maxLetter;
    }

    public void setNumTry(int numTry) {
        this.numTry = numTry;
    }

    public void setPtLetter(int ptLetter) {
        this.ptLetter = ptLetter;
    }

    public void setExtraPt(int extraPt) {
        this.extraPt = extraPt;
    }



    @Override
    public ArrayList<String> validate() {
        ArrayList<String> msgList = new ArrayList<>();
        if (this.getName().length() <= 0) {
            msgList.add("Level is required.");
        }
        return msgList;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null){
            return this.hashCode() == obj.hashCode();
        }
        return false;
    }

}
