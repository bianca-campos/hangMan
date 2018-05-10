package Models;

import java.util.ArrayList;

public class Category extends EntityBase{
    private String name;

    /**
     * Constructor
     * @param name of the category
     */
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    /**
     * getter
     * @return name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name of the category
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<String> validate() {
        ArrayList<String> msgList = new ArrayList<>();
        if (this.getName().length() <= 0){
            msgList.add("Category is required.");
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
