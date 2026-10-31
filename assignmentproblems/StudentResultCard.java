package assignmentproblems;

import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public char calculateGrade(double avg) {
        if (avg >= 75.0) return 'B';
        if (avg >= 40.0) return 'D';
        return 'F';
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                int openBracket = line.indexOf('[');
                int closeBracket = line.indexOf(']');
                if (openBracket == -1 || closeBracket == -1) continue;

                String name = line.substring(0, openBracket).trim();
                String[] markTokens = line.substring(openBracket + 1, closeBracket).split(",");
                int[] marks = new int[markTokens.length];
                for (int i = 0; i < markTokens.length; i++) {
                    marks[i] = Integer.parseInt(markTokens[i].trim());
                }

                Student student = new Student(name, marks);
                student.printResultCard();
            }
        }
    }
}
