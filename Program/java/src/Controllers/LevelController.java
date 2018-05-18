package Controllers;

import Models.*;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class LevelController implements iScreenTemplate, Initializable {
    @FXML
    private JFXTextField txtLevel;
    @FXML
    private JFXTextField txtMinLetter;
    @FXML
    private JFXTextField txtMaxLetter;
    @FXML
    private JFXTextField txtNumTry;
    @FXML
    private JFXTextField txtPtLetter;
    @FXML
    private JFXTextField txtExtraPt;
    @FXML
    private TableView<Level> levelTv;
    @FXML
    private TableColumn<Level, String> colLevel;
    @FXML
    private TableColumn<Level, Integer> colMinLetter;
    @FXML
    private TableColumn<Level, Integer> colMaxLetter;
    @FXML
    private TableColumn<Level, String> colNumTry;
    @FXML
    private TableColumn<Level, Integer> colPtLetter;
    @FXML
    private TableColumn<Level, Integer> colExtraPt;
    int selectedId = 0;

    @Override
    public void btnOk_Click(ActionEvent actionEvent) {
        DBLevel dblevel = new DBLevel();
        Level level = new Level();
        level.setName(txtLevel.getText());
        level.setMinLetter(Integer.parseInt(txtMinLetter.getText()));
        level.setMaxLetter(Integer.parseInt(txtMaxLetter.getText()));
        level.setNumTry(Integer.parseInt(txtNumTry.getText()));
        level.setPtLetter(Integer.parseInt(txtPtLetter.getText()));
        level.setExtraPt(Integer.parseInt(txtExtraPt.getText()));
        ArrayList<String> msgList = level.validate();
        if (msgList.size() == 0) {
            if (selectedId == 0) {
                dblevel.insert(level);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to edit the Level?", ButtonType.OK, ButtonType.CANCEL);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    level.setId(selectedId);
                    dblevel.update(level);
                    selectedId = 0;
                }
                if (result.get() == ButtonType.CANCEL) {
                    selectedId = 0;
                }
            }
            tableView_Load();
            clearTxt();
        }
    }

    @Override
    public void btnEdit_Click(ActionEvent actionEvent) {
        enableFields();
    }


    @Override
    public void btnCancel_Click(ActionEvent actionEvent) {
        clearTxt();
        selectedId = 0;
        enableFields();
    }

    @Override
    public void btnDelete_Click(ActionEvent actionEvent) {
        DBLevel dblevel = new DBLevel();
        TableView.TableViewSelectionModel tsm = levelTv.getSelectionModel();
        Level level = (Level) tsm.getSelectedItem();
        if (selectedId != 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete the Level?", ButtonType.OK, ButtonType.CANCEL);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                dblevel.delete(level);
                tableView_Load();
            }
            selectedId = 0;
            clearTxt();
            enableFields();
        }
    }

    public void enableFields() {
        txtLevel.setDisable(false);
        txtMinLetter.setDisable(false);
        txtMaxLetter.setDisable(false);
        txtNumTry.setDisable(false);
        txtPtLetter.setDisable(false);
        txtExtraPt.setDisable(false);
    }

    public void clearTxt() {
        txtLevel.setText(null);
        txtMinLetter.setText(null);
        txtMaxLetter.setText(null);
        txtNumTry.setText(null);
        txtPtLetter.setText(null);
        txtExtraPt.setText(null);

    }

    @Override
    public void tableView_Click() {
        TableView.TableViewSelectionModel tsm = levelTv.getSelectionModel();
        if (!tsm.isEmpty())
        {
            Level level = (Level) tsm.getSelectedItem();
            txtLevel.setText(level.getName());
            txtMinLetter.setText(String.valueOf(level.getMinLetter()));
            txtMaxLetter.setText(String.valueOf(level.getMaxLetter()));
            txtNumTry.setText(String.valueOf(level.getNumTry()));
            txtPtLetter.setText(String.valueOf(level.getPtLetter()));
            txtExtraPt.setText(String.valueOf(level.getExtraPt()));
            selectedId = level.getId();
            txtLevel.setDisable(true);
            txtMinLetter.setDisable(true);
            txtMaxLetter.setDisable(true);
            txtNumTry.setDisable(true);
            txtPtLetter.setDisable(true);
            txtExtraPt.setDisable(true);
        }
    }

    public void txtValidate(){

    }


    @Override
    public void tableView_Load() {
        DBLevel dblevel = new DBLevel();
        colLevel.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMinLetter.setCellValueFactory(new PropertyValueFactory<>("minLetter"));
        colMaxLetter.setCellValueFactory(new PropertyValueFactory<>("maxLetter"));
        colNumTry.setCellValueFactory(new PropertyValueFactory<>("numTry"));
        colPtLetter.setCellValueFactory(new PropertyValueFactory<>("ptLetter"));
        colExtraPt.setCellValueFactory(new PropertyValueFactory<>("extraPt"));
        levelTv.getItems().setAll(dblevel.getAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView_Load();

    }
}
