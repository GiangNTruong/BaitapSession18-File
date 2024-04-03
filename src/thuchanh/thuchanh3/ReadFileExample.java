package thuchanh.thuchanh3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileExample {
    public void readFileText(String filePath){
        try{
            //Đọc file theo đường dẫn
            File file = new File(filePath);
            //Kiểm tra nếu file ko tồn tại thì nếm ra ngoại lệ
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            //Đọc ừng dòng của file và tiens hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line= br.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            br.close();
            //Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("TỔng " +sum);

        }catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }

    }
}
