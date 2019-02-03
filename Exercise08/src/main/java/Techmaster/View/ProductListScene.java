package Techmaster.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import org.apache.commons.validator.routines.EmailValidator;
import static javafx.geometry.HPos.LEFT;

public class ProductListScene extends Scene {
    public ProductListScene(Integer width, Integer height) {
        super(new GridPane(), width, height);
        GridPane grid = (GridPane)this.getRoot();

    }
}

