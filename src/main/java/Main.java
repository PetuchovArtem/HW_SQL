import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int platezh = 0;
        int idPlatezha=13; //после кажого прогона пока что прибавляем+2
        Scanner sc = new Scanner(System.in);

        Actions actions = new Actions();
        System.out.println("Создание клиента");
//        actions.Registred(3, "Artiom", "Minsk");
        System.out.println("-----------------");


        System.out.println("Создание аккаунта");
//        actions.AddAccount(4, 3, 20000, "BYN");
        System.out.println("-----------------");


        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(4);
        System.out.println("-----------------");


        System.out.println("Пополнение аккаунта");
        System.out.println("Введите сумму пополнения");
        platezh = sc.nextInt();

        while (platezh > 100_000_000) {
            System.out.println("Сумма пополнения не может быть > 100_000_000");
            System.out.println("Введите сумму пополнения");
            platezh = sc.nextInt();
        }
        actions.ReplenishmentAccount(idPlatezha, 4, platezh);
        ++idPlatezha;

        System.out.println("-----------------");
        System.out.println("Снятие с аккаунта");
        System.out.println("Введите сумму снятия");
        platezh = sc.nextInt();

        while (platezh > 100_000_000) {
            System.out.println("Сумма снятия не может быть > 100_000_000");
            System.out.println("Введите сумму снятия");
            platezh = sc.nextInt();
        }
        platezh = -1* platezh;

        actions.ReplenishmentAccount(idPlatezha, 4, platezh);

        System.out.println("-----------------");
        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(4);
    }
}
