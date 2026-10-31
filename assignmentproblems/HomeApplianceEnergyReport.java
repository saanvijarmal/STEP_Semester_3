package assignmentproblems;

import java.util.Scanner;

interface SaverModeSupported {
    default double applySaverReduction(double baseUnits) {
        return baseUnits * 0.75; // 25% reduction
    }
}

abstract class Appliance {
    protected int hours;
    protected boolean isSaverMode;

    public Appliance(int hours, boolean isSaverMode) {
        this.hours = hours;
        this.isSaverMode = isSaverMode;
    }

    public abstract String getType();
    public abstract double getPowerRating(); // in Watts

    public double calculateUnits() {
        double baseUnits = (getPowerRating() * hours) / 1000.0;
        if (isSaverMode && (this instanceof SaverModeSupported)) {
            return ((SaverModeSupported) this).applySaverReduction(baseUnits);
        }
        return baseUnits;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0; // ₹8 per kWh
    }

    public boolean isUnsupportedSaverMode() {
        return isSaverMode && !(this instanceof SaverModeSupported);
    }
}

class Fridge extends Appliance {
    public Fridge(int hours, boolean isSaverMode) { super(hours, isSaverMode); }
    @Override
    public String getType() { return "FRIDGE"; }
    @Override
    public double getPowerRating() { return 150.0; }
}

class AC extends Appliance implements SaverModeSupported {
    public AC(int hours, boolean isSaverMode) { super(hours, isSaverMode); }
    @Override
    public String getType() { return "AC"; }
    @Override
    public double getPowerRating() { return 1500.0; }
}

class TV extends Appliance {
    public TV(int hours, boolean isSaverMode) { super(hours, isSaverMode); }
    @Override
    public String getType() { return "TV"; }
    @Override
    public double getPowerRating() { return 100.0; }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer(int hours, boolean isSaverMode) { super(hours, isSaverMode); }
    @Override
    public String getType() { return "WASHER"; }
    @Override
    public double getPowerRating() { return 500.0; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = Integer.parseInt(sc.nextLine().trim());
            Appliance[] appliances = new Appliance[n];

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                String[] parts = line.split("\\s+");
                String type = parts[0];
                int hours = Integer.parseInt(parts[1]);
                boolean isSaver = parts.length > 2 && "SAVER".equalsIgnoreCase(parts[2]);

                switch (type) {
                    case "FRIDGE":
                        appliances[i] = new Fridge(hours, isSaver);
                        break;
                    case "AC":
                        appliances[i] = new AC(hours, isSaver);
                        break;
                    case "TV":
                        appliances[i] = new TV(hours, isSaver);
                        break;
                    case "WASHER":
                        appliances[i] = new Washer(hours, isSaver);
                        break;
                }
            }

            double totalCost = 0.0;
            for (Appliance app : appliances) {
                if (app.isUnsupportedSaverMode()) {
                    System.out.printf("%s: saver mode not supported\n", app.getType());
                } else {
                    double units = app.calculateUnits();
                    double cost = app.calculateCost();
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getType(), units, cost);
                }
            }
            System.out.printf("Total Cost: %.2f\n", totalCost);
        }
    }
}