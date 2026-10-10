package problems;

import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) { super(distanceKm); }

    @Override
    public String getMode() { return "BUS"; }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) { super(distanceKm); }

    @Override
    public String getMode() { return "TRAIN"; }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) { super(distanceKm); }

    @Override
    public String getMode() { return "FLIGHT"; }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingDriver {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            TravelBooking[] bookings = new TravelBooking[n];

            for (int i = 0; i < n; i++) {
                String mode = sc.next();
                double distance = sc.nextDouble();

                switch (mode) {
                    case "BUS":
                        bookings[i] = new BusBooking(distance);
                        break;
                    case "TRAIN":
                        bookings[i] = new TrainBooking(distance);
                        break;
                    case "FLIGHT":
                        bookings[i] = new FlightBooking(distance);
                        break;
                }
            }

            for (TravelBooking b : bookings) {
                System.out.printf("%s: %.2f\n", b.getMode(), b.calculateTotalFare());
            }
        }
    }
}