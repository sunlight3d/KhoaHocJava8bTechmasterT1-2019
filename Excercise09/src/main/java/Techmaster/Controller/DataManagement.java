package Techmaster.Controller;
import Techmaster.Model.Product;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.List;

public class DataManagement {
    //Singleton pattern
    private static DataManagement instance;
    //Data
    private ObservableList<Product> products = FXCollections.observableArrayList();
    public static DataManagement getInstance() {
        if(instance == null) {
            instance = new DataManagement();
            instance.generateProductList();
        }
        return instance;
    }
    //Fake danh sách sản phẩm
    private void generateProductList(){
        products.add(new Product(
                "Ipad pro 12.9",
                2016,
                712.3,
                "Bán : iPad Pro - 12.9inch Space Grey 4G - 128Gb ,máy đẹp 9,99%"));
        products.add(new Product(
                "Apple watch S3",
                2018,
                415.0,
                "Apple watch seri 3 Stainless Steel Size 42 LTE Black Sport Band Mới tinh chưa kích hoạt"));
        products.add(new Product(
                "Máy ảnh Nikon",
                2017,
                1200.0,
                "Bán Nikon D810 Body Len 70-200mm 2.8 Nano VR II"));
        products.add(new Product(
                "Nikon D3300",
                2018,
                452.5,
                "Bán rẻ Nikon D3300 + ống 18-55mm VR II (mới 99%) - Hàng xách tay"));
        products.add(new Product(
                "Apple watch S 1",
                2015,
                273.4,
                "Apple watch seri 1 bản 38mm white như new 100%. Bảo hành đến T10.2019"));
        products.add(new Product(
                "Tai nghe Ostry KC06A",
                2017,
                230.0,
                "Tai nghe Ostry KC06A còn fullbox mua tại xuân vũ mới sử dụng còn 9 tháng bảo hành"));
        products.add(new Product(
                "Vòng Huawei B5",
                2019,
                640.56,
                "Bán Vòng Đeo Tay Thông Minh Đa Năng Huawei B5"));
        products.add(new Product(
                "ThinkPad X230",
                2014,
                567.9,
                "ThinkPad X230 | Màn 12.5\" i5-3320M 3.3Ghz, Ram 4G, ổ cứng 320G, | nhỏ gọn, mạnh, bền bỉ, BH 12 tháng"));
        products.add(new Product(
                "Dell Inspirion 3458",
                2013,
                732.5,
                "Dell Inspirion 3458 i3-4005U ram 4GB/ổ 500GB/VGA GT820 2G-Hình thức đạt 99/99%"));
        products.add(new Product(
                "Dell Gaming 7567",
                2015,
                689.3,
                "Dell Gaming 7567, i7 7700HQ 8G SSD128+1T Vga GTX1050ti Full HD chính Hãng"));

    }
    public ObservableList<Product> filterProducts(String text) {
        ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
        for(Product product:this.products) {
            if(product.getProductName().toLowerCase().contains(text.trim().toLowerCase()) ||
                    product.getDescription().toLowerCase().contains(text.trim().toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    public static void showDetailProducts(ObservableList<Product> products) {
        for (Product product: products) {
            product.showDetail();
        }
    }
    public ObservableList<Product> getProducts() {
        return this.products;
    }
    public void insertProduct(Product newProduct){
        this.products.add(newProduct);
    }
    public void updateProduct(Integer productId, Product newProduct){
        for(Product product:this.products) {
            if(product.getProductId().equals(productId)) {
                product.setProductName(newProduct.getProductName());
                product.setYear(newProduct.getYear());
                product.setPrice(newProduct.getPrice());
                product.setDescription(newProduct.getDescription());
            }
        }
    }
    public void deleteProduct(Integer productId){
        Iterator iterator = this.products.iterator();
        while(iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if(product.getProductId() == productId) {
                iterator.remove();
            }
        }
    }
}
