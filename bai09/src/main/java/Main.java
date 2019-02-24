import Controller.DataManagement;
import Model.Product;
import View.LoginScene;
import org.omg.CORBA.DATA_CONVERSION;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Hello");
        Scene loginScene = new LoginScene(300, 275);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}
