package assignment_Problems;
import java.util.Scanner;
public class primenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        boolean isPrime = number > 1; // 1 or lower are not prime

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }

        sc.close();
    }
}