package View;

import Controller.DataManagement;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ProductListScene extends Scene {
    private TableView<Product> tableView = new TableView<Product>();
    private HBox hboxFilter = new HBox();
    public ProductListScene(Integer width, Integer height) {
        super(new VBox(), width, height);
        VBox vbox = (VBox)this.getRoot();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        createHBoxFilter();
        ObservableList<Node> childrenOfVBox = vbox.getChildren();
        Label lblTitle = new Label("Danh sách các sản phẩm");
        lblTitle.setFont(new Font("Arial", 25));
        childrenOfVBox.add(lblTitle);
        childrenOfVBox.add(hboxFilter);
        childrenOfVBox.add(tableView);
        createTableView();

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
        buildContexMenu();
        tableView.setRowFactory(tv -> {
            final TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    contextMenu.hide();
                    //Double click
                    if(event.getClickCount() == 2 && !row.isEmpty()) {
                        System.out.println("You double-clicked a row");

                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
                        System.out.println("You right-clicked a row");

                    }
                }
            });
            return row;
        });
    }
    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem menuItemDelete = new MenuItem("Delete");;
    private MenuItem menuItemProperty = new MenuItem("Properties");
    public void buildContexMenu() {
        contextMenu.getItems().addAll(menuItemDelete, menuItemProperty);
        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You pressed: Properties of ");
            }
        });
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You pressed: Delete of ");
            }
        });
    }
}
