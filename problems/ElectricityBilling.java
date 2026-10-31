package problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) { super(units); }

    @Override
    public String getType() { return "HOME"; }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) { super(units); }

    @Override
    public String getType() { return "SHOP"; }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) { super(units); }

    @Override
    public String getType() { return "FACTORY"; }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            ElectricityConnection[] connections = new ElectricityConnection[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();

                switch (type) {
                    case "HOME":
                        connections[i] = new HomeConnection(units);
                        break;
                    case "SHOP":
                        connections[i] = new ShopConnection(units);
                        break;
                    case "FACTORY":
                        connections[i] = new FactoryConnection(units);
                        break;
                }
            }

            double grandTotal = 0.0;
            for (ElectricityConnection conn : connections) {
                double bill = conn.calculateBill();
                grandTotal += bill;
                System.out.printf("%s: %.2f\n", conn.getType(), bill);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}