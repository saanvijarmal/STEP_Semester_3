package assignmentproblems;

import java.util.Scanner;

public class PrimeChecker {
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (isPrime(n)) {
                    System.out.println(n + " is prime");
                } else {
                    System.out.println(n + " is not prime");
                }
            }
        }
    }
}
