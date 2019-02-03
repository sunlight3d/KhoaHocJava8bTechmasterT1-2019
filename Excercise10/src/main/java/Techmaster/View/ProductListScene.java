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
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.apache.commons.validator.routines.EmailValidator;


import static javafx.geometry.HPos.LEFT;

public class ProductListScene extends Scene {
    private TableView<Product> tableView = new TableView<Product>();
    private ContextMenu contextMenu = new ContextMenu();
    private HBox hboxFilter = new HBox();
    private Product selectedProduct;

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
        tableView.setRowFactory(tv -> {
            final TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    contextMenu.hide();
                    //Double click
                    if(event.getClickCount() == 2 && !row.isEmpty()) {
                        System.out.println("You double-clicked a row");
                        showDetailProperty(row.getItem());
                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        selectedProduct = row.getItem();
                        contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
                        System.out.println("You right-clicked a row");
                    }
                }
            });
            return row;
        });
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
        createContextMenu();
        createTableView();
        Label lblTitle = new Label("Danh sách các sản phẩm");
        lblTitle.setFont(new Font("Arial", 25));
        vbox.getChildren().addAll(lblTitle, hboxFilter, tableView);
        vbox.setSpacing(5);

    }
    private void createContextMenu() {
        MenuItem menuItemDelete = new MenuItem("Xoá");
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataManagement.getInstance().deleteProduct(selectedProduct.getProductId());
                tableView.setItems(DataManagement.getInstance().getProducts());
            }
        });
        MenuItem menuItemProperty = new MenuItem("Xem chi tiết");
        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                showDetailProduct(selectedProduct);
            }
        });
        MenuItem menuItemAddProduct = new MenuItem("Thêm sản phẩm mới");
        menuItemAddProduct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        contextMenu.getItems().addAll(menuItemDelete, menuItemProperty, menuItemAddProduct);
    }
    private void showDetailProduct(Product selectedProduct) {
        DetailProduct detailProduct = new DetailProduct(selectedProduct,
                "Detail category");
        detailProduct.initModality(Modality.APPLICATION_MODAL);
        detailProduct.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Detail category is hiding");
                Database.getInstance().getAllCategories();
            }
        });
        detailProduct.showAndWait();
    }

}

