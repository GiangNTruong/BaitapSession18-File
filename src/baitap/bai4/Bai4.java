package baitap.bai4;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai4 {
    public static void main(String[] args) {
        //Bước 1 tạo file gô và nhập văn bản
        String originalFilePath = "original.txt";
        createandWriteOriginalFile(originalFilePath);

        //B2: đọc văn ba từ file goc
        String fileContent = readFileToString(originalFilePath);

        //Chuyenr string thành mảng string với moi từ là 1 phan tu
        String[] wordsArray = fileContent.split("\\s+");

        //Đảo ngược mảng string và đổi lại thành 1 string
        List<String> reversedWordsList = Arrays.asList(wordsArray);
        Collections.reverse(reversedWordsList);
        StringBuilder reversedContent = new StringBuilder();
        for (String word : reversedWordsList){
            reversedContent.append(word).append(" ");
        }

        //Ghi ra file mới
        String newFilePath = "reversed.txt";
        writeStringtoFile(newFilePath,reversedContent.toString());

        //In nọi dung file mới đã tạo
        System.out.println(readFileToString(newFilePath));

    }
    private static void createandWriteOriginalFile(String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("Tệp văn bản mẫu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readFileToString(String filePath){
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=reader.readLine())!=null){
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    private static void writeStringtoFile(String filePath, String content){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
