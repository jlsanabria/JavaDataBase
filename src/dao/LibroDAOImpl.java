package dao;

import connection.ConexionPostgreSQL;
import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Arquitectura MVC (Model - View- Controller)
 * Model (DAO, Repository) <->  Controlador (Bean, Services, Components) <-> Vista (MBean, REST, DTO-presentacion)
 */
public class LibroDAOImpl implements LibroDAO {
    private ConexionPostgreSQL conPostgreSQL;
    // Objeto connection para realizar las operaciones CRUD con la misma conexión
    private Connection connection;

    public LibroDAOImpl() {
        conPostgreSQL = new ConexionPostgreSQL();
        connection = conPostgreSQL.crearConexion();
    }

    @Override
    public boolean createLibro(Libro libro) {
        try {
            Statement statement = connection.createStatement();
            String queryInsert = "INSERT INTO libro(codigo_libro, titulo, numero_paginas) " +
                    "VALUES ('" + libro.getCodigoLibro() + "', '"+ libro.getTitulo() + "', "+ libro.getNumeroPaginas() + ");";
            statement.executeUpdate(queryInsert);
            System.out.println("Libro registrado exitósamente :)");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el libro :(");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Libro> readLibros() {
        return List.of();
    }

    @Override
    public boolean updateLibro(Libro libro) {
        return false;
    }

    @Override
    public Libro deleteLibro(int id) {
        return null;
    }
}
