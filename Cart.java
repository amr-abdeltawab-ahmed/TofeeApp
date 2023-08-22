import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addToCart(Item item) {
        items.add(item);
    }

    public void removeFromCart(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getCartItems() {
        return items;
    }

    public double getCartTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += (item.getPrice() * item.getQuantity());
        }
        return total;
    }

}
