import java.util.ArrayList;

public class Customer {
    private String username;

    private Cart cart;

    private int customerId;

    private String password;

    private String email;
    private Address address;
    private ArrayList<Order> orders;

    public Customer(String username,int customerId, String password, String email, Address address) {
        this.cart = new Cart();
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.customerId = customerId;
        this.orders = new ArrayList<Order>();
    }

    public Customer() {
        this.cart = new Cart();
        this.orders = new ArrayList<Order>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
