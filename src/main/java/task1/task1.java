package task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива n:");
        int n = scanner.nextInt();
        System.out.println("Введите длину интервала m:");
        int m = scanner.nextInt();

        int i = 1;
        while(true){
            System.out.print(i);
            i = 1 + (i+m-2)%n;
            if(i==1){
                break;
            }
        }
    }
}
