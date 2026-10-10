package assignmentproblems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
        }
        System.out.println("Traffic light changed to: " + color);
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial color: " + t.getColor());
        t.next();
        t.next();
        t.next();
    }
}
