import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randomRolls.add(randMachine.nextInt(20) + 1);
        }
        return randomRolls;
    }

    public ArrayList<Character> getRandomLetter() {
        ArrayList<Character> randomLetters = new ArrayList<Character>();
        for (int i = 0; i < 5; i++) {
            randomLetters.add((char) (randMachine.nextInt(26) + 'a'));
        }
        return randomLetters;
    }
    
    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += (char) (randMachine.nextInt(26) + 'a');
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }

}