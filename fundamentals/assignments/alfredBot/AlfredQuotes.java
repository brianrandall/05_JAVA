import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, nice to see you. How are you?";
    }
    public String guestGreeting(String name) {
        
        Date date = new Date();
        int hour = date.getHours();

        if (hour < 12) {
            return "Good morning, " + name + ".";
        } else if (hour > 17) {
            return "Good evening, " + name + ".";
        } else {
            return "Good afternoon, " + name + ".";
        }
        
    }
    public String dateAnnouncement() {
        Date date = new Date();
        return "todays date and time is - " + date;
    }
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("alexis");
        int c = conversation.indexOf("Alfred");
        int d = conversation.indexOf("alfred");

        if (a >= 0 || b >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (c >= 0 || d >= 0) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }

    public String angryResponse(String anger) {
        int a = anger.indexOf("C# is better than");
        int b = anger.indexOf("c# is better than");
        String response = "java is better than C#";

        if (a >= 0 || b >= 0) {
            return response.toUpperCase();
        }
        return response;
    }
}