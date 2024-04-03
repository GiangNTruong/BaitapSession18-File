package baitap.bai3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai3 {
    // Khởi tạo 1 đối tượng của lớp StringBuilder
    // Đối tượng này: Xây ựng và thay dô chuỗi 1 cách hiệu quả
    // Phương thức đọc file thành String
    public static String readFileToString(String filePath) {
        // Khởi tạo 1 đối tượng của lớp "StringBuilder"
        // Đối tượng này: Xây dựng và thay đổi chuỗi 1 cách hiệu quả.
        StringBuilder content = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void main(String[] args) {
        //Đường dẫn đến tập tin
        String filePath = "Session18-baitapFile/src/baitap/bai3/Bai3.java";
        //Gọi phương thức để đo dữ liệu từ tệp tin
        String[] fileContent = readFileToString(filePath).split("\s+");

        //In nội dung đọc được từ tệp
        System.out.println(Arrays.toString(fileContent));
        int maxLength = 0;
        List<String> maxLengthWords = new ArrayList<>();
        for(String s: fileContent){
            int wordLength = s.length();
            if (wordLength>maxLength){
                maxLength=wordLength;
                maxLengthWords.clear();//Đặt lại danh sách nếu tìm thâ từ có đồ dài lơn hơn
            }
            else if (wordLength==maxLength){
                maxLengthWords.add(s);
            }
        }
        //In ra danh sách từ có độ dài max và độ dài của chúng
        System.out.println("Những từ có độ dài max là : ");
        for(String maxLengthWord : maxLengthWords){
            System.out.println(maxLengthWord);
        }
        System.out.println("đọ dài là : "+maxLength);


    }

}
