package Service;

import model.Keeper;
import utils.SqlHelper;

/**
 * Created by RJzz on 2016/12/3.
 */
public class KeeperService {
    //添加管理员
    public boolean addKeeper(Keeper keeper) {
        boolean isOk = false;
        String sql = "insert into keeper values(?,?,?,?)";
        String parameters[] = {
                null,
                keeper.getkName(),
                keeper.getkPhone(),
                keeper.getKEmail()
        };
        if(new SqlHelper().executeUpdate(sql, parameters, null, 0) == 1) {
            isOk = true;
            System.out.println("插入Keeper表成功");
        }
        return isOk;
    }

    //删除管理员
    public boolean updatekeeper(Keeper keeper) {
        boolean isOK = false;
        String sql = "update keeper set kName=?, kEmail=?, kPhone=?";
        String parameters[] = {
                null,
                keeper.getkName(),
                keeper.getKEmail(),
                keeper.getkPhone()
        };
        if (new SqlHelper().executeUpdate(sql, parameters, null, 2) == 1) {
            isOK = true;
            System.out.print("修改keeper成功");
        }
        return isOK;
    }
}
