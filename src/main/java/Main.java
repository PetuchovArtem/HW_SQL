import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int platezh = 0;
        String valuta = "";

        int idPlatezha=13; //после кажого прогона пока что прибавляем+2
        Scanner sc = new Scanner(System.in);

        Actions actions = new Actions();
        Validator validator = new Validator();
//        System.out.println("Создание клиента");
//        actions.Registred(3, "Artiom", "Minsk");
//        System.out.println("-----------------");

        System.out.println("Создание аккаунта");
        System.out.println("---");
        System.out.println("Введите Валюту аккаунта, доступные валюты: BYN, USD, EUR");
        valuta = sc.nextLine();
        System.out.println("---");
        System.out.println("Валидация наличия аккаунта");
        if(validator.validateAccount(valuta, 3)){
            while (validator.validateAccount(valuta, 3) == false){
                System.out.println("Аккаунт в такой валюте существует");
                System.out.println("Введите Валюту аккаунта, доступные валюты: BYN, USD, EUR");
                valuta = sc.nextLine();
            }

        } else{
            actions.AddAccount(4, 3, 20000, valuta);
            System.out.println("-----------------");
        }

//        System.out.println("Балланс аккаунта");
//        actions.getAccountBalance(4);
        System.out.println("-----------------");


        System.out.println("Пополнение аккаунта");
        System.out.println("Введите сумму пополнения");
        platezh = sc.nextInt();

        if (validator.validatePlatezh(platezh)==false){
            while (validator.validatePlatezh(platezh)==false) {
                System.out.println("Сумма пополнения не может быть > 100_000_000");
                System.out.println("Введите сумму пополнения");
                platezh = sc.nextInt();
            }
        }

        actions.ReplenishmentAccount(idPlatezha, 4, platezh);
        ++idPlatezha;

        System.out.println("-----------------");
//        System.out.println("Снятие с аккаунта");
//        System.out.println("Введите сумму снятия");
//        platezh = sc.nextInt();
//
//        while (platezh > 100_000_000) {
//            System.out.println("Сумма снятия не может быть > 100_000_000");
//            System.out.println("Введите сумму снятия");
//            platezh = sc.nextInt();
//        }
//        platezh = -1* platezh;
//
//        actions.ReplenishmentAccount(idPlatezha, 4, platezh);
//
//        System.out.println("-----------------");
//        System.out.println("Балланс аккаунта");
//        actions.getAccountBalance(4);
    }
}
