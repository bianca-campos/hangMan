package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    // 1. Connect to database
    Connection conn;


    /**
     * Connect to the database
     *
     */

    public void openConnection() {
        conn = null;
        try {
            String url = "jdbc:sqlite:src/hangMan.db";
//            String url = "jdbc:sqlite::resource:hangMan.db";
            conn = DriverManager.getConnection(url); // connect to the db
            System.out.println("Connection to SQLite hangMan.db has been established.");
        } catch(SQLException e){
            e.printStackTrace(); // prints Exception message
        }

    }

    /**
     * Close the connection to the database
     *
     */
    public void closeConnection() {
        try{
            if (conn!= null){
                conn.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
