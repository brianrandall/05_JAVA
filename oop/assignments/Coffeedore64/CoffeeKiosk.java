import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk(){}

    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        menu.add(item);
        int index = menu.indexOf(item);
        item.setIndex(index);
    }
    
    public void displayMenu() {
        System.out.println("Menu:");
        for (Item x : menu) {
            System.out.println(x.getIndex() + " " + x.getName() + " -- $" + x.getPrice());
        }
    }

    public void newOrder() {
        System.out.println("please enter a name for your order:");
        String name = System.console().readLine();

        Order newOrder = new Order(name);
        displayMenu();

        System.out.println("enter a menu item, or ~q~ to exit and pay:");
        String input = System.console().readLine();

        while(!input.equals("q")) {
            int index = Integer.parseInt(input);
            if(index < this.menu.size()) {
                Item item = this.menu.get(index);
                newOrder.addItem(item);
            } else {
                System.out.println("nope, try again dummy");
            }
            System.out.println("anything else? enter a menu item or ~q~ to exit and pay:");
            input = System.console().readLine();
        }
        newOrder.display();
        this.orders.add(newOrder);
    }
    
}
