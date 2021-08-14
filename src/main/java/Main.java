import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Actions actions = new Actions();
        System.out.println("Создание клиента");
        actions.Registred(2, "Alena", "Minsk");
        System.out.println("-----------------");
        System.out.println("Создание аккаунта");
        actions.AddAccount(1, 2, 10000, "BYN");

    }
}
