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
                rfid.getTag(),
                rfid.getName(),
                rfid.getId(),
                rfid.getPosition(),
                rfid.getType(),
                rfid.getKid(),
                rfid.getDid()
        };
        if(new SqlHelper().executeUpdate(sql, parameters, rfid.getrDate()) == 1) {
            isOK = true;
            System.out.print("插入设备成功\n");
        }
        return isOK;
    }

    //删除设备
    public boolean deleteRFID(RFID rfid) {
        boolean isOK = false;
        String sql = "delete from rfid where rTag=?";
        String[] parameters = {rfid.getTag()};
        if((new SqlHelper().executeUpdate(sql, parameters, null)) == 1) {
            isOK = true;
            System.out.println("删除设备成功");
        }
        return isOK;
    }

    //修改设备
    public boolean updateRFID(RFID rfid) {
        boolean isOK = false;
        String sql = "update rfid set rTag=?, rName=?, rId=?, rType=?, rPosition=?, rKId=?, rDId=?, rDate=?";
        String[] parameters = {
                null,
                rfid.getTag(),
                rfid.getName(),
                rfid.getId(),
                rfid.getPosition(),
                rfid.getType(),
                rfid.getKid(),
                rfid.getDid()
        };
        if(new SqlHelper().executeUpdate(sql, parameters, rfid.getrDate()) == 1) {
            isOK = true;
            System.out.println("修改设备成功");
        }
        return isOK;
    }

    //查询所有RFID
}
