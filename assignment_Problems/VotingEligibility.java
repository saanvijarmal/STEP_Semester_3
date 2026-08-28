package assignment_Problems;
import java.util.Scanner;


public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc
         = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        boolean eligible = age >= 18;

        if (eligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }

        sc.close();
    }
}