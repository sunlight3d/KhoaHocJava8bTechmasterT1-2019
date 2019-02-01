package Techmaster.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.*;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;

public class LoginScene extends Scene{
    public LoginScene(Integer width, Integer height) {
        super(new GridPane(), width, height);
        GridPane grid = (GridPane)this.getRoot();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Login to your account");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label email = new Label("Email:");
        grid.add(email, 0, 1);

        final TextField txtEmail = new TextField();
        grid.add(txtEmail, 1, 1);

        Label password = new Label("Password:");
        grid.add(password, 0, 2);

        final PasswordField txtPassword = new PasswordField();
        grid.add(txtPassword, 1, 2);

        Button btnLogin = new Button("Sign in");
        HBox hboxBtnLogin = new HBox(10);
        hboxBtnLogin.setAlignment(Pos.BOTTOM_RIGHT);
        hboxBtnLogin.getChildren().add(btnLogin);
        grid.add(hboxBtnLogin, 1, 4);

        final Text infoText = new Text();
        grid.add(infoText, 0, 6);
        grid.setColumnSpan(infoText, 2);
        grid.setHalignment(infoText, LEFT);
        infoText.setId("infoText");

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(EmailValidator.getInstance().isValid(txtEmail.getText())) {
                    infoText.setFill(Color.BLUE);
                    infoText.setText("You typed:\nEmail: "+
                            txtEmail.getText()+
                            "\nPassword:"+txtPassword.getText());
                } else {
                    infoText.setFill(Color.RED);
                    infoText.setText("You typed wrong email format");
                }

            }
        });
    }
}
