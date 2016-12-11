package sample;

import Service.RFIDService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RFID;
import stage.MainStage;

import java.io.IOException;
import java.sql.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Text text = new Text("welcome");
        text.setFont(Font.font("hehe", FontWeight.NORMAL, 20));
        grid.add(text, 0, 0, 2, 1);
        Label name = new Label("User Name:");
        //放到第0行第零列
        grid.add(name, 0, 1);

        //
        TextField userTestField = new TextField();
        grid.add(userTestField, 1, 1);

        //文本标签
        Label pw  = new Label("Password:");
        grid.add(pw, 0, 2);

        //密码输入
        PasswordField psBox = new PasswordField();
        grid.add(psBox, 1, 2);

        Button login = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        hBox.getChildren().add(login);
        grid.add(hBox, 1, 4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        Scene scene = new Scene(grid, 400, 275);


        primaryStage.setScene(scene);
        primaryStage.setTitle("RFID管理系统");
        Button button = new Button("hello world");
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if(psBox.getText().equals("admin") && userTestField.getText().equals("admin")) {
                    try {
                        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
                        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));

                        Scene scene1 = new Scene(myPane);
                        scene1.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
                        //scene1.setCursor(scene.getCursor());
                        primaryStage.hide();
                        MainStage.getInstance().setScene(scene1);
                        MainStage.getInstance().show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //}

            }
        });
        scene.getStylesheets().add(Main.class.getResource("../css/test.css").toExternalForm());
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
