package baitap.bai7;

import java.io.*;

// Bước 1: Xây dựng lớp đối tượng
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
