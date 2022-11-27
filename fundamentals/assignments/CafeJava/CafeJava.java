public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = "Your order will be ready shortly...";
        String readyMessage = "Your order is ready! ";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.50;
        double dripCoffeePrice = 2.50;
        double lattePrice = 4.20;
        double cappuccinoPrice = 5.10;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

        System.out.println(generalGreeting + customer1);
        System.out.println(displayTotalMessage + dripCoffeePrice);
        System.out.println(".......");
        System.out.println(isReadyOrder1 ? readyMessage : pendingMessage);
        System.out.println(" ");

        System.out.println(generalGreeting + customer4);
        System.out.println(displayTotalMessage + cappuccinoPrice);
        System.out.println(".......");
        System.out.println(isReadyOrder2 ? readyMessage : pendingMessage);
        System.out.println(" ");

        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage + (lattePrice*2));
        System.out.println(".......");
        System.out.println(isReadyOrder3 ? readyMessage : pendingMessage);
        System.out.println(" ");

        System.out.println(generalGreeting + customer3);
        System.out.println("were sorry we messed up your order... ");
        System.out.println("your new total is $ " + (lattePrice - dripCoffeePrice));
    }
}