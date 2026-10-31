package assignmentproblems;

import java.util.Scanner;

public class DigitSumAndReversal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int num = sc.nextInt();

            int sum = 0;
            int reversed = 0;
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit;
                reversed = (reversed * 10) + digit;
                temp /= 10;
            }

            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reversed);
        }
    }
}
