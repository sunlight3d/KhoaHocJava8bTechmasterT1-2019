package Model;

public class Product {
    private Integer productId;
    private String productName;
    private Integer year;
    private Double price;
    private String description;
    private static Integer currentId = 0;


    public Product(String productName,Integer year,Double price,
                   String description) {
        currentId = currentId + 1;
        //currentId++;
        this.productId = currentId;
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.description = description;

    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
