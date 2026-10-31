package assignmentproblems;

import java.util.Scanner;

interface TransportUser {
    static final double TRANSPORT_FEE = 12000.0;
    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getTuitionAndHostelFee();

    public double calculateTotalFee() {
        double total = getTuitionAndHostelFee();
        if (this instanceof TransportUser) {
            total += ((TransportUser) this).getTransportFee();
        }
        return total;
    }
}

class DayScholarStudent extends Student implements TransportUser {
    public DayScholarStudent(String name) { super(name); }
    @Override
    public double getTuitionAndHostelFee() { return 40000.0; }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) { super(name); }
    @Override
    public double getTuitionAndHostelFee() { return 40000.0 + 60000.0; }
}

class ScholarshipStudent extends Student implements TransportUser {
    public ScholarshipStudent(String name) { super(name); }
    @Override
    public double getTuitionAndHostelFee() { return 20000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            Student[] students = new Student[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();

                switch (type) {
                    case "DAY_SCHOLAR":
                        students[i] = new DayScholarStudent(name);
                        break;
                    case "HOSTELLER":
                        students[i] = new HostellerStudent(name);
                        break;
                    case "SCHOLAR":
                        students[i] = new ScholarshipStudent(name);
                        break;
                }
            }

            double grandTotal = 0.0;
            for (Student student : students) {
                double fee = student.calculateTotalFee();
                grandTotal += fee;
                System.out.printf("%s: %.2f\n", student.getName(), fee);
            }
            System.out.printf("Total Collected: %.2f\n", grandTotal);
        }
    }
}