package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBLevel extends DataBase {

    public void insert(Level entity){
        String query = "INSERT INTO level(name, minLetter, maxLetter, numTry, pointsLetter, extraPoints) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query); // creates a prepared statement based on your query string
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getMinLetter());
            pstmt.setInt(3, entity.getMaxLetter());
            pstmt.setInt(4, entity.getNumTry());
            pstmt.setInt(5, entity.getPtLetter());
            pstmt.setInt(6, entity.getExtraPt());
            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public void update(Level entity) {
        String query = "UPDATE level SET name = ?, minLetter = ?, maxLetter = ?, numTry = ?, pointsLetter = ?, extraPoints = ? WHERE id = ?";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getMinLetter());
            pstmt.setInt(3, entity.getMaxLetter());
            pstmt.setInt(4, entity.getNumTry());
            pstmt.setInt(5, entity.getPtLetter());
            pstmt.setInt(6, entity.getExtraPt());
            pstmt.setInt(7, entity.getId());
            pstmt.executeUpdate();

        } catch (Exception e){

        }finally {
            this.closeConnection();
        }
    }

    public void delete(Level entity) {
        String query = "DELETE FROM level WHERE id  = ?";
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

    public ArrayList<Level> getAll(){
        String query = "SELECT id, [name], minLetter, maxLetter, numTry, pointsLetter, extraPoints FROM level";
        ArrayList<Level> levelList = new ArrayList<>();
        try {
            this.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); //Iterator
            while (rs.next()){
                Level std = new Level(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minLetter"),
                        rs.getInt("maxLetter"),
                        rs.getInt("numTry"),
                        rs.getInt("pointsLetter"),
                        rs.getInt("extraPoints"));
                levelList.add(std);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return levelList;
    }
}
