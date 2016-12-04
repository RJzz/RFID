package Service;

import model.RFID;
import utils.SqlHelper;

/**
 * Created by RJzz on 2016/12/3.
 */
public class RFIDService {
    //添加RFID设备
    public boolean addRFID(RFID rfid) {
        boolean isOK = false;
        String sql = "insert into rfid values(?,?,?,?,?,?,?,?,?)";
        String parameters[] = {
                null,
                rfid.getrTag(),
                rfid.getrName(),
                rfid.getrId(),
                rfid.getrPosition(),
                rfid.getrType(),
                rfid.getrKId(),
                rfid.getrDId()
        };
        if(new SqlHelper().executeUpdate(sql, parameters) == 1) {
            isOK = true;
        }
        return isOK;
    }

    //删除设备
    public boolean deleteRFID(RFID rfid) {
        boolean isOK = false;
        String sql = "delete from rfid where rTag=?";
        String[] parameters = {rfid.getrTag()};
        if((new SqlHelper().executeUpdate(sql, parameters)) == 1) {
            isOK = true;
        }
        return isOK;
    }

    //修改设备
    public boolean updateRFID(RFID rfid) {
        boolean isOK = false;
        String sql = "update rfid set rTag=?, rName=?, rId=?, rType=?, rPosition=?, rKId=?, rDId=?, rDate=?";
        String[] parameters = {
                null,
                rfid.getrTag(),
                rfid.getrName(),
                rfid.getrId(),
                rfid.getrPosition(),
                rfid.getrType(),
                rfid.getrKId(),
                rfid.getrDId()
        };
        if(new SqlHelper().executeUpdate(sql, parameters) == 1) {
            isOK = true;
        }
        return isOK;
    }
}
