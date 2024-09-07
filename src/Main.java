import dao.LibroDAO;
import dao.LibroDAOImpl;
import model.Libro;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Libro miLibro = new Libro("L-1002", "Bovedas de Acero", 410);
        libroDAO.createLibro(miLibro);
    }
}