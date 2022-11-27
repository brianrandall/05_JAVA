public class TestGreetings {
    public static void main(String[] args) {

        // to use the greetings methods
        // create a variable of type "Greetings"

        Greetings greeterApp = new Greetings();

        // use the cariable to access Greetings's methods
        // using dot notation

        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }
}

