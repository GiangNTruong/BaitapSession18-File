package thuchanh.thuchanh4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line=br.readLine()) !=null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }catch (Exception e){
            System.err.println("File ko tồn tại or nô dung có lỗi");
        }
        return numbers;
    }
    public void writeFile(String filePath,int max){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị max : " +max);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
