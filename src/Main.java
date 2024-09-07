import dao.LibroDAO;
import dao.LibroDAOImpl;
import model.Libro;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Libro miLibro = new Libro("L-1004", "Homo Sapiens", 599);
        // Crear libro
        //libroDAO.createLibro(miLibro);
        // Leer libro(s)

//        for(Libro libro: libroDAO.readLibros()) {
//            System.out.println(libro);
//        }

        libroDAO.readLibros().forEach(System.out::println);

        // Actualizar libro
        Libro libroPorActualizar = new Libro("", "Un mundo feliz", 708);
        Libro libroActualizado = libroDAO.updateLibro("L-1003", libroPorActualizar);

        System.out.println("--> 1. Listar libros actualizados");
        libroDAO.readLibros().forEach(System.out::println);

        // Eliminar libro
        libroDAO.deleteLibro("L-1004");

        System.out.println("--> 2. Listar libros actualizados");
        libroDAO.readLibros().forEach(System.out::println);
    }
}