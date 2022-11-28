import java.util.ArrayList;
import java.util.Random;

public class CodeExample {
    public static void main(String[] args) {
        
        PuzzleJava generator = new PuzzleJava();
       
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        ArrayList<Character> randomLetters = generator.getRandomLetter();
        System.out.println(randomLetters);

        String password = generator.generatePassword();
        System.out.println(password);

        ArrayList<String> passwordSet = generator.getNewPasswordSet(5);
        System.out.println(passwordSet);

    }
    
}
