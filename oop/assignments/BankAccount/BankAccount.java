import java.util.Random;
import java.util.random.*;

public class BankAccount {

    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalAmountOfMoney = 0;

    public BankAccount(){
        this.accountNumber = this.generateAccountNumber();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static double getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    private String generateAccountNumber(){
        String accountNumber = "";
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            accountNumber += r.nextInt(10);
        }
        return accountNumber;
    }

    public void depositMoney(double amount, String account){
        if (account.equals("checking")){
            this.checkingBalance += amount;
        } else if (account.equals("savings")){
            this.savingsBalance += amount;
        } else {
            System.out.println("Invalid account type.");
        }
        totalAmountOfMoney += amount;
    }

    public void withdrawMoney(double amount, String account){
        if (account.equals("checking")){
            if (this.checkingBalance >= amount){
                this.checkingBalance -= amount;
                totalAmountOfMoney -= amount;
            } else {
                System.out.println("Insufficient funds.");
            }
        } else if (account.equals("savings")){
            if (this.savingsBalance >= amount){
                this.savingsBalance -= amount;
                totalAmountOfMoney -= amount;
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid account type.");
        }
    }

    public void displayAccountBalance(){
        System.out.println("Checking Balance: " + this.checkingBalance);
        System.out.println("Savings Balance: " + this.savingsBalance);
        System.out.println("Total Balance: " + (this.checkingBalance + this.savingsBalance));
    }
}