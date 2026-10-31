package assignmentproblems;

import java.util.Scanner;

interface NightServiceable {
    default double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    protected double distanceKm;
    protected String time;

    public Cab(double distanceKm, String time) {
        this.distanceKm = distanceKm;
        this.time = time;
    }

    public abstract String getType();
    public abstract double getRatePerKm();

    public boolean isNightTrip() {
        return "NIGHT".equalsIgnoreCase(time);
    }

    public double calculateFare() {
        if (isNightTrip() && !(this instanceof NightServiceable)) {
            return -1.0; // Signal for rejected trip
        }

        double rawFare = distanceKm * getRatePerKm();
        if (isNightTrip() && (this instanceof NightServiceable)) {
            rawFare = ((NightServiceable) this).applyNightSurcharge(rawFare);
        }

        return Math.max(100.0, rawFare);
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm, String time) { super(distanceKm, time); }
    @Override
    public String getType() { return "MINI"; }
    @Override
    public double getRatePerKm() { return 10.0; }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distanceKm, String time) { super(distanceKm, time); }
    @Override
    public String getType() { return "SEDAN"; }
    @Override
    public double getRatePerKm() { return 15.0; }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double distanceKm, String time) { super(distanceKm, time); }
    @Override
    public String getType() { return "SUV"; }
    @Override
    public double getRatePerKm() { return 20.0; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Cab[] trips = new Cab[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double km = sc.nextDouble();
                String time = sc.next();

                switch (type) {
                    case "MINI":
                        trips[i] = new MiniCab(km, time);
                        break;
                    case "SEDAN":
                        trips[i] = new SedanCab(km, time);
                        break;
                    case "SUV":
                        trips[i] = new SUVCab(km, time);
                        break;
                }
            }

            double grandTotal = 0.0;
            for (Cab cab : trips) {
                double fare = cab.calculateFare();
                if (fare < 0) {
                    System.out.printf("%s: night service not available\n", cab.getType());
                } else {
                    grandTotal += fare;
                    System.out.printf("%s: %.2f\n", cab.getType(), fare);
                }
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}