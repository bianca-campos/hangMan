package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBScore extends DataBase{


    public void insert(Score entity){
        String query = "INSERT INTO score(score, idPlayer) VALUES (?, ?)";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query); // creates a prepared statement based on your query string
            pstmt.setInt(1, entity.getScore());
            pstmt.setInt(2, entity.getIdPlayer());

            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public Score highScore() {
        String query = "SELECT score.id, score.score score, score.idPlayer idPlayer, player.name name FROM score, player WHERE score.idPlayer = player.id order by score desc LIMIT 1";
        try {
            this.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Score std = new Score(
                        rs.getInt("id"),
                        rs.getInt("score"),
                        rs.getInt("idPlayer"),
                        rs.getString("name"));
                return std;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return null;
    }

    public Player getLastPlayer() {
    String query = "SELECT player.id id, player.name name FROM player order by id desc LIMIT 1";
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
