package baitap.bai8;


import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    //để đảm bảo rằng các đối tượng Product có thể được tuần tự hóa và giải tuần tự hóa một cách an toàn.
    private static final long serialVersionUID = 1L;

    private int productCode;
    private String productName;
    private String manufacturer;
    private double price;
    private String description;

    public Product() {
    }

    public Product(int productCode, String productName, String manufacturer, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
    public void inputProductInfo(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        this.productCode  =Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất: ");
        this.manufacturer  = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        this.price  = scanner.nextDouble();
        scanner.nextLine(); // Đọc ký tự Enter còn lại trong buffer

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();
    }
}
