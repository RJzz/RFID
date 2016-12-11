package controller;

import Service.RFIDService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RFID;
import sample.Main;
import stage.AddStage;
import stage.MainStage;
import utils.SqlHelper;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by RJzz on 2016/12/3.
 */
public class MainController implements Initializable{
    @FXML private TableView<RFID> tableView;
    @FXML private TableColumn rTag;
    @FXML private TableColumn rName;
    @FXML private TableColumn rPosition;
    @FXML private TableColumn rType;
    @FXML private TableColumn rId;
    @FXML private TableColumn rDate;
    @FXML private TableColumn keeper;
    @FXML private TableColumn dutyer;
    @FXML private Text info;

    @FXML
    protected void addRFID(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/add.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 400, 500);
        scene.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
        AddStage.getInstance().setScene(scene);
        AddStage.getInstance().setTitle("添加设备");
        AddStage.getInstance().show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //初始化的时候将
        findAllRFID();
    }

    public void showList() {
        ObservableList<RFID> list = tableView.getItems();
        RFID rfid = new RFID();
        rfid.setId("1");
        rfid.setTag("1");
        rfid.setName("1");
        rfid.setType("1");
        rfid.setKid("1");
        rfid.setDataString("2014-11-11");
        rfid.setDid("1");
        rfid.setPosition("你大爷");
        TableColumn kName = new TableColumn("姓名");
        TableColumn kEmail = new TableColumn("邮箱");
        TableColumn kPhone = new TableColumn("电话");
        RFID rfid1 = new RFID("122","122","122","122","122","122","122","2014-12-11");

        list.add(rfid);
        list.add(rfid1);
    }
    @FXML
    protected void findAllRFID() {
        ObservableList<RFID> observableList = tableView.getItems();
        observableList.clear();
        //data.add(AddController.getRfid());
        String sql = "select * from rfid";
        Vector<Object[]> objects = new SqlHelper().executeQuery(sql, null, null);
        Vector<RFID> rfids = new Vector<>();
        for(int i = 0; i < objects.size(); ++i) {
            Object[] object = objects.get(i);
            //封装RFID类型对象
            RFID rfid = new RFID();
            for(int j = 0; j < object.length; ++j) {
                rfid.setTag(object[0].toString());
                rfid.setName(object[1].toString());
                rfid.setId(object[2].toString());
                rfid.setType(object[3].toString());
                rfid.setPosition(object[4].toString());
                rfid.setKid(object[5].toString());
                rfid.setDid(object[6].toString());
                rfid.setrDate((Date) object[7]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dates = (Date) object[7];
                rfid.setDataString(simpleDateFormat.format(dates));
            }

            observableList.add(rfid);
        }
    }

    @FXML
    protected void deleteRFID() {
        RFID rfid = tableView.getSelectionModel().getSelectedItem();
        if(rfid == null) {
            info.setText("请选中表中行后进行删除操作");
        }else {
            ObservableList<RFID> observableList = tableView.getItems();
            if(new RFIDService().deleteRFID(rfid)) {
                System.out.println("删除成功");
                observableList.remove(tableView.getSelectionModel().getSelectedIndex());
            }else {
                System.out.print("删除失败\n");
            }

        }
    }

    @FXML
    protected void searchRFID() {


        ObservableList<RFID> data = tableView.getItems();
        data.add(new RFID("1", "1", "1", "1", "1", "1", "1", "2013-12-11"));
    }

    @FXML
    protected void quit() {
        MainStage.getInstance().close();
    }
}
