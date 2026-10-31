package assignmentproblems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            SubscriptionPlan[] subscribers = new SubscriptionPlan[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                LocalDate startDate = LocalDate.parse(sc.next());

                switch (type) {
                    case "BASIC":
                        subscribers[i] = new BasicPlan(name, startDate);
                        break;
                    case "STANDARD":
                        subscribers[i] = new StandardPlan(name, startDate);
                        break;
                    case "PREMIUM":
                        subscribers[i] = new PremiumPlan(name, startDate);
                        break;
                }
            }

            for (SubscriptionPlan sub : subscribers) {
                System.out.println(sub.getSubscriberName() + ": " + sub.calculateRenewalDate());
            }
        }
    }
}