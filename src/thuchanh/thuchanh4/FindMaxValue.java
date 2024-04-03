package thuchanh.thuchanh4;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max<numbers.get(i)){
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        String PATH_NUMBER = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\thuchanh\\thuchanh4\\numbers.txt";
        String PATH_RESULT = "D:\\code trung tam\\Modele02-JAVA 1-vscode\\Session18-baitapFile\\src\\thuchanh\\thuchanh4\\result.txt";
        List<Integer> numbers=readAndWriteFile.readFile(PATH_NUMBER);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile(PATH_RESULT,maxValue);
    }
}
