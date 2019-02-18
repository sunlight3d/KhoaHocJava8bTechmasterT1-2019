import Controller.DataManagement;
import Model.Product;
import org.omg.CORBA.DATA_CONVERSION;

public class Main {
    public static void main(String [] args) {
        System.out.println("Hello");
        DataManagement dataManagement = DataManagement.getInstance();
//        System.out.println("sss");
        dataManagement.getProducts();
        dataManagement.deleteProduct(4);
        System.out.println("Sau khi xoa");
        dataManagement.getProducts();
        Product selectedProduct = dataManagement.getProduct(8);
        selectedProduct.setProductName("TTTThinkPad X230");
        dataManagement.updateProduct(8,selectedProduct);
        dataManagement.getProducts();
        System.out.println("Sau khi filter");
        dataManagement.filterProducts("apple");

    }
}
