package assignmentproblems;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract String getType();
    public abstract double calculateShippingCharge();

    public double calculateInsuranceFee() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance(declaredValue);
        }
        return 0.0;
    }

    public double calculateTotalCost() {
        return calculateShippingCharge() + calculateInsuranceFee();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override
    public String getType() { return "STANDARD"; }
    @Override
    public double calculateShippingCharge() { return 40.0 + (10.0 * weightKg); }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override
    public String getType() { return "EXPRESS"; }
    @Override
    public double calculateShippingCharge() { return 80.0 + (15.0 * weightKg); }
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override
    public String getType() { return "FRAGILE"; }
    @Override
    public double calculateShippingCharge() { return 40.0 + (10.0 * weightKg) + 50.0; }
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Parcel[] parcels = new Parcel[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double weight = sc.nextDouble();
                double value = sc.nextDouble();

                switch (type) {
                    case "STANDARD":
                        parcels[i] = new StandardParcel(weight, value);
                        break;
                    case "EXPRESS":
                        parcels[i] = new ExpressParcel(weight, value);
                        break;
                    case "FRAGILE":
                        parcels[i] = new FragileParcel(weight, value);
                        break;
                }
            }

            double grandTotal = 0.0;
            for (Parcel p : parcels) {
                double charge = p.calculateShippingCharge();
                double insurance = p.calculateInsuranceFee();
                double total = p.calculateTotalCost();
                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                        p.getType(), charge, insurance, total);
            }
            System.out.printf("Grand Total: %.2f\n", grandTotal);
        }
    }
}