package Techmaster.View;
import Techmaster.Controller.DataManagement;
import Techmaster.Model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailProductScene extends Scene {
    private Product product;
    private TextField txtName = new TextField();;
    private TextField txtYear = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtDescription = new TextField();

    void loadProductToUI(){
        if(product != null) {
            txtName.setText(product.getProductName());
            txtYear.setText(product.getYear().toString());
            txtPrice.setText(product.getPrice().toString());
            txtDescription.setText(product.getProductName());
        }
    }
    public DetailProductScene(Product selectedProduct, Integer width, Integer height) {
        super(new GridPane(), width, height);
        this.product = selectedProduct;
        loadProductToUI();
        GridPane grid = (GridPane) this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,
                25, 25, 25));
        grid.add(new Label("Tên sản phẩm"), 0, 1);
        grid.add(txtName, 1, 1);

        grid.add(new Label("Năm sản xuất"), 0, 2);
        grid.add(txtYear, 1, 2);

        grid.add(new Label("Giá"), 0, 3);
        grid.add(txtPrice, 1, 3);

        grid.add(new Label("Mô tả"), 0, 4);
        grid.add(txtDescription, 1, 4);

        HBox hbox2Buttons = new HBox(10);
        hbox2Buttons.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2Buttons.setSpacing(15);

        Button btnSave      = new Button("Lưu");
        Button btnCancel  = new Button("Huỷ");
        hbox2Buttons.getChildren().setAll(btnSave, btnCancel);
        grid.add(hbox2Buttons,0, 5, 2,1);
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Validate
                if (txtName.getText().trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Lỗi");
                    alert.setContentText("Bạn phải nhập tên sản phẩm");
                    alert.showAndWait();
                    return;
                }
                if (product == null) {
                    //Insert
                    DataManagement.getInstance().insertProduct(
                            new Product(txtName.getText(), Integer.parseInt(txtYear.getText()),
                                    Double.parseDouble(txtPrice.getText()), txtDescription.getText()));
                } else {
                    //Update
                    DataManagement.getInstance().updateProduct(product.getProductId(),
                            new Product(txtName.getText(), Integer.parseInt(txtYear.getText()),
                                    Double.parseDouble(txtPrice.getText()), txtDescription.getText()));
                }
                closeScene();
            }

        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeScene();
            }
        });
    }
    private void closeScene(){
        final Stage detailProductStage = (Stage) this.getWindow();
        detailProductStage.close();
    }
}
