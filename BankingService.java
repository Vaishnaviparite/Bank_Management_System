package bankingsystem;

import java.util.List;

public interface BankingService {
    void addCustomer(Customer customer);

    void addAccount(Account account);

    void deposit(int accountID, double amount);

    void withdraw(int accountID, double amount);

    void transfer(int fromAccountID, int toAccountID, double amount);

    void addBeneficiary(Beneficiary beneficiary);

    List<Account> getAccountsByCustomerId(int customerId);

    List<Transaction> getTransactionsByAccountId(int accountId);
}
