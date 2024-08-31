import connection.ConexionPostgreSQL;

public class MainPostgreSQL {
    public static void main(String[] args) {
        ConexionPostgreSQL conPG = new ConexionPostgreSQL();
        conPG.crearConexion();
    }
}
