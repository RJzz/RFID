package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.RFID;

/**
 * Created by RJzz on 2016/12/11.
 */
public class UpdateController {
    @FXML private TextField rTag;
    @FXML private TextField rName;
    @FXML private TextField rId;
    @FXML private TextField rType;
    @FXML private TextField rPosition;

    @FXML private TextField rDname;
    @FXML private TextField rKname;
    @FXML private DatePicker rDate;
    @FXML private TextField kPhone;
    @FXML private TextField kEmail;
    @FXML private TextField dPhone;
    @FXML private TextField dEmail;
    @FXML private Text info;
    public static RFID rfid = null;
}
