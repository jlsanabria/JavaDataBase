package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC - Java DataBase Connection
 */

public class ConexionMariaDB {
    private Connection connection;

    public void crearConexion() {
        try {
            //Class.forName("org.postgresql.Driver");
            String url = "jdbc:mariadb://localhost:3306/db";
            String user = "root";
            String password = "Alw@ys";
            connection = DriverManager.getConnection(url, user, password);

            boolean isValid = connection.isValid(5000);
            System.out.println(isValid ? "OK MariaDB" : "ERROR MariaDB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
