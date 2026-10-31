package assignmentproblems;

import java.util.Scanner;

abstract class Seat {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Seat(int count) {
        this.count = count;
    }

    public abstract String getType();
    public abstract double getBasePrice();

    public double calculateTotal() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularSeat extends Seat {
    public RegularSeat(int count) { super(count); }
    @Override
    public String getType() { return "REGULAR"; }
    @Override
    public double getBasePrice() { return 150.0; }
}

class PremiumSeat extends Seat {
    public PremiumSeat(int count) { super(count); }
    @Override
    public String getType() { return "PREMIUM"; }
    @Override
    public double getBasePrice() { return 250.0; }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(int count) { super(count); }
    @Override
    public String getType() { return "RECLINER"; }
    @Override
    public double getBasePrice() { return 400.0; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Seat[] bookings = new Seat[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int count = sc.nextInt();

                switch (type) {
                    case "REGULAR":
                        bookings[i] = new RegularSeat(count);
                        break;
                    case "PREMIUM":
                        bookings[i] = new PremiumSeat(count);
                        break;
                    case "RECLINER":
                        bookings[i] = new ReclinerSeat(count);
                        break;
                }
            }

            double grandTotal = 0.0;
            for (Seat seat : bookings) {
                double amount = seat.calculateTotal();
                grandTotal += amount;
                System.out.printf("%s: %.2f\n", seat.getType(), amount);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}