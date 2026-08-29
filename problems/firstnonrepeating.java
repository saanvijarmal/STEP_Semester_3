public class firstnonrepeating {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256]; // Frequency array for ASCII characters

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null char if no non-repeating character exists
    }

    public static void processText(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        processText("swiss");   // Output: 'w'
        processText("aabbcc");  // Output: No Non-Repeating Character Found
    }
}
