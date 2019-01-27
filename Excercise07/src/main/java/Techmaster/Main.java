package Techmaster;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene loginScene = new LoginScene(300, 275);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
