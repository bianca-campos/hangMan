package Controllers;

import Models.*;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.util.StringConverter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WordController implements iScreenTemplate, Initializable{
    @FXML
    private JFXTextField txtWord;
    @FXML
    ComboBox<Category> comCategory = new ComboBox<Category>();
    @FXML
    ComboBox<Models.Level> comlLevel = new ComboBox<Models.Level>();
    @FXML
    private TableView<Word> wordTv;
    @FXML
    private TableColumn<Word, String> colWord;
    @FXML
    private TableColumn<Word, String> colCategory;
    @FXML
    private TableColumn<Word, String> colLevel;
    int selectedId = 0;



    @Override
    public void btnOk_Click(ActionEvent actionEvent) {
        DBWord dbword = new DBWord();
        Word word = new Word();
        word.setName(txtWord.getText());
        word.setIdCategory(comCategory.getValue().getId());
        word.setIdLevel(comlLevel.getValue().getId());
        ArrayList<String> msgList = word.validate();
        if (msgList.size() == 0){
            if (selectedId == 0){
                dbword.insert(word);
            } else {
                word.setId(selectedId);
                dbword.update(word);
                selectedId = 0;
            }
            tableView_Load();
            clearTxt();
        }
    }

    @Override
    public void btnEdit_Click(ActionEvent actionEvent) {
        txtWord.setDisable(false);
        comCategory.setDisable(false);
        comlLevel.setDisable(false);
    }

    @Override
    public void btnCancel_Click(ActionEvent actionEvent) {
        clearTxt();
        selectedId = 0;
        txtWord.setDisable(false);
        comCategory.setDisable(false);
        comlLevel.setDisable(false);
    }

    public void clearTxt() {
        txtWord.setText(null);
        comCategory.valueProperty().set(null);
        comlLevel.valueProperty().set(null);
    }

    @Override
    public void btnDelete_Click(ActionEvent actionEvent) {
        DBWord dbWord = new DBWord();
        TableViewSelectionModel tsm = wordTv.getSelectionModel();
        Word word = (Word) tsm.getSelectedItem();
        if (selectedId != 0) {
            dbWord.delete(word);
            tableView_Load();
            clearTxt();
        }
    }

    @Override
    public void tableView_Click() {
        TableViewSelectionModel tsm = wordTv.getSelectionModel();
        if (!tsm.isEmpty())
        {
            Word word = (Word) tsm.getSelectedItem();
            txtWord.setText(word.getName());
            comCategory.getSelectionModel().select(word.category);
            comlLevel.getSelectionModel().select(word.level);
            selectedId = word.getId();
            txtWord.setDisable(true);
            comCategory.setDisable(true);
            comlLevel.setDisable(true);
        }
    }


    @Override
    public void tableView_Load() {
        DBWord dbWord = new DBWord();
        colWord.setCellValueFactory((new PropertyValueFactory<>("name")));
        colCategory.setCellValueFactory((new PropertyValueFactory<>("nameCategory")));
        colLevel.setCellValueFactory((new PropertyValueFactory<>("nameLevel")));
        wordTv.getItems().setAll(dbWord.getAll());
    }

    public void comCategory_Load(){
            DBCategory dbcategory = new DBCategory();
            comCategory.getItems().setAll(dbcategory.getAll());
            comCategory.setConverter(new StringConverter<Category>() {
                @Override
                public String toString(Category object) {
                    if (object != null){
                        return object.getName();
                    }
                    return null;
                }

                @Override
                public Category fromString(String string) {
                    return null;
                }
            });
    }

    public void comLevel_Load(){
        DBLevel dblevel = new DBLevel();
        comlLevel.getItems().setAll(dblevel.getAll());
        comlLevel.setConverter(new StringConverter<Level>() {
            @Override
            public String toString(Level object) {
                if (object != null){
                    return object.getName();
                }
                return null;
            }

            @Override
            public Level fromString(String string) {
                return null;
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView_Load();
        comCategory_Load();
        comLevel_Load();
    }

}
