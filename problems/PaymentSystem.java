package problems;

import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) { super(amount); }
    @Override
    public String getType() { return "CARD"; }
    @Override
    public double calculateFinalAmount() { return amount * 1.02; }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public String getType() { return "WALLET"; }
    @Override
    public double calculateFinalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public String getType() { return "BANKTRANSFER"; }
    @Override
    public double calculateFinalAmount() { return amount; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            PaymentMethod[] payments = new PaymentMethod[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();
                switch (type) {
                    case "CARD":
                        payments[i] = new CardPayment(amount);
                        break;
                    case "WALLET":
                        payments[i] = new WalletPayment(amount);
                        break;
                    case "BANKTRANSFER":
                        payments[i] = new BankTransferPayment(amount);
                        break;
                }
            }

            double grandTotal = 0;
            for (PaymentMethod p : payments) {
                double finalAmount = p.calculateFinalAmount();
                grandTotal += finalAmount;
                System.out.printf("%s: %.2f\n", p.getType(), finalAmount);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}
