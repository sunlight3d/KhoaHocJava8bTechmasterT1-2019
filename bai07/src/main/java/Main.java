import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private LoginScene loginScene =
            new LoginScene(500.0, 300.0);
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(this.loginScene);
        primaryStage.show();
    }
}
