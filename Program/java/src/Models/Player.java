package Models;

import java.util.ArrayList;

public class Player extends EntityBase{
    private String name;

    /**
     * Constructor
     * @param name of the player
     */
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(int id) {
        this.id = id;
    }

    public Player(){

    }

    /**
     * getter
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<String> validate() {
        ArrayList<String> msgList = new ArrayList<>();
        if (this.getName().length() <= 0){
            msgList.add("Player is required.");
        }
        return msgList;
    }
}
