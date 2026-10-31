package assignmentproblems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override
    public String getType() { return "BIKE"; }
    @Override
    public double calculateCharge() { return hours * 10.0; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override
    public String getType() { return "CAR"; }
    @Override
    public double calculateCharge() {
        return 30.0 + Math.max(0, hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override
    public String getType() { return "TRUCK"; }
    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Vehicle[] vehicles = new Vehicle[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int hours = sc.nextInt();

                switch (type) {
                    case "BIKE":
                        vehicles[i] = new Bike(hours);
                        break;
                    case "CAR":
                        vehicles[i] = new Car(hours);
                        break;
                    case "TRUCK":
                        vehicles[i] = new Truck(hours);
                        break;
                }
            }

            double grandTotal = 0;
            for (Vehicle v : vehicles) {
                double charge = v.calculateCharge();
                grandTotal += charge;
                System.out.printf("%s: %.2f\n", v.getType(), charge);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}