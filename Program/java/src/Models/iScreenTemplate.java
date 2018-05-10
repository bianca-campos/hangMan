package Models;

import javafx.event.ActionEvent;

import java.awt.event.MouseEvent;

/**
 * @author biancacampos
 */

public interface iScreenTemplate {
    void btnOk_Click(ActionEvent actionEvent);
    void btnEdit_Click(ActionEvent actionEvent);
    void btnCancel_Click(ActionEvent actionEvent);
    void btnDelete_Click(ActionEvent actionEvent);
    void tableView_Click();
    void tableView_Load();
}
