package baitap.bai2;

import java.io.*;
import java.util.Scanner;

public class Bai2 {
    private static void copyBinaryFile(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập tập tin nguồn: ");
        String sourcePath = in.nextLine();
        System.out.print("Nhập tệp đích: ");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyBinaryFile(sourceFile, destFile);
            System.out.println("Sao chép hoàn tất. Số byte: " + sourceFile.length());
        } catch (IOException ioe) {
            System.out.println("Không thể sao chép tập tin đó");
            System.out.println(ioe.getMessage());
        }
    }
}
