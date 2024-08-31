package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC - Java DataBase Connection
 */

public class ConexionPostgreSQL {
    private Connection connection;

    public void crearConexion() {
        try {
            //Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "Alw@ys";
            connection = DriverManager.getConnection(url, user, password);

            boolean isValid = connection.isValid(5000);
            System.out.println(isValid ? "OK PostgreSQL" : "ERROR PostgreSQL");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
