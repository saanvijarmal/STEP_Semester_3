package assignmentproblems;

import java.util.Scanner;

abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) { super(units); }
    @Override
    public String getType() { return "SINGLE"; }
    @Override
    public double calculateBill() { return units * 8.0; }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getType() { return "SHARED"; }
    @Override
    public double calculateBill() { return (units * 6.0) / occupants; }
}

class ACRoom extends HostelRoom {
    public ACRoom(int units) { super(units); }
    @Override
    public String getType() { return "AC"; }
    @Override
    public double calculateBill() { return (units * 10.0) + 200.0; }
}

public class HostelElectricity {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            HostelRoom[] rooms = new HostelRoom[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();

                if (type.equals("SHARED")) {
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                } else if (type.equals("SINGLE")) {
                    rooms[i] = new SingleRoom(units);
                } else {
                    rooms[i] = new ACRoom(units);
                }
            }

            double grandTotal = 0;
            for (HostelRoom room : rooms) {
                double bill = room.calculateBill();
                grandTotal += bill;
                System.out.printf("%s: %.2f\n", room.getType(), bill);
            }
            System.out.printf("Total: %.2f\n", grandTotal);
        }
    }
}