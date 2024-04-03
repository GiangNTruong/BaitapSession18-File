package thuchanh.thuchanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main0 {
    public static void writeToFile(String path , List<Student> students){
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFormFile(String path){
        List<Student> studentss = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentss = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return studentss;
    }

    public static void main(String[] args) {
        String PATH_FILE = "student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Trịnh Đức Toàn", "Hà Nội"));
        students.add(new Student(2, "Lê Việt Dũng", "Phú Thọ"));
        students.add(new Student(3, "Phùng Trung Dũng", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Đồng Chính", "Hải Dương"));
        //Gọi phương thức writeToFile trong hàm main để ghi danh sách học viên trên ra file có tên là student.txt
        writeToFile(PATH_FILE,students);
        //Gọi phương thức readDataFromFile trong hàm main và hiển thị danh sách các học viên đang có trong file

        List<Student> studentDataFromFile = readDataFormFile("student.txt");
        for (Student student: studentDataFromFile){
            System.out.println(student);
        }
    }
}
