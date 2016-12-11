package stage;

import javafx.stage.Stage;

/**
 * Created by RJzz on 2016/12/11.
 */
public class UpdateStage extends Stage{
    public static UpdateStage updateStage;


    public static UpdateStage getInstance() {
        if(updateStage != null) {
            return updateStage;
        }else {
            updateStage = new UpdateStage();
            return updateStage;
        }
    }
}
