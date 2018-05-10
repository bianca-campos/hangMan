package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception{

            // Category
//            Parent root = FXMLLoader.load(getClass().getResource("../Views/category.fxml"));
//            primaryStage.setTitle("Category");
//            Scene mainScene = new Scene(root, 840, 600);

//            // Level
//            Parent root = FXMLLoader.load(getClass().getResource("../Views/Level.fxml"));
//            primaryStage.setTitle("Level");
//            Scene mainScene = new Scene(root, 840, 600);
//
            // Word
//            Parent root = FXMLLoader.load(getClass().getResource("../Views/word.fxml"));
//            primaryStage.setTitle("Word");
//            Scene mainScene = new Scene(root, 840, 600);
//
//            // Game
            Parent root = FXMLLoader.load(getClass().getResource("../Views/hangManGame.fxml"));
            primaryStage.setTitle("HangManGame");
            Scene mainScene = new Scene(root, 900, 620);




            mainScene.getStylesheets().add("Style/style.css");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }
