public class SwitchAndTernary {
    
    public static void main(String[] args) {   
      // Your friend has asked you to watch the replay of a game you missed 
    int goals = 3;
    boolean watchReplay = false;

    System.out.println("Are we watching this?");

      switch(goals){
        case 0:
          System.out.println("Sounds like a boring game.");
		      break;
        case 1:
          System.out.println("Was it a good goal?");
          watchReplay = true;
		      break;
        case 2:
          System.out.println("Was it a tie?");
          watchReplay = true;
		      break;
        case 3:
          System.out.println("I can't wait to see it!");
          watchReplay = true;
		      break;
        default:
          System.out.println("More than 3 goals? I'm in!");
          watchReplay = true;
      }

      System.out.println(watchReplay ? "I'll see you in a bit." : "I'll pass.");
    }
}