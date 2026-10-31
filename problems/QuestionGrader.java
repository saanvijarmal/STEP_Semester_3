package problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();
    public abstract double calculateScore();
}

class MCQQuestion extends Question {
    public MCQQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override
    public String getType() { return "MCQ"; }
    @Override
    public double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override
    public String getType() { return "TF"; }
    @Override
    public double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override
    public String getType() { return "ESSAY"; }
    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            if (lowerStudentAns.contains(kw.trim().toLowerCase())) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) return points * 0.75;
        if (matchedCount == 1) return points * 0.50;
        return 0.0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = Integer.parseInt(sc.nextLine().trim());
            Question[] questions = new Question[n];

            Pattern pattern = Pattern.compile("\"([^\"]*)\"");

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                String type = line.substring(0, line.indexOf(' '));

                Matcher matcher = pattern.matcher(line);
                String qText = matcher.find() ? matcher.group(1) : "";
                String cAns = matcher.find() ? matcher.group(1) : "";
                String sAns = matcher.find() ? matcher.group(1) : "";

                int lastSpace = line.lastIndexOf(' ');
                double points = Double.parseDouble(line.substring(lastSpace + 1));

                switch (type) {
                    case "MCQ":
                        questions[i] = new MCQQuestion(qText, cAns, sAns, points);
                        break;
                    case "TF":
                        questions[i] = new TFQuestion(qText, cAns, sAns, points);
                        break;
                    case "ESSAY":
                        questions[i] = new EssayQuestion(qText, cAns, sAns, points);
                        break;
                }
            }

            double totalScore = 0;
            for (Question q : questions) {
                double score = q.calculateScore();
                totalScore += score;
                System.out.printf("%s: %.2f\n", q.getType(), score);
            }
            System.out.printf("Total Score: %.2f\n", totalScore);
        }
    }
}