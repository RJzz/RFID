package stage;

import javafx.stage.Stage;

/**
 * Created by RJzz on 2016/12/11.
 */
public class DetailStage extends Stage {
    public static DetailStage detailStage;

    public static DetailStage getInstance() {
        if(detailStage != null) {
            return detailStage;
        }else {
            detailStage = new DetailStage();
            return detailStage;
        }
    }
}
