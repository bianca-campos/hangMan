package Controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

import java.awt.*;
import java.awt.event.ActionEvent;


public class MenuController {
    @FXML
    private Menu menuManager;
    @FXML
    private MenuItem mItemCategory;
    @FXML
    private MenuItem mItemLevel;
    @FXML
    private MenuItem mItemHangMan;
    @FXML
    private MenuItem mItemWord;

    Menu managerMenu = new Menu("Manager");

    MenuItem category = new MenuItem("Category");


}



