package baitap.bai7;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBinaryFile {

    public static void main(String[] args) {
        // Bước 2: Đọc danh sách sinh viên từ file nhị phân
        List<Student> studentList = readStudentListFromBinaryFile("D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai7\\students.txt");

        // Hiển thị danh sách trước khi thêm sinh viên mới
        System.out.println("Danh sách sinh viên trước khi thêm:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Bước 3: Thêm sinh viên mới vào danh sách
        Student newStudent = new Student("Alice Johnson", 23);
        studentList.add(newStudent);

        // Hiển thị danh sách sau khi thêm sinh viên mới
        System.out.println("\nDanh sách sinh viên sau khi thêm:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Bước 4: Ghi lại toàn bộ danh sách vào file nhị phân
        writeStudentListToBinaryFile("D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\baitap\\bai7\\students.txt", studentList);

        System.out.println("\nDanh sách sinh viên đã được ghi lại vào file nhị phân.");
    }
    // Phương thức này đọc danh sách sinh viên từ một file nhị phân.
    private static List<Student> readStudentListFromBinaryFile(String filePath) {
        List<Student> studentList = new ArrayList<>();

        // Sử dụng try-with-resources để đảm bảo luồng đầu vào được đóng lại sau khi hoàn thành.
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            // Đọc đối tượng từ file và ép kiểu thành danh sách sinh viên.
            studentList = (List<Student>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            // Nếu file không tồn tại, thông báo lỗi.
            System.err.println("Không tìm thấy file: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            // Nếu có lỗi trong quá trình đọc file hoặc ép kiểu đối tượng, in ra lỗi.
            e.printStackTrace();
        }

        return studentList;
    }

    // Phương thức này ghi danh sách sinh viên vào một file nhị phân.
    private static void writeStudentListToBinaryFile(String filePath, List<Student> studentList) {
        // Sử dụng try-with-resources để đảm bảo luồng đầu ra được đóng lại sau khi hoàn thành.
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // Ghi danh sách sinh viên vào file.
            objectOutputStream.writeObject(studentList);
        } catch (IOException e) {
            // Nếu có lỗi trong quá trình ghi file, in ra lỗi.
            e.printStackTrace();
        }
    }

}

