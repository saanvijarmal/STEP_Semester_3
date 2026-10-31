package assignmentproblems;

import java.util.Scanner;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double billAmount) { super(billAmount); }
    @Override
    public String getType() { return "STUDENT"; }
    @Override
    public double calculateFinalAmount() { return billAmount * 0.90; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double billAmount) { super(billAmount); }
    @Override
    public String getType() { return "STAFF"; }
    @Override
    public double calculateFinalAmount() { return billAmount * 0.95; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double billAmount) { super(billAmount); }
    @Override
    public String getType() { return "GUEST"; }
    @Override
    public double calculateFinalAmount() { return billAmount + 10.0; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Customer[] customers = new Customer[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();

                switch (type) {
                    case "STUDENT":
                        customers[i] = new StudentCustomer(amount);
                        break;
                    case "STAFF":
                        customers[i] = new StaffCustomer(amount);
                        break;
                    case "GUEST":
                        customers[i] = new GuestCustomer(amount);
                        break;
                }
            }

            double grandTotal = 0;
            for (Customer c : customers) {
                double finalAmount = c.calculateFinalAmount();
                grandTotal += finalAmount;
                System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}
