import java.util.*;
public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <=10; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double totalPrice = 0;
        for(double price : prices) {
            totalPrice += price;
        }
        return totalPrice;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(String item: menuItems) {
            System.out.println(item);
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name");
        String userName = System.console().readLine();


        System.out.println("Hello " + userName);
        System.out.printf("There are %d people in front of you", customers.size());
        customers.add(userName);
    }
}