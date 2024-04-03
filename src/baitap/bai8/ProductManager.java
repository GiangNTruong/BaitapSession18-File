package baitap.bai8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public static List<Product> productList = new ArrayList<>();
    private final String filePath = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai8\\product.txt";


    public void addProduct(Product product){
        //Thm sản phẩm mới vào danh sách
        productList.add(product);
        saveToFile(); //Lưu lại danh sách sản phẩm vào file sau khi thêm mới
    }

    public void displayProducts(){
        loadFromFile();//ĐỌc dữ liệu từ file khi tạo đôi tượng
        for (Product product : productList){
            System.out.println(product);
        }
    }
    public Product searchProduct(int productCode) {
        // Tìm kiếm sản phẩm theo mã sản phẩm
        for (Product product : productList) {
            if (product.getProductCode() == productCode) {
                return product;
            }
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }
    public void saveToFile(){
        //Các phương thức lưu và dọc dữ liệu từ tệp
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(productList);
            System.out.println("Dữ liệu đã đc luuw thành công");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadFromFile(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            productList = (List<Product>) objectInputStream.readObject();
            System.out.println("Dữ liệu ddc đọc từ file thành công");
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file. Tạo file mới.");
            saveToFile(); // Tạo file mới nếu không tìm thấy file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Đã xảy ra lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }

}
