package assignmentproblems;
public class atmpin {
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) { // Checks pin length using length()[cite: 6]
            System.out.println("Invalid PIN must be exactly 4 digits."); //[cite: 6]
        } else {
            System.out.println("PIN length OK."); //[cite: 6]
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");  // Output: Invalid PIN must be exactly 4 digits.[cite: 6]
        checkPinLength("4820"); // Output: PIN length OK.[cite: 6]
    }
}