package baitap.bai8;

import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("-----------Quản lý san pham ----------");
            System.out.println("1. THêm mơi sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("0. THoát");
            System.out.println("Nhập lua chon");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Product newProduct=new Product();
                    newProduct.inputProductInfo(scanner);
                    productManager.addProduct(newProduct);
                    break;
                case 2:
                    //Hiển thị
                    productManager.displayProducts();
                    break;
                case 3:
                    productManager.loadFromFile();
                    //Tìm kiếm
                    System.out.println("Nhập mã muốn tìm");
                    int searchCode = Integer.parseInt(scanner.nextLine());
                    Product foundProduct = productManager.searchProduct(searchCode);
                    if (foundProduct!=null){
                        System.out.println("Sản phẩm đuợc tim thây là : " +foundProduct);
                    }else {
                        System.out.println("Ko được tim thay voi ma " + searchCode);
                    }
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn ko hợp lệ, nhập lai");
            }
        }
    }
}
