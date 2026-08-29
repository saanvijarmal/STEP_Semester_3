package assignmentproblems;
public class library {
    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim(); // Trim spaces[cite: 6]

        if (trimmed.length() < 3) return trimmed;

        // Uppercase first 3 characters and preserve remaining text[cite: 6]
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return pubCode + rest;
    }

    public static String validateAndFormat(String code) {
        // Validate total length is exactly 13 characters[cite: 6]
        if (code.length() != 13) {
            return "Invalid: wrong length"; //[cite: 6]
        }

        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters"; 
            }
        }

       
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

       
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(input1)); // Output: [PEN] YEAR: 2026 | CATALOG: 004251[cite: 6]

        String input2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(input2)); // Output: Invalid: publisher code must be 3 letters[cite: 6]
    }
}
