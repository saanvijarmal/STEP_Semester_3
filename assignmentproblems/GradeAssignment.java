package assignmentproblems;

import java.util.Scanner;

public class GradeAssignment {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                int marks = sc.nextInt();
                if (marks >= 90) {
                    System.out.println("Grade A");
                } else if (marks >= 75) {
                    System.out.println("Grade B");
                } else if (marks >= 60) {
                    System.out.println("Grade C");
                } else if (marks >= 40) {
                    System.out.println("Grade D");
                } else {
                    System.out.println("Grade F");
                }
            }
        }
    }
}
