public class Item {
    private int item_id;
    private String name;
    private int quantity = 1;
    private double price;
    private String description;
    private boolean available;
    private int categoryId;


    public int getItem_id() {
        return item_id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Item(String name,int item_id, double price, String description, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.item_id = item_id;
    }

    public void printItem(){
        System.out.println("Item Name: " + this.getName());
        System.out.println("Item Price: " + this.getPrice());
        System.out.println("Item quantity: " + this.getQuantity());
        System.out.println("Item Category ID: " + this.getCategoryId());
        System.out.println("Item Descriptyion: " + this.getDescription());
        System.out.println("------------------");

    }

    public void printItemCustomer(){
        System.out.println(this.getName()+"\tPrice: "+ this.getPrice());
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
