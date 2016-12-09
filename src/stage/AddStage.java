package stage;

import javafx.print.PageLayout;
import javafx.stage.Stage;

/**
 * Created by RJzz on 2016/12/8.
 */
public class AddStage extends Stage {
    public static AddStage addStage;
    public static AddStage getInstance() {
        if(addStage != null) {
            return addStage;
        }else {
            addStage = new AddStage();
            return addStage;
        }
    }
}
