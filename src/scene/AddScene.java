package scene;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by RJzz on 2016/12/8.
 */
public class AddScene extends Scene {
    public AddScene(@NamedArg("root") Parent root, @NamedArg("width") double width, @NamedArg("height") double height) {
        super(root, width, height);
    }

    public static AddScene addScene;

    public static AddScene getInstance() {
        if(addScene != null) {
            return addScene;
        }else {

        return addScene;

        }
    }
}
