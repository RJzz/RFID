package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.RFID;
import stage.AddStage;

import java.io.IOException;

/**
 * Created by RJzz on 2016/12/3.
 */
public class MainController{
    @FXML private TableView<RFID> tableView;
    @FXML private TextField textField;
    @FXML private TextField textField1;
    @FXML private TextField textField2;

    @FXML
    protected void addRFID(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/add.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 400, 500);
        AddStage.getInstance().setScene(scene);
        AddStage.getInstance().setTitle("添加设备");
        AddStage.getInstance().show();

    }
}
