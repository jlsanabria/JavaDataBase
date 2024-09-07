package connection;

import java.sql.*;

/**
 * JDBC - Java DataBase Connection
 */

public class ConexionMariaDB {
    private Connection connection;

    public void crearConexion() {
        try {
            //Class.forName("org.postgresql.Driver");
            String url = "jdbc:mariadb://localhost:3306/mysql";
            String user = "root";
            String password = "Alw@ys";
            connection = DriverManager.getConnection(url, user, password);

            boolean isValid = connection.isValid(5000);
            System.out.println(isValid ? "OK MariaDB" : "ERROR MariaDB");

            Statement statement = connection.createStatement();
            String query = "SELECT version();"; // SQL --> Structure Query Language
            ResultSet resultSet = statement.executeQuery(query); // ResultSet - permite obtener o gestionar respuesta de la DB
            if(resultSet.next()) {
                String version = resultSet.getString(1);
                System.out.println(version);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
