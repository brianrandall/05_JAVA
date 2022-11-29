import java.util.ArrayList;

public class Order {
    
    private String name;
    private boolean isReady;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(String name) {
        this.name = name;
        this.isReady = false;
    }

    public Order(){
        this.name = "guest";
        this.isReady = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (!this.isReady){
            return "Your order is not ready yet.";
        } else {
            return "Your order is ready!";
        }
    }

    public double getTotal(){
        double total = 0;
        for (Item item : this.items){
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Order for " + this.name);
        System.out.println("Items:");
        for (Item item : this.items){
            System.out.println(item.getName() + " $" + item.getPrice());
        }
        System.out.println("Total: $" + this.getTotal());
        System.out.println(this.getStatusMessage());
    }

}
