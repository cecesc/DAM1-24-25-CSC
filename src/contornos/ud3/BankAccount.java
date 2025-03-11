package contornos.ud3;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        //balance -= amount;
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

}
// Correxir: sumar en vez de restar