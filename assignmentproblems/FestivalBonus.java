package assignmentproblems;

import java.util.Scanner;

abstract class CompanyEmployee {
    protected String name;
    protected double monthlySalary;

    public CompanyEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends CompanyEmployee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends CompanyEmployee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.05; }
}

class InternEmployee extends CompanyEmployee {
    public InternEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return 2000.0; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            CompanyEmployee[] employees = new CompanyEmployee[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                double salary = sc.nextDouble();

                switch (type) {
                    case "FULLTIME":
                        employees[i] = new FullTimeEmployee(name, salary);
                        break;
                    case "PARTTIME":
                        employees[i] = new PartTimeEmployee(name, salary);
                        break;
                    case "INTERN":
                        employees[i] = new InternEmployee(name, salary);
                        break;
                }
            }

            double totalBonus = 0;
            for (CompanyEmployee emp : employees) {
                double bonus = emp.calculateBonus();
                totalBonus += bonus;
                System.out.printf("%s: %.2f\n", emp.getName(), bonus);
            }
            System.out.printf("Total Bonus: %.2f\n", totalBonus);
        }
    }
}