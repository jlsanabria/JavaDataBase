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
    public Libro updateLibro(String codLibro, Libro libro);
    // DELETE
    public boolean deleteLibro(String codLibro);
}
