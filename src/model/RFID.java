package model;

import java.sql.Date;

/**
 * Created by RJzz on 2016/12/3.
 */
public class RFID {
    private String rTag;    //标签号
    private String rName;   //设备名
    private String rId;     //设备ID
    private String rType;   //设备类型
    private String rPosition;   //存放位置
    private String rKId;        //保管人
    private String rDId;        //责任人
    private Date rDate;


    public RFID(String rTag, String rName, String rId, String rType, String rPosition, String rKId, String rDId, Date date) {
        this.rDate = date;
        this.rTag = rTag;
        this.rPosition = rPosition;
        this.rId = rId;
        this.rType = rType;
        this.rKId = rKId;
        this.rName = rName;
        this.rDId = rDId;
    }
    public Date getrDate() {
        return rDate;
    }

    public void setrTag(String rTag) {
        this.rTag = rTag;
    }

    public String getrId() {
        return rId;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getrPosition() {
        return rPosition;
    }

    public void setrDId(String rDId) {
        this.rDId = rDId;
    }


    public String getrTag() {
        return rTag;
    }

    public void setrKId(String rKId) {
        this.rKId = rKId;
    }


    public String getrDId() {
        return rDId;
    }


    public String getrType() {
        return rType;
    }

    public String getrKId() {
        return rKId;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }


    public void setrPosition(String rPosition) {
        this.rPosition = rPosition;
    }
}
