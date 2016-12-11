package stage;

import javafx.stage.Stage;

/**
 * Created by RJzz on 2016/12/11.
 */
public class SearchStage extends Stage {

    public static SearchStage searchStage;

    public static SearchStage getInstance() {
        if(searchStage != null) {
            return searchStage;
        }else {
            searchStage = new SearchStage();
            return searchStage;
        }
    }
}
