package assignmentproblems;

import java.util.Scanner;

public class WordReverser {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String word = sc.next();
                StringBuilder sb = new StringBuilder(word);
                String reversed = sb.reverse().toString();

                System.out.println(reversed);
                if (word.equalsIgnoreCase(reversed)) {
                    System.out.println("palindrome");
                } else {
                    System.out.println("not a palindrome");
                }
            }
        }
    }
}
