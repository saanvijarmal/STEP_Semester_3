package problems;

import java.util.Scanner;

abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) { super(distance); }
    @Override
    public String getType() { return "BUS"; }
    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + (0.10 * distance));
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) { super(distance); }
    @Override
    public String getType() { return "TRAIN"; }
    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getType() { return "METRO"; }
    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            TransportJourney[] journeys = new TransportJourney[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double distance = sc.nextDouble();

                if (type.equals("METRO")) {
                    double factor = sc.nextDouble();
                    journeys[i] = new MetroJourney(distance, factor);
                } else if (type.equals("TRAIN")) {
                    journeys[i] = new TrainJourney(distance);
                } else {
                    journeys[i] = new BusJourney(distance);
                }
            }

            double grandTotal = 0;
            for (TransportJourney j : journeys) {
                double fare = j.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f\n", j.getType(), fare);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}