import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Actions actions = new Actions();
        System.out.println("Создание клиента");
        actions.Registred(1, "Artiom", "Minsk");
        System.out.println("-----------------");
        System.out.println("Создание аккаунта");
        actions.AddAccount(1, 1, 10000, "BYN");
        System.out.println("-----------------");
        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(1);
        System.out.println("-----------------");
        System.out.println("Пополнение аккаунта");
        actions.ReplenishmentAccount(1,1,1000);
        System.out.println("-----------------");
        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(1);
    }
}
