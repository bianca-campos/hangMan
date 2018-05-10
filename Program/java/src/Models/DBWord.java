package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBWord extends DataBase{

    public void insert(Word entity){
        String query = "INSERT INTO word(name, idCategory, idLevel) VALUES (?, ?, ?)";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query); // creates a prepared statement based on your query string
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getIdCategory());
            pstmt.setInt(3, entity.getIdLevel());

            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public void update(Word entity) {
        String query = "UPDATE word SET name = ?, idCategory = ?, idLevel = ? WHERE id = ?";
        try {
            this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getIdCategory());
            pstmt.setInt(3, entity.getIdLevel());
            pstmt.setInt(4, entity.getId());
            pstmt.executeUpdate();

        } catch (SQLException e){

        }finally {
            this.closeConnection();
        }
    }

    public void delete(Word entity) {
        String query = "DELETE FROM word WHERE id  = ?";
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

    public ArrayList<Word> getAll() {
        String query = "SELECT word.id id, word.name, IdCategory,category.name nameCategory, IdLevel, level.name nameLevel FROM word, category, level WHERE word.idCategory = category.id and word.idLevel = level.id";
        ArrayList<Word> wordList = new ArrayList<>();
        try {
            this.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); //Iterator
            while (rs.next()){
                Word std = new Word(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("IdCategory"),
                        rs.getString("nameCategory"),
                        rs.getInt("IdLevel"),
                        rs.getString("nameLevel"));
                wordList.add(std);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return wordList;
    }

    public ArrayList<Word> getByCategoryLevel(Word entity) {
        String query = "SELECT id, word.name name FROM word WHERE idCategory = ? and idLevel = ?";
        ArrayList<Word> wordList = new ArrayList<>();
        try {
            this.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, entity.getIdCategory());
            stmt.setInt(2, entity.getIdLevel());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Word std = new Word(
                        rs.getInt("id"),
                        rs.getString("name"));
                wordList.add(std);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
        return wordList;
    }

}
