import java.util.Scanner;

public class ATM {

    //Initializes instance variables
    private Scanner in; 
    private BankAccount activeAccount; 

    //Gives value to switch statement on l. 35
    public static final int VIEW = 1;
    public static final int DEPOSIT = 2;
    public static final int WITHDRAW = 3;
    public static final int LOGOUT = 4;

    public ATM() {
        in = new Scanner(System.in); //Activates scanner

        activeAccount = new BankAccount(1234, 123456789, 0, new User("Ryan", "Wilson")); //Test account
    }

    public void startup() {
        System.out.println("Welcome to the AIT ATM!\n"); //Friendly greeting
        
        //Login loop
        while (true) {
            //Prompts user for information
            System.out.print("Account No.: ");
            long accountNo = in.nextLong();
            
            System.out.print("PIN        : ");
            int pin = in.nextInt();
            
            if (isValidLogin(accountNo, pin)) {
                //Valid
                System.out.println("\nHello, again, " + activeAccount.getAccountHolder().getFirstName() + "!\n");
                
                //Selection loop
                boolean validLogin = true;
                while (validLogin) {
                    //User selects desired action
                    switch (getSelection()) {
                        case VIEW: showBalance(); break;
                        case DEPOSIT: deposit(); break;
                        case WITHDRAW: withdraw(); break;
                        case LOGOUT: validLogin = false; break;
                        default: System.out.println("\nInvalid selection.\n"); break;
                    }
                }
            } else { 
                //Shutdown / invalid
                if (accountNo == -1 && pin == -1) {
                    shutdown();
                } else {
                    System.out.println("\nInvalid account number and/or PIN.\n");
                }
            }
        }
    }

    public boolean isValidLogin(long accountNo, int pin) {
        return accountNo == activeAccount.getAccountNo() && pin == activeAccount.getPin();
    }
    
    public int getSelection() {
        System.out.println("[1] View balance");
        System.out.println("[2] Deposit money");
        System.out.println("[3] Withdraw money");
        System.out.println("[4] Logout");
        
        return in.nextInt();
    }
    
    //Switch statement cases
    public void showBalance() { 
        System.out.println("\nCurrent balance: " + activeAccount.getBalance());
    }
    
    public void deposit() { 
        System.out.print("\nEnter amount: ");
        double amount = in.nextDouble();
        
        activeAccount.deposit(amount);
        System.out.println();
    }
    
    public void withdraw() { 
        System.out.print("\nEnter amount: ");
        double amount = in.nextDouble();
        
        activeAccount.withdraw(amount);
        System.out.println();
    }

    public void shutdown() {
        if (in != null) {
            in.close();
        }
        
        System.out.println("\nGoodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        
        atm.startup();
    }
}