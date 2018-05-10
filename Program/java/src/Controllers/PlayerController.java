package Controllers;


import Models.DBPlayer;
import Models.Player;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.ArrayList;



public class PlayerController {
    @FXML
    private JFXTextField txtPlayer;
    public Stage stage;
    public String name;

    public void btnOk_Click(ActionEvent actionEvent) {
        DBPlayer dbplayer = new DBPlayer();
        Player player = new Player();
        player.setName(txtPlayer.getText());
        ArrayList<String> msgList = player.validate();
        if (msgList.size() == 0) {
                dbplayer.insert(player);
                name = player.getName();
                if(stage != null){
                    stage.close();
                }

            }
    }


    public void btnCancel_Click(ActionEvent actionEvent) {
        txtPlayer.setText(null);
        if(stage != null){
            stage.close();
        }
    }
}
