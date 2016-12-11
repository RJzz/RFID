package controller;

import Service.DutyService;
import Service.KeeperService;
import Service.RFIDService;
import com.mysql.fabric.xmlrpc.base.Data;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Duty;
import model.Keeper;
import model.RFID;
import scene.AddScene;
import stage.AddStage;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

/**
 * Created by RJzz on 2016/12/8.
 */
public class AddController{
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

    @FXML
    protected void addConfirm() {
        //添加数据，首先检查数据是否符合规范
        if(rTag.getText().equals("") ||
                rName.getText().equals("") ||
                rId.getText().equals("") ||
                rKname.getText().equals("") ||
                rDname.getText().equals("") ||
                rDate.getEditor().getText().equals("") ||
                kPhone.getText().equals("") ||
                dPhone.getText().equals("")
                ){
            info.setText("请按要求填写");
            System.out.print("添加设备未满足规范性要求");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date b = sdf.parse(rDate.getEditor().getText());
                Date date = new Date(b.getTime());
                rfid = new RFID(rTag.getText(), rName.getText(), rId.getText(),
                        rType.getText(), rPosition.getText(), rKname.getText(), rDname.getText(), rDate.getEditor().getText());
                Keeper keeper = new Keeper(rKname.getText(), kEmail.getText(), kPhone.getText());
                Duty duty = new Duty(rDname.getText(), dEmail.getText(), dPhone.getText());
                rfid.setDuty(duty);
                rfid.setKeeper(keeper);
                if (new RFIDService().addRFID(rfid)) {
                    if(new DutyService().addDuty(duty) && new KeeperService().addKeeper(keeper)) {
                        info.setText("     添加成功");
                        System.out.print("插入结束，成功\n");
                    }
                } else {
                    info.setText("     添加失败");
                    System.out.print("插入失败");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void addCancel() {
        AddStage.getInstance().close();
    }

    public static RFID getRfid() {
        return rfid;
    }


}
