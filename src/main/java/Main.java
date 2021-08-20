import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int platezh = 0;
        String valuta = "";

        int idPlatezha=16; //после кажого прогона пока что прибавляем+2
        Scanner sc = new Scanner(System.in);

        Actions actions = new Actions();
        Validator validator = new Validator();
        System.out.println("Создание клиента");
        actions.Registred(5, "Artiom2", "Minsk");
        System.out.println("-----------------");

        System.out.println("Создание аккаунта");
        System.out.println("---");
        System.out.println("Введите Валюту аккаунта, доступные валюты: BYN, USD, EUR");
        valuta = sc.nextLine();
        System.out.println("---");
        System.out.println("Валидация наличия аккаунта");
        if(validator.validateAccount(valuta, 5)){
            while (validator.validateAccount(valuta, 5) == false){
                System.out.println("Аккаунт в такой валюте существует");
                System.out.println("Введите Валюту аккаунта, доступные валюты: BYN, USD, EUR");
                valuta = sc.nextLine();
            }

        } else{
            actions.AddAccount(6, 5, 0, valuta);
            System.out.println("-----------------");
        }

        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(6);
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
        if (validator.validateBalance(platezh, 6)==false){
            while (validator.validateBalance(platezh, 6)==false) {
                System.out.println("Баланс аккаунта не может быть > 2_000_000_000");
                System.out.println("Введите сумму пополнения");
                platezh = sc.nextInt();
            }
        }

        actions.ReplenishmentAccount(idPlatezha, 6, platezh);
        ++idPlatezha;

        System.out.println("-----------------");
        System.out.println("Снятие с аккаунта");
        System.out.println("Введите сумму снятия");
        platezh = sc.nextInt();

        if (validator.validatePlatezh(platezh)==false){
            while (validator.validatePlatezh(platezh)==false) {
                System.out.println("Сумма пополнения не может быть отрицательный");
                System.out.println("Введите сумму снятия");
                platezh = sc.nextInt();
            }
        }
        if (validator.validateBalance(platezh, 5)==false){
            while (validator.validateBalance(platezh, 5)==false) {
                System.out.println("Баланс аккаунта не может быть отрицательный");
                System.out.println("Введите сумму снятия");
                platezh = sc.nextInt();
            }
        }
        platezh= -1*platezh;

        actions.ReplenishmentAccount(idPlatezha, 6, platezh);
        ++idPlatezha;

        System.out.println("-----------------");
        System.out.println("Балланс аккаунта");
        actions.getAccountBalance(6);
    }
}
