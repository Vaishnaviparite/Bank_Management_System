package bankingsystem;

import java.sql.*;
import java.util.*;

public class BankingServiceImpl implements BankingService {

    @Override
    public void addCustomer(Customer customer) {
        String query = "INSERT INTO Customer (name, address, contact) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getAddress());
            pstmt.setString(3, customer.getContact());

            pstmt.executeUpdate();
            System.out.println("✅ Customer added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(Account account) {
        String query = "INSERT INTO Account (customerID, type, balance) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, account.getCustomerID());
            pstmt.setString(2, account.getType());
            pstmt.setDouble(3, account.getBalance());

            pstmt.executeUpdate();
            System.out.println("✅ Account created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int accountID, double amount) {
        String query = "UPDATE Account SET balance = balance + ? WHERE accountID = ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountID);

            pstmt.executeUpdate();
            System.out.println("💰 Deposit successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int accountID, double amount) {
        String query = "UPDATE Account SET balance = balance - ? WHERE accountID = ? AND balance >= ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountID);
            pstmt.setDouble(3, amount);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("💸 Withdrawal successful!");
            } else {
                System.out.println("⚠ Insufficient balance!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transfer(int fromAccountID, int toAccountID, double amount) {
        withdraw(fromAccountID, amount);
        deposit(toAccountID, amount);
        System.out.println("🔄 Transfer successful!");
    }

    @Override
    public void addBeneficiary(Beneficiary beneficiary) {
        String query = "INSERT INTO Beneficiary (customerID, name, accountNumber, bankDetails) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, beneficiary.getCustomerID());
            pstmt.setString(2, beneficiary.getName());
            pstmt.setString(3, beneficiary.getAccountNumber());
            pstmt.setString(4, beneficiary.getBankDetails());

            pstmt.executeUpdate();
            System.out.println("✅ Beneficiary added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountsByCustomerId'");
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactionsByAccountId'");
    }
}
