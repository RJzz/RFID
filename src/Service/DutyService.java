package Service;

import model.Duty;
import utils.SqlHelper;

/**
 * Created by RJzz on 2016/12/3.
 */
public class DutyService {

    //增加责任人
    public boolean addDuty(Duty duty) {
        boolean isOk = false;
        String sql = "insert into dutyer values(?,?,?,?)";
        String parameters[] = {
                null,
                duty.getdName(),
                duty.getdEmail(),
                duty.getdPhone()
        };
        if (new SqlHelper().executeUpdate(sql, parameters, null) == 1) {
            isOk = true;
            System.out.println("插入责任人成功");
        }
        return isOk;
    }

    //修改责任人
    public boolean updateDuty(Duty duty) {
        boolean isOK = false;
        String sql = "update dutyer set dName=?, dEmail=?, dPhone";
        String parameters[] = {
                null,
                duty.getdName(),
                duty.getdEmail(),
                duty.getdPhone()
        };
        if(new SqlHelper().executeUpdate(sql, parameters, null) == 1) {
            isOK = true;
            System.out.println("修改责任人成功");
        }
        return isOK;
    }

}
