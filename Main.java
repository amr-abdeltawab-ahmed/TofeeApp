import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Category> categoryList = new ArrayList<Category>();


        int itemId = 50000;
        int customerId = 1000;
        int orderId = 200;

        itemList.add(new Item("Gummy Bears",itemId++,3,"Chewy, fruit-flavored gummies",1201));
        itemList.add(new Item("Chocolate Bars",itemId++,4,"Rich, creamy milk or dark chocolate bars",1202));
        itemList.add(new Item("Sour Patch Kids",itemId++,2.5,"Tangy, sour sugar coating with a sweet gummy center",1201));
        itemList.add(new Item("Jelly Beans",itemId++,2.5,"Assorted fruit-flavored jelly beans",1201));
        itemList.add(new Item("Licorice Twists",itemId++,2,"Chewy black licorice twists",1201));
        itemList.add(new Item("Swedish Fish",itemId++,3,"Soft, chewy fish-shaped candies with fruity flavors",1201));
        itemList.add(new Item("Lollipops",itemId++,1,"Assorted fruit-flavored lollipops",1201));
        itemList.add(new Item("Jawbreakers",itemId++,3.5,"Hard, long-lasting candy with layers of different colors",1201));
        itemList.add(new Item("Taffy",itemId++,3,"Soft, chewy candy in a variety of flavors",1201));
        itemList.add(new Item("Mints",itemId++,2,"Refreshing, mint-flavored hard candies",1203));

        // hello in the main page
        System.out.println("Welcome to Toffe Application");
        System.out.println("1-Customer.\n2-Admin.");
        System.out.print("Enter:");
        int choice = input.nextInt();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch(choice) {
            // hello in customer page
            case 1:
                while(true) {
                    System.out.println("Hello in Customer Section");
                    System.out.println("1-Login.\n2-Register.\n3-Go Back.");
                    System.out.print("Enter:");

                    int choice2 = input.nextInt();

                    if(choice2 == 3){
                        break;
                    }

                    input.nextLine(); // consume newline character

                    // user and password
                    System.out.print("Enter Username: ");
                    String name = input.nextLine();

                    System.out.print("Enter password: ");
                    String password = input.nextLine();

                    // hello in login page
                    if(choice2 == 1) {
                        Customer cu1 = new Customer();
                        for (Customer customer : customerList) {
                            if (customer.getUsername().equals(name) && customer.getPassword().equals(password)) {
                                cu1 = customer;
                                System.out.println("You have successfully log-in.");
                                break;  // stop searching once a match is found
                            }
                        }
                        // you are in the account of the customer
                        if((cu1.getUsername().equals(name)) && (cu1.getPassword().equals(password))){
                            while(true) {
                                System.out.println("Welcome to Main Page " + cu1.getUsername());
                                System.out.println("What would you like to do ?");
                                System.out.println("1-Shop.\n2-View Orders.\n3-Log out.");
                                System.out.print("Enter: ");

                                int choice3 = input.nextInt();

                                // shop
                                if (choice3 == 1) {
                                    while (true) {
                                        System.out.println("1-Add item to Cart.\n2-Show items details.\n3-Go to Cart.\n4-Go back.");
                                        System.out.print("Enter: ");

                                        int choice4 = input.nextInt();

                                        // Add to Cart
                                        if (choice4 == 1) {
                                            while (true) {

                                                if (itemList.size() == 0) {
                                                    System.out.println("No items in the Application.");
                                                    break;
                                                }

                                                for (int i = 0; i < itemList.size(); i++) {
                                                    System.out.print((i + 1) + "-");
                                                    itemList.get(i).printItemCustomer();
                                                }

                                                System.out.print("Enter the item number or 0-Exit: ");
                                                int itemNum = input.nextInt();

                                                if (itemNum == 0) {
                                                    break;
                                                } else if (!(itemNum > 0 && itemNum <= itemList.size())) {
                                                    System.out.println("This number of item not found.");
                                                } else {
                                                    System.out.println("How many do you want ?");
                                                    System.out.print("Enter: ");

                                                    int quantity = input.nextInt();

                                                    Item item = itemList.get(itemNum - 1);
                                                    item.setQuantity(quantity);


                                                    cu1.getCart().addToCart(item);

                                                }

                                            }

                                            // Show item details
                                        } else if (choice4 == 2) {

                                            if (itemList.size() == 0) {
                                                System.out.println("No items in the Application.");
                                                break;
                                            }

                                            for (int i = 0; i < itemList.size(); i++) {
                                                System.out.print(i + "-");
                                                itemList.get(i).printItem();
                                            }

                                            // go to cart
                                        } else if (choice4 == 3) {
                                            while (true) {
                                                if (cu1.getCart().getCartItems().size() == 0) {
                                                    System.out.println("Your cart are empty");
                                                    break;
                                                }

                                                for (Item item : cu1.getCart().getCartItems()) {
                                                    System.out.print(item.getQuantity() + " ");
                                                    item.printItemCustomer();
                                                }

                                                System.out.println("1-Check-out.\n2-remove item.\n3-Go back.");
                                                System.out.print("Enter: ");

                                                int choice5 = input.nextInt();

                                                // check-out
                                                if (choice5 == 1) {
                                                    Payment payment = new Payment();
                                                    Date date = new Date();

                                                    System.out.println("What is the type of the Payment ?\n1-Pay on cash.\n2-Pay by Visa.");
                                                    System.out.print("Enter: ");

                                                    int choice6 = input.nextInt();

                                                    System.out.println("Order is coming.");

                                                    if (choice6 == 1) {
                                                        payment.setPaymentDone(false);
                                                        payment.setPaymentMethod("OnCash");
                                                        payment.setAmount(cu1.getCart().getCartTotal());

                                                        LocalTime currentTime = LocalTime.now();
                                                        LocalDate currentDate = LocalDate.now();

                                                        date.setTime(currentTime.toString());
                                                        date.setYear(currentDate.getYear());
                                                        date.setDay(currentDate.getDayOfMonth() + 3);
                                                        date.setMonth(currentDate.getMonthValue());

                                                        payment.setPaymentDate(date);


                                                    } else if (choice6 == 2) {
                                                        payment.setPaymentDone(true);
                                                        payment.setPaymentMethod("Visa");
                                                        payment.setAmount(cu1.getCart().getCartTotal());

                                                        LocalTime currentTime = LocalTime.now();
                                                        LocalDate currentDate = LocalDate.now();

                                                        date.setTime(currentTime.toString());
                                                        date.setYear(currentDate.getYear());
                                                        date.setDay(currentDate.getDayOfMonth());
                                                        date.setMonth(currentDate.getMonthValue());

                                                        payment.setPaymentDate(date);
                                                    }


                                                    Order order = new Order(cu1.getCart().getCartItems(), payment, orderId++);
                                                    order.setOrderStatus("Processing");
                                                    cu1.getOrders().add(order);
                                                    cu1.setCart(new Cart());
                                                    System.out.println("Order ID: " + order.getOrderId());
                                                    System.out.println("Price: " + payment.getAmount());
                                                    System.out.println("Delivery Date:" + order.getDeliveryDate());

                                                    // remove item from cart
                                                } else if (choice5 == 2) {

                                                } else if (choice5 == 3) {
                                                    break;
                                                }
                                            }
                                            break;
                                            // go back
                                        } else if (choice4 == 4) {
                                            break;
                                        }
                                    }

                                    // view orders
                                } else if (choice3 == 2) {
                                    if (cu1.getOrders().size() == 0) {
                                        System.out.println("No Orders in this account.");
                                    }

                                    for (Order order : cu1.getOrders()) {
                                        order.updateStatus();
                                        order.printOrder();
                                    }

                                } else if (choice3 == 3) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice, please try again");
                                }
                            }
                        }else{
                            System.out.println("the user or password wrong check you email or password and try again.");
                        }
                    }

                        // hello in register page
                       else if(choice2 == 2){
                        System.out.print("Enter Email: ");
                        String email = input.nextLine();

                        System.out.print("Enter Street name: ");
                        String street = input.nextLine();

                        System.out.print("Enter City name: ");
                        String city = input.nextLine();

                        System.out.print("Enter State name: ");
                        String state = input.nextLine();

                        System.out.print("Enter your ZIP Code: ");
                        int zip_code = input.nextInt();

                        Address addre1 = new Address(city,street,state,zip_code);

                        Customer cu1 = new Customer(name,customerId++,password,email,addre1);

                        // add customer to customers list
                        customerList.add(cu1);

                        System.out.println("You have been registered successfully.");

                    }
                }

                // hello in admin section
            case 2:
                while(true) {
                    System.out.println("Hello in Admin Section");
                    System.out.println("1-Login.\n2-Register (you cant do this in GUI).\n3-Go Back.");
                    System.out.print("Enter: ");

                    int choice2 = input.nextInt();

                    // condition to go back
                    if(choice2 == 3){
                        break;
                    }

                    input.nextLine(); // consume newline character

                    // user and password
                    System.out.print("Enter Username: ");
                    String name = input.nextLine();

                    System.out.print("Enter password: ");
                    String password = input.nextLine();

                    // hello in login page
                    if(choice2 == 1 ) {
                        Admin ad1 = new Admin();
                        for (Admin admin : adminList) {
                            if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
                                ad1 = admin;
                                System.out.println("You have successfully log-in.");
                                break;  // stop searching once a match is found
                            }
                        }
                        // you are in the account of the admin
                        if((ad1.getName().equals(name)) && (ad1.getPassword().equals(password))){
                            while (true) {

                                System.out.println("Welcome to Main Page " + ad1.getName());
                                System.out.println("1-Add.\n2-Remove.\n3-View items with (ID).\n4-View Customers.\n5-View Customer Orders.\n6-Go Back.");
                                System.out.print("Enter: ");

                                int choice3 = input.nextInt();

                                // add item
                                if (choice3 == 1) {
                                    System.out.println("Welcome to Add Page " + ad1.getName());

                                    input.nextLine();
                                    System.out.print("Enter Item Name: ");
                                    String itemName = input.nextLine();

                                    input.nextLine();

                                    System.out.print("Enter the price of the item: ");
                                    double price = input.nextDouble();

                                    input.nextLine();


                                    System.out.print("Enter the Description of this item: ");
                                    String description = input.nextLine();

                                    System.out.print("Enter the category ID from(1000-2000): ");
                                    int categoryId = input.nextInt();

                                    Item item = new Item(itemName,itemId++, price, description, categoryId);
                                    itemList.add(item);

                                    Category cat1 = new Category();
                                    for (Category category : categoryList) {
                                        // if we found the category of the item from the same id
                                        if (category.getCategory_it() == categoryId) {
                                            category.additem(item);
                                            cat1 = category;
                                            break;  // stop searching once a match is found
                                        }
                                    }

                                    // if the category is not found
                                    if (cat1.getCategory_it() != categoryId) {
                                        input.nextLine();

                                        System.out.print("Enter category name: ");
                                        String catName = input.nextLine();

                                        System.out.print("Enter category Description: ");
                                        String decsrptionCat = input.nextLine();

                                        cat1.setDescription(decsrptionCat);
                                        cat1.setCategoryId(categoryId);
                                        cat1.setName(catName);
                                        cat1.additem(item);
                                        categoryList.add(cat1);
                                    }

                                    System.out.println("The Item is successfully added.");


                                    //System.out.println("1-Gummy bears\n2-Jellybeans\n3-Sour patch kids\n4-Chocolate bars (milk, dark, white)\n5-M&M's\n6-Licorice\n7-Taffy\n8-Hard candy (various flavors)\n9-Cotton candy\n10-Chocolate-covered pretzels\n11-Caramel apples\n12-Fudge (various flavors)\n13-Chocolate truffles\n14-Lollipops (various flavors)\n15-Peppermint sticks\n");
                                    // remove
                                } else if (choice3 == 2) {

                                    System.out.print("Enter the ID of the item you wants to remove: ");
                                    int idItem = input.nextInt();

                                    int itemsNumber = itemList.size();

                                    for (Item item : itemList){
                                        if(item.getItem_id() == idItem){
                                            itemList.remove(item);
                                            System.out.println("The item has been removed.");
                                            break;
                                        }
                                    }

                                    if(itemsNumber == itemList.size()){
                                        System.out.println("No item with this ID");
                                    }

                                    // view items
                                } else if (choice3 == 3) {
                                    if (itemList.size() == 0){
                                        System.out.println("No items in the Application.");
                                        break;
                                    }
                                    for (Item item : itemList) {
                                        System.out.println("Item ID: "+item.getItem_id());
                                        item.printItem();
                                    }

                                    // view customers
                                } else if (choice3 == 4) {
                                    if(customerList.size() == 0){
                                        System.out.println("No customer in the application.");
                                    }

                                    for (Customer customer : customerList) {
                                        System.out.println("Customer ID: " + customer.getCustomerId());
                                        System.out.println("Customer Name: " + customer.getUsername());
                                        System.out.println("Customer Email: " + customer.getEmail());
                                        System.out.println("Customer Address: " + customer.getAddress().printAddress());
                                    }

                                    // view customer order
                                } else if (choice3 == 5) {
                                    System.out.println("Enter the name of the customer you wants to see his orders: ");
                                    int uCustomerID = input.nextInt();

                                    int foundID = 0;

                                    for(int i = 0;i <customerList.size();i++){
                                        if(customerList.get(i).getCustomerId() == uCustomerID){
                                            foundID = customerList.get(i).getCustomerId();
                                            for(int j =0;j<customerList.get(i).getOrders().size();j++){
                                                Customer cus = customerList.get(i);
                                                Order order = cus.getOrders().get(j);
                                                order.updateStatus();
                                                Item it = order.getItems().get(j);
                                                it.printItem();
                                            }
                                        }
                                    }
                                    if(foundID != uCustomerID){
                                        System.out.println("This user not found.");
                                        break;
                                    }

                                } else if(choice3 == 6){
                                    break;
                                } else {
                                    System.out.println("Invalid choice, please try again");
                                }
                            }
                        }
                            else{
                            System.out.println("the Name or password wrong check them and try again.");
                        }

                        // hello in register page for admin
                    }else if(choice2 == 2){
                        System.out.print("Enter Email: ");
                        String email = input.nextLine();

                        Admin ad1 = new Admin(name,email,password);

                        // add customer to customers list
                        adminList.add(ad1);

                        System.out.println("You have been registered successfully.");
                    }

                }

            default:
                // code to be executed if expression does not match any of the values
                break;
        }
        //
    }
}