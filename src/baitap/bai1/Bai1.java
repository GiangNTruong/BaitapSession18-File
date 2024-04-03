package baitap.bai1;

import java.io.*;
import java.util.Arrays;

public class Bai1 {
    public static String readDataFromFile(String path){
        StringBuilder content = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(path);// FileInputStream: mở tệp tin
            InputStreamReader isr = new InputStreamReader(fis);// InputStreamReader: chuyển dổi dữ liệu từ daạng byte sang ký tự
            BufferedReader reader = new BufferedReader(isr);//BufferedReader:đọc nội dung
            String line;
            while ((line = reader.readLine())!=null){
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String testString = readDataFromFile("D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\Bai1\\bai1.txt") ;
        System.out.println(testString);

        //convert String ở bước 2 thaành mảng string, mỗi từ là 1 phần tử
        String[] wordsArr = testString.split("\\s+");
        System.out.println(Arrays.toString(wordsArr));

        //Buocs 4 .độ dài mảng
        System.out.println("ĐỘ dai của mảng là " +wordsArr.length);
    }
}
