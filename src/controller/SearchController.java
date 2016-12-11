package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Duty;
import model.Keeper;
import model.RFID;
import stage.SearchStage;
import utils.SqlHelper;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by RJzz on 2016/12/11.
 */
public class SearchController implements Initializable{

    public static RFID rfid;

    public static RFID getRfid() {
        return rfid;
    }

    public static void setRfid(RFID rfid) {
        SearchController.rfid = rfid;
    }

    @FXML
    private TextField rTag;
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

    public static Vector<RFID> serach = new Vector<>();

    public static Vector<RFID> getSerach() {
        return serach;
    }

    public static void setSerach(Vector<RFID> serach) {
        SearchController.serach = serach;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void addConfirm() {
        serach.clear();
        serach = findAllRFID();
        if(serach.size() != 0) {
            info.setText("查询成功");
            SearchStage.getInstance().close();
        }else {
            info.setText("为查询到相关条目");
        }
    }

    @FXML
    protected void addCancel() {
        SearchStage.getInstance().close();
    }
    private Vector<RFID>  findAllRFID() {
        //data.add(AddController.getRfid());
        StringBuffer sql = new StringBuffer("select * from rfid where");
        //标签
        if(!rTag.getText().equals("")){
            sql.append(" rTag like \'%" + rTag.getText() + "%\'");
        }
        //类型
        if(!rType.getText().equals("")){
            sql.append(" or rType like \'%" + rType.getText() + "%\'");
        }
        //位置
        if(!rPosition.getText().equals("")){
            sql.append(" or rPosition like \'%" + rPosition.getText() + "%\'");
        }
        //id
        if(!rId.getText().equals("")){
            sql.append(" or rId like \'%" + rId.getText() + "%\'");
        }
        //名字
        if(!rName.getText().equals("")){
            sql.append(" or rName like \'%" + rName.getText() + "%\'");
        }
        //保管人
        if(!rKname.getText().equals("")){
            sql.append(" or rKname like \'%" + rKname.getText() + "%\'");
        }
        //责任人
        if(!rDname.getText().equals("")){
            sql.append(" or rDname like \'%" + rDname.getText() + "%\'");
        }


        Vector<Object[]> objects = new SqlHelper().executeQuery(sql.toString(), null, null);
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
            rfids.add(rfid);
        }
        return rfids;
    }
}
