import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer() {

        //create default constructor
        name = "Bob";
        accountNumber = 1234;
        checkBalance = 1000;
        savingBalance = 1000;

    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) {

        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;

    }

    //Requires: double, deposit amount. date, date of deposit. string, checking or saving account
    //Effects: returns the total amount in the account with the added deposit and adds a new deposit to the deposits array
    public double deposit(double amt, Date date, String account) {

        if (amt <= 0 || (!account.equals(CHECKING) && !account.equals(SAVING))) {

            return 0;

        }

        deposits.add(new Deposit(amt, date, account));

        //your code here
        if (account.equals(CHECKING)) {

            checkBalance += amt;
            return checkBalance;

        }

        else {

            savingBalance += amt;
            return savingBalance;

        }

    }

    //Requires: double, amount. date, date of deposit. account, checking or saving account
    //Effects: returns the total amount left after the withdrawal, adds a new withdraw to the withdraws array
    public double withdraw(double amt, Date date, String account) {

        //your code here
        if (amt <= 0 || checkOverdraft(amt, account) || (!account.equals(CHECKING) && !account.equals(SAVING))) {

            return -100;

        }

        withdraws.add(new Withdraw(amt, date, account));

        if (account.equals(CHECKING)) {

            checkBalance -= amt;
            return checkBalance;

        }

        else {

            savingBalance -= amt;
            return savingBalance;

        }

    }

    //Requires: double, amount. account, checking or saving account
    //Effects: returns true if the account is past over draft, else returns false
    private boolean checkOverdraft(double amt, String account) {

        //your code here
        if (account.equals(CHECKING)) {

            return checkBalance - amt <  OVERDRAFT;

        }

        else if (account.equals(SAVING)) {

            return savingBalance - amt < OVERDRAFT;

        }

        else {

            return false;

        }

    }

    //do not modify
    public void displayDeposits() {

        for (Deposit d : deposits) {

            System.out.println(d);

        }

    }

    //do not modify
    public void displayWithdraws() {

        for (Withdraw w : withdraws) {

            System.out.println(w);

        }

    }

}
