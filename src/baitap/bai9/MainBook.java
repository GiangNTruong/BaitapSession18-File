package baitap.bai9;

import java.util.Scanner;

public class MainBook {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n=======Quant lý sách=======");
            System.out.println("1. THêm");
            System.out.println("2. Sửa ");
            System.out.println("3. Xóa");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn:  ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                        Book newBook = new Book();
                        newBook.inputData(scanner);
                        bookManager.addBook(newBook);
                        break;

                case 2:
                    Book updateBook = new Book();
                    updateBook.inputData(scanner);
                    bookManager.updateBook(updateBook);
                    break;
                case 3:
                    System.out.println("Nhập tên sách muốn xóa");
                    String bookDelete = scanner.nextLine();
                    bookManager.deleteBook(bookDelete);
                    break;
                case 4:
                    bookManager.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Kết thúc");
                    System.exit(0);
                    break;

            }
        }

    }
}
