public class TestOrders {

    public static void main(String[] args) {

        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
        coffeeKiosk.addMenuItem("cappuccino", 3.50);
        coffeeKiosk.addMenuItem("mocha", 4.20);
        coffeeKiosk.addMenuItem("latte", 5.10);
        coffeeKiosk.addMenuItem("drip coffee", 3.57);

        coffeeKiosk.newOrder();
    }    
}
