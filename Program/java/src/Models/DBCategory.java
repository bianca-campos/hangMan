package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBCategory extends DataBase{

    public void insert(Category entity) {
        String query = "INSERT INTO category(name) VALUES (?)";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query); // creates a prepared statement based on your query string
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public void update(Category entity) {
        String query = "UPDATE category SET name = ? WHERE id = ?";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();

        } catch (SQLException e){

        }finally {
            this.closeConnection();
        }
    }

    public void delete(Category entity) {
        String query = "DELETE FROM category WHERE id  = ?";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public Category get(Category entity) {
        String query = "SELECT id, [name] FROM category WHERE id = ?";
        Category std = null;
        try {
            this.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); //Iterator
            while (rs.next()){
                 std = new Category(
                        rs.getInt("id"),
                        rs.getString("name"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return std;
    }

    public ArrayList<Category> getAll() {
        String query = "SELECT id, [name] FROM category";
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            this.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); //Iterator
            while (rs.next()){
                Category std = new Category(
                        rs.getInt("id"),
                        rs.getString("name"));
                categoryList.add(std);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return categoryList;
    }
}
