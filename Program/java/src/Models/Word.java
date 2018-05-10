package Models;

import java.util.ArrayList;

public class Word extends EntityBase {
    private String name;
    private String nameLevel;
    private String nameCategory;
    private int idCategory;
    private int idLevel;
    public Category category;
    public Level level;

    /**
     * Constructor
     */
    public Word(int id, String name, int idCategory, String nameCategory, int idLevel, String nameLevel) {
        this.id =id;
        this.name = name;
        this.category = new Category(idCategory, nameCategory);
        this.idCategory = idCategory;
        this.idLevel = idLevel;
        this.nameLevel = nameLevel;
        this.nameCategory = nameCategory;
        this.level = new Level(idLevel, nameLevel);
    }

    public Word() {

    }

    public Word(int id, String name) {
        this.id =id;
        this.name = name;
    }

    /**
     * getters
     */

    public String getName() {
        return name;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public Category getCategory() {
        return category;
    }



    /**
     * Setters
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public ArrayList<String> validate() {
        ArrayList<String> msgList = new ArrayList<>();
        if (this.getName().length() <= 0) {
            msgList.add("Word is required.");
        }
        return msgList;
    }
}

