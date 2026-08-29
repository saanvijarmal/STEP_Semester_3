public class maskedphoneno {
    public static String maskPhoneNumber(String phone) {
        // Validate string is non-null, exactly 10 digits, and all numeric[cite: 5]
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        // Build masked output using StringBuilder[cite: 5]
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-"); // Insert hyphen separator[cite: 5]
        masked.append(phone.substring(6)); // Append last 4 digits[cite: 5]
        
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // Output: XXXXXX-3210[cite: 5]
        System.out.println(maskPhoneNumber("98765"));      // Output: Invalid phone number[cite: 5]
    }
}
