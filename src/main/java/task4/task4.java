package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        String filePath = args[0];
        //String filePath = "/home/daniil/IdeaProjects/perf-lab-task/src/main/java/task4/file.txt";
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                nums.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла 1");
        }

        Integer[] numsArr = nums.toArray(new Integer[0]);
        Arrays.sort(numsArr);
        Integer median = numsArr[numsArr.length/2];

        int result = 0;
        for(int i = 0; i<numsArr.length;i++){
            result += Math.abs(numsArr[i] - median);
        }

        System.out.println(result);
    }
}
