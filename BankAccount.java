import java.text.NumberFormat;

public class BankAccount {

    //Defines account number generation
    private static long prevAccountNo = 10000000L;

    //Initializes instance variables
    private int pin;
    private long accountNo;
    private User accountHolder;

    //Constructor, creates instances of class
    public BankAccount(int pin, long accountNo, double balance, User accountHolder) {
        this.pin = pin;
        this.accountNo = ++BankAccount.prevAccountNo;
        this.balance = 0.0;
        this.accountHolder = accountHolder;
    }

    //Getters to retrieve info from BankAccount class
    public int getPin() {
        return pin;
    }
    
    public long getAccountNo() {
        return accountNo;
    }
    
    public double getBalance() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
    
        return currency.format(balance); //Solves "view balance" action
    }
    
    public User getAccountHolder() {
        return accountHolder;
    }

    //Solves "deposit / withdraw cash" action

    public void deposit(double amount) {
        if (amount <= 0) {
            return ATM.INVALID;    
        } else {
            balance = balance + amount;
        }
            
        return ATM.SUCCESS;
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            return ATM.INVALID;
        } else if (amount > balance) {
            return ATM.INSUFFICIENT;
        } else {
            balance = balance - amount;
        }
        
        return ATM.SUCCESS;
    }

}