package Techmaster.View;

import Techmaster.Controller.DataManagement;
import Techmaster.Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.apache.commons.validator.routines.EmailValidator;

import javax.xml.crypto.Data;

import static javafx.geometry.HPos.LEFT;

public class ProductListScene extends Scene {
    private TableView<Product> tableView = new TableView<Product>();
    private ContextMenu contextMenu = new ContextMenu();
    private HBox hboxFilter = new HBox();

    private void createTableView() {
        TableColumn columnId = new TableColumn("Mã sản phẩm");
        TableColumn columnName = new TableColumn("Tên sản phẩm");
        TableColumn columnYear = new TableColumn("Năm sản xuất");
        TableColumn columnPrice = new TableColumn("Giá");
        TableColumn columnDescription = new TableColumn("Mô tả");

        columnId.setCellValueFactory(new PropertyValueFactory<Product, String>("productId"));
        columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        columnYear.setCellValueFactory(new PropertyValueFactory<Product, Integer>("year"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));

        tableView.getColumns().addAll(columnId,columnName,columnYear,columnPrice,columnDescription);
        tableView.setItems(DataManagement.getInstance().getProducts());
    }
    private void createHBoxFilter() {
        TextField txtFilter = new TextField();
        txtFilter.setPromptText("Enter text to search");
        txtFilter.textProperty().addListener((observableValue, oldText, newText) -> {
            ObservableList<Product> filteredProducts = DataManagement.getInstance().filterProducts(newText);
            tableView.setItems(filteredProducts);
        });

        hboxFilter.setSpacing(5);
        hboxFilter.getChildren().addAll(new Label("Tìm kiếm: "), txtFilter);
    }

    //Menu khi người dùng bấm chuột phải
    public ProductListScene(Integer width, Integer height) {
        super(new VBox(), width, height);
        VBox vbox = (VBox)this.getRoot();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        createHBoxFilter();
        createTableView();
        Label lblTitle = new Label("Danh sách các sản phẩm");
        lblTitle.setFont(new Font("Arial", 25));
        vbox.getChildren().addAll(lblTitle, hboxFilter, tableView);
        vbox.setSpacing(5);
    }
}

