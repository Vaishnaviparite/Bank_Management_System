package bankingsystem;

public class Account {
    private int accountID;
    private int customerID;
    private double balance;
    private String type;

    public Account(int accountId, int customerId, double balance, String type) {
        this.accountID = accountId;
        this.customerID = customerId;
        this.balance = balance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Account(int i, int customerId2, String type, double balance2) {

    }

    public int getAccountID() {
        return accountID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", customerID=" + customerID +
                ", balance=" + balance +
                '}';
    }

}
