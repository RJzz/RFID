package controller;

import Service.RFIDService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import model.Duty;
import model.Keeper;
import model.RFID;
import sample.Main;
import stage.*;
import utils.SqlHelper;

import javax.naming.directory.SearchControls;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.zip.InflaterOutputStream;

/**
 * Created by RJzz on 2016/12/3.
 */
public class MainController implements Initializable{
    public boolean search = false;


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
        tableView.setRowFactory(new Callback<TableView<RFID>, TableRow<RFID>>() {
            @Override
            public TableRow<RFID> call(TableView<RFID> param) {
                return new TableRowControl();
            }
        });
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
            //封装keeper
            String sqlk = "select * from keeper where kName=?";
            String parameters[] = {
                    rfid.getKid()
            };
            Vector<Object[]> objectk = new SqlHelper().executeQuery(sqlk, parameters, null);
            Vector<Keeper> keepers = new Vector<>();
            Keeper keeper = new Keeper();
            for(int k = 0; k < objectk.size(); ++k) {
                Object[] objectks = objectk.get(k);

                keeper.setkName(objectks[0].toString());
                keeper.setKEmail(objectks[1].toString());
                keeper.setkPhone(objectks[2].toString());

            }
            rfid.setKeeper(keeper);
            //封装duty
            String sqld = "select * from dutyer where dName=?";
            String parameterd[] = {
                    rfid.getDid()
            };
            Vector<Object[]> objectd = new SqlHelper().executeQuery(sqlk, parameterd, null);
            Vector<Duty> dutyer = new Vector<>();
            Duty duty = new Duty();
            for(int k = 0; k < objectk.size(); ++k) {
                Object[] objectds = objectd.get(k);
                duty.setdName(objectds[0].toString());
                duty.setdEmail(objectds[1].toString());
                duty.setdPhone(objectds[2].toString());

            }
            rfid.setDuty(duty);
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


        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/search.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 400, 500);
        scene.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
        SearchStage.getInstance().setScene(scene);
        SearchStage.getInstance().setTitle("查找设备");
        SearchStage.getInstance().show();
        MainStage.getInstance().setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.print("main show");
            }
        });
        search = true;
        SearchStage.getInstance().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.print("Search over");

                if(SearchController.getSerach().size() != 0) {
                    ObservableList<RFID> rfidObservableList = tableView.getItems();
                    rfidObservableList.clear();
                    rfidObservableList.addAll(SearchController.getSerach());
                }
            }
        });
    }

    @FXML
    protected void updateRFID() {
        RFID rfid = tableView.getSelectionModel().getSelectedItem();
        if(rfid == null) {
            info.setText("请选中表中行后进行修改操作操作");
        }else {
            ObservableList<RFID> observableList = tableView.getItems();
            UpdateController.setRfid(rfid);
            //observableList.remove(tableView.getSelectionModel().getSelectedIndex());
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxml/update.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root, 400, 500);
            scene.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
            UpdateStage.getInstance().setScene(scene);
            UpdateStage.getInstance().setTitle("修改设备");
            UpdateStage.getInstance().show();
        }
    }

    @FXML
    protected void quit() {
        MainStage.getInstance().close();
    }
    class TableRowControl extends TableRow<RFID> {
        public TableRowControl() {
            super();
            this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton().equals(MouseButton.PRIMARY)
                            && event.getClickCount() == 2
                            && TableRowControl.this.getIndex() < tableView.getItems().size()) {
                        //双击行可以直接查看所有信息
                        InfoController.setRfid(tableView.getSelectionModel().getSelectedItem());
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("../fxml/info.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene scene = new Scene(root, 400, 500);
                        scene.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
                        DetailStage.getInstance().setScene(scene);
                        DetailStage.getInstance().setTitle("设备详情");
                        DetailStage.getInstance().show();
                        //MainStage.getInstance().showAndWait();
                    }
                }
            });
        }
    }

    public  TableView<RFID> getTableView() {
        return tableView;
    }

    public  void setTableView(TableView<RFID> tableView) {
        this.tableView = tableView;
    }



}
