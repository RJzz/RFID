package controller;

import Service.DutyService;
import Service.KeeperService;
import Service.RFIDService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Duty;
import model.Keeper;
import model.RFID;
import stage.AddStage;
import stage.UpdateStage;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Created by RJzz on 2016/12/11.
 */
public class UpdateController implements Initializable{
    @FXML private TextField rTag;
    @FXML private TextField rName;
    @FXML private TextField rId;
    @FXML private TextField rType;
    @FXML private TextField rPosition;

    @FXML private TextField rDname;
    @FXML private TextField rKname;
    @FXML private DatePicker rDate;
    @FXML private Text info;
    public static RFID rfid = null;

    @FXML
    protected void addConfirm() {
        //添加数据，首先检查数据是否符合规范
        if(rName.getText().equals("") ||
                rId.getText().equals("") ||
                rKname.getText().equals("") ||
                rDname.getText().equals("") ||
                rDate.getEditor().getText().equals("")
                ){
            info.setText("请按要求填写");
            System.out.print("添加设备未满足规范性要求");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            rfid.setName(rName.getText());
            rfid.setId(rId.getText());
            rfid.setKid(rKname.getText());
            rfid.setDataString(rDate.getEditor().getText());
            rfid.setDid(rDname.getText());
            rfid.setType(rType.getText());
            rfid.setPosition(rPosition.getText());

            if (new RFIDService().updateRFID(rfid)) {
                info.setText("更新成功");
                System.out.print("     更新成功，成功\n");
            } else {
                info.setText("     更新失败");
                System.out.print("更新失败");
            }

        }
    }

    @FXML
    protected void addCancel() {
        UpdateStage.getInstance().close();
    }

    public static RFID getRfid() {
        return rfid;
    }

    public static void setRfid(RFID rfid) {
        UpdateController.rfid = rfid;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rName.setText(rfid.getName());
        rId.setText(rfid.getId());
        rType.setText(rfid.getType());
        rPosition.setText(rfid.getPosition());
        rDname.setText(rfid.getDuty().getdName());
        rKname.setText(rfid.getKeeper().getkName());
        rDate.getEditor().setText(rfid.getDataString());
    }
}
