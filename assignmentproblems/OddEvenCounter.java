package assignmentproblems;

import java.util.Scanner;

public class OddEvenCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextLine()) return;
            String line = sc.nextLine().replaceAll("[\\[\\]\\s]", "");
            if (line.isEmpty()) return;

            String[] tokens = line.split(",");
            int even = 0;
            int odd = 0;

            for (String token : tokens) {
                int num = Integer.parseInt(token);
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            System.out.println("Even: " + even);
            System.out.println("Odd: " + odd);
        }
    }
}
