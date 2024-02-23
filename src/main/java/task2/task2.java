package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws FileNotFoundException {


        double x_ocr = -1;
        double y_ocr = -1;
        double r_ocr = -1;

        //String file1Path = "/home/daniil/IdeaProjects/perf-lab-task/src/main/java/task2/file1.txt";
        String file1Path = args[0];
        File file1 = new File(file1Path);
        try {
            Scanner scanner = new Scanner(file1);
            x_ocr = scanner.nextDouble();
            y_ocr = scanner.nextDouble();
            r_ocr = scanner.nextDouble();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла 1");
        }

        ArrayList<double[]> dots = new ArrayList<>();


        //String file2Path = "/home/daniil/IdeaProjects/perf-lab-task/src/main/java/task2/file2.txt";
        String file2Path = args[1];
        File file2 = new File(file2Path);
        try {
            Scanner scanner = new Scanner(file2);
            int i = 0;

            while(scanner.hasNextLine()) {
                double[] dot = new double[2];
                dot[0] = scanner.nextDouble();
                dot[1] = scanner.nextDouble();
                dots.add(dot);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла 2");
        }


        for(int i =0; i<dots.size();i++) {

            double y_dot = dots.get(i)[1];
            double x_dot = dots.get(i)[0];

            double distance = Math.sqrt((x_ocr - x_dot) * (x_ocr - x_dot) + (y_ocr - y_dot) * (y_ocr - y_dot));
            int result = -1;
            if (distance > r_ocr) {
                result = 2;
            } else if (distance < r_ocr) {
                result = 1;
            } else if (distance == r_ocr) {
                result = 0;
            }

            System.out.println(result);
        }
    }
}
