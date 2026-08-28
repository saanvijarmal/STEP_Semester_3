package assignment_Problems;
import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter N: ");
            int n = sc.nextInt();

            int i = 1;
            int sum = 0;

            while (i <= n) {
                sum = sum + i;
                i++;
            }
            System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
        }
    }
}