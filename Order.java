import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

public class Order {
    private int orderId;
    private ArrayList<Item> items;
    private String orderStatus;
    private Payment payment;
    private Date shippingDate;
    private Date deliveryDate;

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateStatus(){

        LocalDate localDate = LocalDate.now();

        int comparison = localDate.compareTo(this.deliveryDate.getCurrentDate());

        if (comparison == 0) {
            this.orderStatus = "Shipped";
        } else if (comparison > 0) {
            this.orderStatus = "Delivered";
        }
    }

    public void printOrder(){
        for(Item item : this.items){
            item.printItem();
        }
    }

    public Order(ArrayList<Item> items,Payment payment,int orderId) {

        this.items = items;
        this.payment = payment;
        this.orderId = orderId;
        this.shippingDate = new Date();
        this.deliveryDate = new Date();

        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now().plusDays(3);


        shippingDate.setTime(currentTime.toString());
        shippingDate.setDay(currentDate.getDayOfMonth() + 3);
        shippingDate.setMonth(currentDate.getMonthValue());
        shippingDate.setYear(currentDate.getYear());
        shippingDate.setCurrentDate(currentDate);

        deliveryDate.setTime(currentTime.toString());
        deliveryDate.setDay(currentDate.getDayOfMonth());
        deliveryDate.setMonth(currentDate.getMonthValue());
        deliveryDate.setYear(currentDate.getYear());
        deliveryDate.setCurrentDate(currentDate);


    }

    public int getOrderId() {
        return orderId;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getDeliveryDate() {
        return "Time: "+deliveryDate.getTime()+"\t" +deliveryDate.getDay()+"/"+deliveryDate.getMonth()+"/"+deliveryDate.getYear();
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}

