public class BankAccount {

    //Initializes instance variables
    private int pin;
    private long accountNo;
    private double balance;
    private User accountHolder;

    //Constructor, creates instances of class
    public BankAccount(int pin, long accountNo, double balance, User accountHolder) {
        this.pin = pin;
        this.accountNo = accountNo;
        this.balance = balance;
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
        return balance; //Solves "view balance" action
    }
    
    public User getAccountHolder() {
        return accountHolder;
    }

    //Solves "deposit / withdraw cash" action

    public void deposit(double amount) {
        balance = balance + amount;
    }
    
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    
}