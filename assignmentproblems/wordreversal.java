package assignmentproblems;
public class wordreversal {
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" "); // Split by single spaces[cite: 6]
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse().toString()); // Reverse word using StringBuilder[cite: 6]
            
            if (i < words.length - 1) {
                result.append(" "); // Re-join reversed words with spaces[cite: 6]
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club")); // Output: olleh bulc[cite: 6]
    }
}
