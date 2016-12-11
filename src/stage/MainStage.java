package stage;

import javafx.stage.Stage;

/**
 * Created by RJzz on 2016/12/11.
 */
public class MainStage extends Stage{
    public static MainStage mainStage;

    public static MainStage getInstance() {
        if(mainStage != null) {
            return mainStage;
        }else {
            mainStage = new MainStage();
            return mainStage;
        }
    }
}
