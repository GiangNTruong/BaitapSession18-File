package thuchanh.thuchanh3;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Nhập đường dân file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
