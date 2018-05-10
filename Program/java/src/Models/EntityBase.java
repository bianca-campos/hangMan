package Models;

import java.util.ArrayList;

public abstract class EntityBase {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract ArrayList<String> validate();
}
