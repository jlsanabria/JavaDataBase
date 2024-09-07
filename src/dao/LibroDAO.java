package dao;

import model.Libro;

import java.util.List;

/**
 * DAO - Data Access Object
 */
public interface LibroDAO {
    // CREATE
    public boolean createLibro(Libro libro);
    // READ
    public List<Libro> readLibros();
    // UPDATE
    public boolean updateLibro(Libro libro);
    // DELETE
    public Libro deleteLibro(int id);
}
