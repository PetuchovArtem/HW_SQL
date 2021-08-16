import javax.sql.rowset.JdbcRowSet;
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

    public void ReplenishmentAccount(int TransactionIdSet, int accountIdSet, int amountSet) {
        int newBalance = 0;
        int currentBalance = 0;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }

        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {
            try {
            String sql = "INSERT INTO transactions (transactinid, accountid, amount) VALUES (" + TransactionIdSet + " , " + accountIdSet + " , " + amountSet + ")";
            statement.executeUpdate(sql);
            String sql2 = "SELECT balance FROM accounts WHERE accountid =" + accountIdSet;
            ResultSet rs = statement.executeQuery(sql2);

            while (rs.next()) {
                currentBalance = Integer.parseInt(
                        String.valueOf(rs.getInt("balance")));
            }

            newBalance = currentBalance + amountSet;
            String sql3 = "UPDATE accounts SET balance =" + newBalance + " WHERE accountid=" + accountIdSet;
            statement.executeUpdate(sql3);
            System.out.println("Аккаунт пополнен на "+amountSet);

            } catch (Exception e) {
                System.out.println("Ошибка пополнения аккаунта,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void getAccountBalance(int accountIdSet) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }

        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {
            try {
                String sql = "SELECT AVG(balance) AS BALANCE FROM accounts WHERE accountid=" + accountIdSet;
                ResultSet request2 = statement.executeQuery(sql);

                while (request2.next()) {
                    System.out.println("Балланс аккаунта " + request2.getDouble("BALANCE"));
                }
            } catch (Exception e) {
                System.out.println("Ошибка получения балланса аккаунта,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
