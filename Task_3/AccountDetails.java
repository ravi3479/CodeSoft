package Task_3;
import java.util.Scanner;
public interface AccountDetails {
        boolean deposit(double amount);
        boolean withdraw(double amount);
        double getBalance();
    }

    class BankAccount implements AccountDetails {
        private double balance;

        public BankAccount(double PreviousBalance) {
            this.balance = PreviousBalance;
        }

        @Override
        public double getBalance() {
            return balance;
        }

        @Override
        public boolean deposit(double amountDeposited) {
            if (amountDeposited>0) {
                   balance = balance + amountDeposited;
                   return true;
            }
            return false;
        }

        @Override
        public boolean withdraw(double amountWithdrawn) {
                if (amountWithdrawn>0 && amountWithdrawn<=balance) {
                balance = balance - amountWithdrawn;
                    return true;
            }
            return false;
        }
    }

    class ATMApp {
        private AccountDetails account;

            public ATMApp(AccountDetails account) {
            this.account= account;
        }

        public void displayMenu() {
               Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("..........................");
                System.out.println("        ATM Menu");
                System.out.println("..........................");
                System.out.println("1. Withdraw Cash");
                System.out.println("2. Deposit Cash");
                System.out.println("3. Balance Check");
                System.out.println("4. Exit");
                System.out.println("..........................");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        withdraw(sc);
                        break;
                    case 2:
                        deposit(sc);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private void withdraw(Scanner sc) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Please collect your cash.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        private void deposit(Scanner sc) {
            System.out.print("Enter amount to deposit: ");
                 double amount = sc.nextDouble();
            if (account.deposit(amount)) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        private void checkBalance() {
               System.out.println("Your current balance = " + account.getBalance());
        }

    }
    class Main {
        public static void main(String[] args) {
            BankAccount account = new BankAccount(10000.00);
            ATMApp atm = new ATMApp(account);
            atm.displayMenu();
        }
    }

