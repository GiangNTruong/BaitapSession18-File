package baitap.bai5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bai5 {
    public static void main(String[] args) {

            String PATH_FILE = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai5\\quocgia.csv";

        String line;
        String csvSplitBy = ","; // Dấu phân cách trong file CSV

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_FILE))) {
            while ((line = br.readLine()) != null) {
                //Tách dòng dữ liệu thành các phần tử
                String[] country = line.split(csvSplitBy);
                int id = Integer.parseInt(country[0]);
                String code = country[1];
                String name = country[2];

                // Hiển thị thông tin quốc gia
                System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}