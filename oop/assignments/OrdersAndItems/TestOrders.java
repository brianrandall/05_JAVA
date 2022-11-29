import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TestOrders {

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.name = "Drip Coffee";
        item1.price = 2.50;

        Item item2 = new Item();
        item2.name = "Latte";
        item2.price = 4.20;

        Item item3 = new Item();
        item3.name = "Cappuccino";
        item3.price = 5.10;

        Item item4 = new Item();
        item4.name = "Mocha";
        item4.price = 3.50;



        Order order1 = new Order();
        order1.name = "Cindhuri";
        
        Order order2 = new Order();
        order2.name = "Jimmy";
        
        Order order3 = new Order();
        order3.name = "Noah";
        

        Order order4 = new Order();
        order4.name = "Sam";
        
        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item3);
        order3.total += item3.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.isReady = true;

        order4.items.add(item2);
        order4.total += item2.price;
        order4.items.add(item2);
        order4.total += item2.price;

        order2.isReady = true;

    }
    
}
