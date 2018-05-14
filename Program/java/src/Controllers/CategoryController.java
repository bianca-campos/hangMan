package Controllers;

import Models.Category;
import Models.DBCategory;
import Models.iScreenTemplate;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView.TableViewSelectionModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class CategoryController implements iScreenTemplate, Initializable {
    @FXML
    private JFXTextField txtCategory;
    @FXML
    private Label categoryLb;
    @FXML
    private TableView<Category> categoryTv;
    @FXML
    private TableColumn<Category, String> colCategory;
    @FXML
    private TableRow<String> categoryTr;
    int selectedId = 0;


    @Override
    public void btnOk_Click(ActionEvent actionEvent) {
        DBCategory dbcategory = new DBCategory();
        Category category = new Category();
        category.setName(txtCategory.getText());
        ArrayList<String> msgList = category.validate();
        if (msgList.size() == 0) {
            if (selectedId == 0) {
                dbcategory.insert(category);
                tableView_Load();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to edit the category?", ButtonType.OK, ButtonType.CANCEL);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    category.setId(selectedId);
                    dbcategory.update(category);
                    selectedId = 0;
            }
                tableView_Load();
                clearTxt();
                if (result.get() == ButtonType.CANCEL){
                    clearTxt();
                }
            }
        }
    }

    @Override
    public void btnEdit_Click(ActionEvent actionEvent) {
        txtCategory.setDisable(false);
    }

    @Override
    public void btnCancel_Click(ActionEvent actionEvent) {
        clearTxt();
        selectedId = 0;
        txtCategory.setDisable(false);
    }

    public void clearTxt() {
        txtCategory.setText(null);
    }



    @Override
    public void btnDelete_Click(ActionEvent actionEvent) {
        DBCategory dbcategory = new DBCategory();
        TableViewSelectionModel tsm = categoryTv.getSelectionModel();
        Category category = (Category) tsm.getSelectedItem();
        if (selectedId != 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete the category?", ButtonType.OK, ButtonType.CANCEL);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                dbcategory.delete(category);
                tableView_Load();
                clearTxt();
                txtCategory.setDisable(false);
            }
            if (result.get() == ButtonType.CANCEL){
                clearTxt();
                txtCategory.setDisable(false);
            }
        }
    }


    @FXML
    public void tableView_Click() {
        TableViewSelectionModel tsm = categoryTv.getSelectionModel();
        if (!tsm.isEmpty())
        {
            Category category = (Category)tsm.getSelectedItem();
            txtCategory.setText(category.getName());
            selectedId = category.getId();
            txtCategory.setDisable(true);
        }
    }

    @Override
    public void tableView_Load() {
        DBCategory dbcategory = new DBCategory();
        colCategory.setCellValueFactory((new PropertyValueFactory<>("name")));
        categoryTv.getItems().setAll(dbcategory.getAll());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView_Load();
//        colCategory.setCellValueFactory(
//                new PropertyValueFactory<>("name"));
//        listData = FXCollections.observableArrayList();
    }

//        NumberValidator numValidator = new NumberValidator(); TODO number validator
//        categoryTf.getValidators().add(numValidator);
//        numValidator.setMessage("Only numbers");
//        categoryTf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                if (!newValue){
//                    categoryTf.validate();
//                }
//            }
//        });

    }






