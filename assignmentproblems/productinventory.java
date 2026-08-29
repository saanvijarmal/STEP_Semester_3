package assignmentproblems;
public class productinventory {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(","); // Split fields using split(",")[cite: 6]

        if (fields.length != 3) { // Validate exactly 3 fields[cite: 6]
            System.out.println("Invalid Record"); //[cite: 6]
            return;
        }

        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", product, sku, qty); // Formatted output[cite: 6]
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse, WM-2201,150"); // Output: Product: Wireless Mouse | SKU: WM-2201 | Qty: 150[cite: 6]
        parseInventoryRecord("Wireless Mouse, 150");          // Output: Invalid Record[cite: 6]
    }
}
