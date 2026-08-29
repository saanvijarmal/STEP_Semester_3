public class csv {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(","); // Split fields using split(",")[cite: 5]
        
        // Validate exactly 3 fields are present[cite: 5]
        if (fields.length != 3) {
            System.out.println("Invalid Record"); // Print error if validation fails[cite: 5]
            return;
        }
        
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();
        
        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNo, dept); // Formatted output[cite: 5]
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma, RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma, CSE"); // Output: Invalid Record[cite: 5]
    }
}
