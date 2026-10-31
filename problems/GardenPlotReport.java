package problems;

import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShape();
    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShape() { return "CIRCLE"; }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShape() { return "RECTANGLE"; }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShape() { return "TRIANGLE"; }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Plot[] plots = new Plot[n];

            for (int i = 0; i < n; i++) {
                String shape = sc.next();
                String owner = sc.next();

                switch (shape) {
                    case "CIRCLE":
                        double radius = sc.nextDouble();
                        plots[i] = new CirclePlot(owner, radius);
                        break;
                    case "RECTANGLE":
                        double length = sc.nextDouble();
                        double width = sc.nextDouble();
                        plots[i] = new RectanglePlot(owner, length, width);
                        break;
                    case "TRIANGLE":
                        double base = sc.nextDouble();
                        double height = sc.nextDouble();
                        plots[i] = new TrianglePlot(owner, base, height);
                        break;
                }
            }

            double totalArea = 0.0;
            for (Plot p : plots) {
                double area = p.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShape(), area);
            }
            System.out.printf("Total Area: %.2f\n", totalArea);
        }
    }
}