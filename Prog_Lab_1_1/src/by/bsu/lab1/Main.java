package by.bsu.lab1;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число N");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int tmp;
        int[] arr = new int[n];
        System.out.println("Введите " + n + " чисел");
        for (int i = 0; i < n; i++) {
            tmp = scan.nextInt();
            arr[i] = tmp;
        }
        for (int i = 0; i < n; i++)if(arr[i]%3==0) System.out.println(arr[i]);
    }
}
