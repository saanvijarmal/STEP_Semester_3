public class fileextension {
    public static String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.'); // Find last '.' index[cite: 5]
        
        if (lastDotIndex != -1 && lastDotIndex < filename.length() - 1) {
            String extension = filename.substring(lastDotIndex + 1); // Extract extension[cite: 5]
            
            // Compare case-insensitively against valid formats[cite: 5]
            if (extension.equalsIgnoreCase("pdf") || 
                extension.equalsIgnoreCase("docx") || 
                extension.equalsIgnoreCase("zip")) {
                return "Accepted";
            }
        }
        
        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF")); // Output: Accepted[cite: 5]
        System.out.println(validateFileExtension("notes.txt"));       // Output: Rejected - invalid file type[cite: 5]
    }
}
