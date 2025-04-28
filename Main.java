package bankingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingService service = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Add Beneficiary");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Address: ");
                    String address = scanner.next();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.next();
                    service.addCustomer(new Customer(0, name, address, contact));
                    break;
                case 2:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    service.addAccount(new Account(0, customerId, type, balance));
                    break;
                case 3:
                    System.out.print("Enter Account ID: ");
                    int accID = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double depositAmount = scanner.nextDouble();
                    service.deposit(accID, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter Account ID: ");
                    int accWithdrawID = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    service.withdraw(accWithdrawID, withdrawAmount);
                    break;
                case 5:
                    System.out.print("Enter From Account ID: ");
                    int fromID = scanner.nextInt();
                    System.out.print("Enter To Account ID: ");
                    int toID = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double transferAmount = scanner.nextDouble();
                    service.transfer(fromID, toID, transferAmount);
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    int benefID = scanner.nextInt();
                    System.out.print("Enter Beneficiary Name: ");
                    String benefName = scanner.next();
                    System.out.print("Enter Beneficiary Account Number: ");
                    String benefAcc = scanner.next();
                    System.out.print("Enter Bank Details: ");
                    String bank = scanner.next();
                    service.addBeneficiary(new Beneficiary(0, benefID, benefName, benefAcc, bank));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
