package baitap.bai9;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    // Getter và Setter cho title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter và Setter cho author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter và Setter cho publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getter và Setter cho price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
    public void inputData(Scanner scanner){
        System.out.println("Nhập tên sách : ");
        this.title = scanner.nextLine();
        System.out.println("Nhạp tấc giả : ");
        this.author = scanner.nextLine();
        System.out.println("Nhập nhà xuất ban :  ");
        this.publisher = scanner.nextLine();
        System.out.println("Nhập giá tiền : ");
        this.price = Double.parseDouble(scanner.nextLine());
    }
}

