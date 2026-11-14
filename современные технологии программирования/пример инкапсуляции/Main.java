package bank;

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("Александр", 10000);

        System.out.println("--- Информация о счёте ---");
        account.showInfo();

        System.out.println("\n--- Пополнение ---");
        account.deposit(5000);

        System.out.println("\n--- Снятие денег ---");
        account.withdraw(3000);

        System.out.println("\n--- Попытка снятия ---");
        account.withdraw(20000);

        System.out.println("\n--- Итоговый баланс ---");
        System.out.println(account.getBalance());
    }
}