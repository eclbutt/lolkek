package bank;

public class BankAccount {

    // Закрытые поля
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Получение баланса
    public double getBalance() {
        return balance;
    }

    // Пополнение счёта
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен на " + amount);
        } else {
            System.out.println("Некорректная сумма!");
        }
    }

    // Снятие денег
    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снято: " + amount);
        } else {
            System.out.println("Недостаточно средств или неверная сумма!");
        }
    }

    public void showInfo() {
        System.out.println("Владелец: " + owner);
        System.out.println("Баланс: " + balance);
    }
}