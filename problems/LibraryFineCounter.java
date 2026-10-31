package problems;

import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            LibraryItem[] items = new LibraryItem[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String title = sc.next();
                int daysLate = sc.nextInt();

                switch (type) {
                    case "BOOK":
                        items[i] = new BookItem(title, daysLate);
                        break;
                    case "DVD":
                        items[i] = new DVDItem(title, daysLate);
                        break;
                    case "MAGAZINE":
                        items[i] = new MagazineItem(title, daysLate);
                        break;
                }
            }

            double totalFines = 0.0;
            for (LibraryItem item : items) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf("%s: %.2f\n", item.getTitle(), fine);
            }
            System.out.printf("Total Fines: %.2f\n", totalFines);
        }
    }
}