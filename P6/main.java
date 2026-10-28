class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    static int totalAccounts = 0;
    static final String BANK = "National Bank";
    final String accNo;
    double balance;

    public BankAccount(String accNo, double balance) throws InvalidAmountException {
        if (balance < 0) throw new InvalidAmountException("Negative balance not allowed.");
        this.accNo = accNo;
        this.balance = balance;
        totalAccounts++;
    }

    public static void showBank() {
        System.out.println(BANK + " | Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit must be positive.");
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal must be positive.");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds.");
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public final void showDetails() {
        System.out.println("Acc: " + accNo + " | Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount.showBank();

        try {
            BankAccount acc = new BankAccount("A101", 500);
            acc.showDetails();
            acc.deposit(200);
            acc.withdraw(100);
            acc.withdraw(1000); // Triggers exception
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}

