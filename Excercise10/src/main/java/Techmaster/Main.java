package Techmaster;

import Techmaster.Controller.DataManagement;
import Techmaster.Model.Product;
import Techmaster.View.LoginScene;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.print.attribute.DocAttribute;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene loginScene = new LoginScene(300, 275);
        primaryStage.setScene(loginScene);
//        Test Filter
//        ObservableList<Product> testProducts = DataManagement.getInstance().filterProducts("inspirion");
//        ObservableList<Product> testProducts = DataManagement.getInstance().filterProducts("");
//        DataManagement.showDetailProducts(testProducts);
//        Test insert
//        DataManagement.getInstance().insertProduct(new Product(
//                "Note 5 Gold 2",
//                2017,
//                450.3,
//                "Cần bán em Note 5 Gold 2 sim 64Gb bản qte máy đẹp"
//                ));
//        DataManagement.showDetailProducts(DataManagement.getInstance().getProducts());
//        Test update
//        Product updatedProduct = new Product("Note 5 Gold 2",
//                2017,
//                450.3,
//                "Cần bán em Note 5 Gold 2 sim 64Gb bản qte máy đẹp");
//        DataManagement.getInstance().updateProduct(7, updatedProduct);
//        DataManagement.showDetailProducts(DataManagement.getInstance().getProducts());
//        Test delete
        DataManagement.getInstance().deleteProduct(7);
        DataManagement.showDetailProducts(DataManagement.getInstance().getProducts());
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
