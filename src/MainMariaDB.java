import connection.ConexionMariaDB;
import connection.ConexionPostgreSQL;

public class MainMariaDB {
    public static void main(String[] args) {
        ConexionMariaDB conMariaDB = new ConexionMariaDB();
        conMariaDB.crearConexion();
    }
}
