public class vowelandconsonant {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        
        String lowerText = text.toLowerCase(); // Ensure case-insensitive comparison[cite: 5]
        
        for (int i = 0; i < lowerText.length(); i++) { // Loop using charAt()[cite: 5]
            char ch = lowerText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { // Count vowels[cite: 5]
                    vowels++;
                } else { // Count consonants[cite: 5]
                    consonants++;
                }
            }
            // Spaces and non-alphabetic characters are naturally ignored[cite: 5]
        }
        
        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming"); // Output: Vowels: 5 | Consonants: 10[cite: 5]
    }
}
