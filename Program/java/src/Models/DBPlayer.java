package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPlayer extends DataBase{

    public void insert(Player entity) {
        String query = "INSERT INTO player(name) VALUES (?)";
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

    public Player get(Player entity) {
        String query = "SELECT id, [name] FROM player WHERE id = ?";
        Player std = null;
        try {
            this.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); //Iterator
            while (rs.next()){
                std = new Player(
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
}
