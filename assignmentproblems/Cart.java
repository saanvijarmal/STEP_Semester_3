package assignmentproblems;

public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.itemPrices = new double[maxCapacity];
        this.itemCount = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void addItem(double price) {
        if (itemCount < itemPrices.length) {
            itemPrices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full!");
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + (int) cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}
