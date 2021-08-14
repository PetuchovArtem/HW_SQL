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

            String sql = "INSERT INTO users(userid,name,address) VALUES (" +  userIdSet  + " , " + "\'" + nameSet + "\'" + " , " + "\'" + addressSet + "\'" + ")";

            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
