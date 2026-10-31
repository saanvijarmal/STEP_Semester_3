package problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate(LocalDate baseDate);

    public void printDueDate(LocalDate baseDate) {
        System.out.println(title + ": " + calculateDueDate(baseDate));
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(14); }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(7); }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(3); }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = Integer.parseInt(sc.nextLine().trim());
            LocalDate baseDate = LocalDate.of(2023, 10, 26);

            LibraryItem[] items = new LibraryItem[n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                int spaceIdx = line.indexOf(' ');
                String type = line.substring(0, spaceIdx);
                String title = line.substring(spaceIdx + 1).replace("\"", "");

                switch (type) {
                    case "BOOK":
                        items[i] = new BookItem(title);
                        break;
                    case "DVD":
                        items[i] = new DVDItem(title);
                        break;
                    case "MAGAZINE":
                        items[i] = new MagazineItem(title);
                        break;
                }
            }

            for (LibraryItem item : items) {
                item.printDueDate(baseDate);
            }
        }
    }
}
