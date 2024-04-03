package baitap.bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private static final String FILE_PATH = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai9\\book.txt";
    private List<Book> bookList = new ArrayList<>();

    public BookManager() {
        loadFromFile(); // Khi tạo được đối tượng rồi thì mới bật dòng này lên.
    }

    public void addBook(Book book) {
        bookList.add(book);
        saveToFile();
        System.out.println("Cuốn sách đã được thêm thành công.");
    }

    public void updateBook(Book updatedBook) {
        for (Book book : bookList) {
            if (book.getTitle().equals(updatedBook.getTitle())) {
                // Cập nhật thông tin của cuốn sách
                book.setAuthor(updatedBook.getAuthor());
                book.setPublisher(updatedBook.getPublisher());
                book.setPrice(updatedBook.getPrice());
                saveToFile();
                System.out.println("Thông tin cuốn sách đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy cuốn sách với title: " + updatedBook.getTitle());
    }

    public void deleteBook(String title) {
        bookList.removeIf(book -> book.getTitle().equals(title));
        saveToFile();
        System.out.println("Cuốn sách đã được xóa thành công.");
    }

    public void displayAllBooks() {
        System.out.println("\nDanh sách tất cả các cuốn sách:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objectOutputStream.writeObject(bookList);
            System.out.println("Dữ liệu đã được lưu vào file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Đã xảy ra lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            bookList = (List<Book>) objectInputStream.readObject();
            System.out.println("Dữ liệu đã được đọc từ file thành công.");
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file. Tạo file mới.");
            bookList = new ArrayList<>();
            saveToFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Đã xảy ra lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }

}

