import java.util.Scanner;
class BankAccount {
  private double balance;

  public BankAccount(double initialBalance) {
      this.balance = initialBalance;
  }

  public double getBalance() {
      return balance;
  }

  public void deposit(double amount) {
      if (amount > 0) {
          balance += amount;
          System.out.println("Successfully deposited: $" + amount);
      } else {
          System.out.println("Deposit amount must be positive.");
      }
  }

  public void withdraw(double amount) {
      if (amount > balance) {
          System.out.println("Insufficient funds. Cannot withdraw: $" + amount);
      } else if (amount <= 0) {
          System.out.println("Withdrawal amount must be positive.");
      } else {
          balance -= amount;
          System.out.println("Successfully withdrew: $" + amount);
      }
  }

  public void checkBalance() {
      System.out.println("Your current balance is: $" + balance);
  }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}


public class ATMmain {
  public static void main(String[] args) {
    BankAccount myAccount = new BankAccount(1000.00);  // Create an account with $1000 initial balance
    ATM atm = new ATM(myAccount);  // Connect the ATM to the account
    atm.showMenu();  // Start the ATM operations
}
}
