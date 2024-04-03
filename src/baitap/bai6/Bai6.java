package baitap.bai6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bai6 {

    public static void main(String[] args) {
        // Đường dẫn đến tệp văn bản cần phân tích
        String filePath = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai6\\file.txt";

        // Đọc nội dung tệp văn bản và lưu vào biến fileContent
        String fileContent = readFileToString(filePath);

        // Tính toán tần suất xuất hiện của từng từ trong fileContent và lưu vào wordFrequencyMap
        Map<String, Integer> wordFrequencyMap = calculateWordFrequency(fileContent);

        // Tìm từ được sử dụng nhiều nhất trong wordFrequencyMap
        String mostUseWord = findMostUsedWord(wordFrequencyMap);

        // In ra từ được sử dụng nhiều nhất và tần suất xuất hiện của nó
        System.out.println("Từ được sử dụng nhiều nhất là: " + mostUseWord +
                " với tần suất xuất hiện là: " + wordFrequencyMap.get(mostUseWord));
    }

    // Phương thức đọc nội dung từ tệp văn bản và trả về dưới dạng chuỗi
    private static String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Đã có lỗi khi đọc file: " + e.getMessage());
        }
        return content.toString();
    }

    // Phương thức tính toán tần suất xuất hiện của từng từ trong một chuỗi
    private static Map<String, Integer> calculateWordFrequency(String content) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        String[] words = content.split("\\s+"); // Tách chuỗi thành từng từ dựa trên khoảng trắng

        for (String word : words) {
            word = word.toLowerCase(); // Chuyển đổi từ thành chữ thường để không phân biệt chữ hoa chữ thường
            // Tăng tần suất xuất hiện của từ trong wordFrequencyMap
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        return wordFrequencyMap;
    }

    // Phương thức tìm từ được sử dụng nhiều nhất trong một Map
    private static String findMostUsedWord(Map<String, Integer> wordFrequencyMap) {
        String mostUsedWord = null;
        int maxFrequency = 0;

        // Duyệt qua từng từ trong wordFrequencyMap
        for (Map.Entry<String, Integer> stringIntegerEntry : wordFrequencyMap.entrySet()) {
            // Nếu tần suất xuất hiện của từ hiện tại lớn hơn maxFrequency
            if (stringIntegerEntry.getValue() > maxFrequency) {
                // Cập nhật mostUsedWord và maxFrequency
                mostUsedWord = stringIntegerEntry.getKey();
                maxFrequency = stringIntegerEntry.getValue();
            }
        }

        return mostUsedWord;
    }
}
