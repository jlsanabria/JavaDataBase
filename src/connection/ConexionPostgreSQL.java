package connection;

import java.sql.*;

/**
 * JDBC - Java DataBase Connection
 */

public class ConexionPostgreSQL {
    private Connection connection;

    public Connection crearConexion() {
        try {
            //Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/libreriadb";
            String user = "libreria";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);

            boolean isValid = connection.isValid(5000);
            System.out.println(isValid ? "OK PostgreSQL" : "ERROR PostgreSQL");

            Statement statement = connection.createStatement();
            String query = "SELECT version();"; // SQL --> Structure Query Language
            ResultSet resultSet = statement.executeQuery(query); // ResultSet - permite obtener o gestionar respuesta de la DB
            if(resultSet.next()) {
                String version = resultSet.getString(1);
                System.out.println(version);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
