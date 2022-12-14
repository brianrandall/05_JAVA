package oop.assignments.BaristasChallenge;

import java.util.ArrayList;


public class TestOrders {

    public static void main(String[] args) {
        
        Item item1 = new Item("cappuccino", 3.50);
        Item item2 = new Item("mocha", 4.20);
        Item item3 = new Item("latte", 5.10);
        Item item4 = new Item("drip coffee", 3.57);



        Order order1 = new Order();
        Order order2 = new Order();
        
        Order order3 = new Order("anna");
        Order order4 = new Order("emilie");
        Order order5 = new Order("coco");
        

        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item3);
        order2.addItem(item4);

        order3.addItem(item1);
        order3.addItem(item2);
        
        order4.addItem(item3);
        order4.addItem(item4);

        order5.addItem(item1);
        order5.addItem(item2);

        System.out.println(order1.getStatusMessage());

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getTotal());

        order3.display();


    }
    
}
