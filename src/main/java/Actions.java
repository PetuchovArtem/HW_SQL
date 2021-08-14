import java.sql.*;

public class Actions {

    static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static final String LOGIN = "postgres";
    static final String PASS = "1234";

    public void Registred(int userIdSet, String nameSet, String addressSet) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }

        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {
            try {
                String sql = "INSERT INTO users(userid,name,address) VALUES (" + userIdSet + " , " + "\'" + nameSet + "\'" + " , " + "\'" + addressSet + "\'" + ")";
                statement.executeUpdate(sql);
                System.out.println("Пользовтаель создан");
            } catch (Exception e) {
                System.out.println("Ошибка создания пользователя,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void AddAccount(int AccountIdSet, int userIdSet, int balanceSet, String currencySet) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }

        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {
            try {
                String sql = "INSERT INTO accounts(accountid, userid, balance, currency) VALUES (" + AccountIdSet + " , " + userIdSet + " , " + balanceSet + " , " + "\'" + currencySet + "\'" + ")";
                statement.executeUpdate(sql);
                System.out.println("Аккаунт для пользователя id=" + userIdSet + " создан");
            } catch (Exception e) {
                System.out.println("Ошибка создания аккаунта,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ReplenishmentAccount(int AccountIdSet, int userIdSet, int balanceSet, String currencySet) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }

        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {
            try {
                String sql = "INSERT INTO accounts(accountid, userid, balance, currency) VALUES (" + AccountIdSet + " , " + userIdSet + " , " + balanceSet + " , " + "\'" + currencySet + "\'" + ")";
                statement.executeUpdate(sql);
                System.out.println("Аккаунт для пользователя id=" + userIdSet + " создан");
            } catch (Exception e) {
                System.out.println("Ошибка создания аккаунта,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
