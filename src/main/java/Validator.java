import java.sql.*;
import java.util.ArrayList;

public class Validator {

    static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static final String LOGIN = "postgres";
    static final String PASS = "1234";


    public boolean validateAccount(String account, int id){
        boolean result = false;
        ArrayList<String> values = new ArrayList<String>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oshibka drivera");
        }
        try (Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
             Statement statement = connect.createStatement();) {

            String sql = "SELECT currency FROM accounts WHERE userid=" + id;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                values.add(String.valueOf(rs.getString("currency")));
            }
            if (values.contains(account)){
                result=true;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }


    public boolean validateBalance(double summa, int accountIdSet){

        boolean result = true;
        double checkBalance=0;

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
                    checkBalance= request2.getDouble("BALANCE");
                }
            } catch (Exception e) {
                System.out.println("Ошибка валидации балланса аккаунта,проверьте правильность данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (checkBalance+summa>2_000_000_000 || checkBalance+summa<0){
            result = false;
        }
        return result;
    }



    public boolean validatePlatezh(int summa){
        boolean result = true;
        if (summa > 100_000_000){
            result =false;
            return result;
        }
        else{
            return result;
        }


    }

}
