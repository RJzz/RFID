package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.RFID;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by RJzz on 2016/12/11.
 */
public class InfoController implements Initializable{
    @FXML private Text tag;
    @FXML private Text name;
    @FXML private Text id;
    @FXML private Text type;
    @FXML private Text position;
    @FXML private Text dname;
    @FXML private Text kname;
    @FXML private Text date;
    @FXML private Text kphone;
    @FXML private Text kemail;
    @FXML private Text dphone;
    @FXML private Text demail;
    @FXML private Text info;

    public static RFID rfid;

    public static RFID getRfid() {
        return rfid;
    }

    public static void setRfid(RFID rfid) {
        InfoController.rfid = rfid;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tag.setText(rfid.getTag());
        name.setText(rfid.getName());
        type.setText(rfid.getType());
        position.setText(rfid.getPosition());
        id.setText(rfid.getId());
        kemail.setText(rfid.getKeeper().getKEmail());
        kphone.setText(rfid.getKeeper().getkPhone());
        demail.setText(rfid.getDuty().getdEmail());
        dphone.setText(rfid.getDuty().getdPhone());
        dname.setText(rfid.getDuty().getdName());
        kname.setText(rfid.getKeeper().getkName());
        date.setText(rfid.getDataString());
    }
}
