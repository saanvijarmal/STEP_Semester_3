package assignmentproblems;

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                long fact = 1;
                for (int i = 1; i <= n; i++) {
                    fact *= i;
                }
                System.out.println(fact);
            }
        }
    }
}
