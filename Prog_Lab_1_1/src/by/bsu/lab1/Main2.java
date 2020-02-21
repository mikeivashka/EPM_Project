package by.bsu.lab1;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a Lab 1, Part 2 realisation
 */
public class Main2 {
    /**
     * Main method
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите числа, для прекращения ввода введите символ\n");
        ArrayList<String> numbers = new ArrayList<>();
        while (true) {
            if (scan.hasNextLong()) numbers.add(scan.next());
            else break;
        }
        double mid = getAvgLength(numbers);

        System.out.println("Средняя длина чисел: " + mid + "\n\nЧисла, длина которых меньше средней: ");
        for (String number : numbers) {
            if (number.length() < mid) System.out.println(number + " (" + number.length() + ")");
        }

        System.out.println("\nЧисла, длина которых больше средней: ");
        for (String number : numbers) {
            if (number.length() > mid) System.out.println(number + " (" + number.length() + ")");
        }
    }
    /**
     * Counts avg length in ArrayList of strings
     */
    public static double getAvgLength(@NotNull ArrayList<String> arr) {
        double sum=0;
        for(String elem : arr){
            sum+=elem.length();
        }
        return sum/(arr.size());
    }
}

