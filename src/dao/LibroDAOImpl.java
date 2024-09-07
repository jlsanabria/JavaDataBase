package dao;

import connection.ConexionMariaDB;
import connection.ConexionPostgreSQL;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Arquitectura MVC (Model - View- Controller)
 * Model (DAO, Repository) <->  Controlador (Bean, Services, Components) <-> Vista (MBean, REST, DTO-presentacion)
 */
public class LibroDAOImpl implements LibroDAO {
    private ConexionPostgreSQL conPostgreSQL;
    private ConexionMariaDB conMariaDB;
    // Objeto connection para realizar las operaciones CRUD con la misma conexión
    private Connection connection;

    public LibroDAOImpl() {
        conPostgreSQL = new ConexionPostgreSQL();
        connection = conPostgreSQL.crearConexion();
//        conMariaDB = new ConexionMariaDB();
//        connection = conMariaDB.crearConexion();
    }

    @Override
    public boolean createLibro(Libro libro) {
        try {
            //Statement statement = connection.createStatement();

//            String queryInsert = "INSERT INTO libro(codigo_libro, titulo, numero_paginas) " +
//                    "VALUES ('" + libro.getCodigoLibro() + "', '"+ libro.getTitulo() + "', "+ libro.getNumeroPaginas() + ");";
//            String queryInsert = String.format("INSERT INTO %s(codigo_libro, titulo, numero_paginas) " +
//                    "VALUES ('%s', '%s', '%s');", "libro", libro.getCodigoLibro(), libro.getTitulo(), libro.getNumeroPaginas());


            String queryInsert = "INSERT INTO libro(codigo_libro, titulo, numero_paginas) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
            preparedStatement.setString(1, libro.getCodigoLibro());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setInt(3, libro.getNumeroPaginas());
            preparedStatement.executeUpdate();

            //statement.executeUpdate(queryInsert);

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
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Libro regLibro = new Libro();
                regLibro.setCodigoLibro(resultSet.getString("codigo_libro"));
                regLibro.setTitulo(resultSet.getString("titulo"));
                regLibro.setNumeroPaginas(resultSet.getInt("numero_paginas"));
                libros.add(regLibro);
            }
            return libros;
        } catch (SQLException e) {
            System.out.println("No se pudo recuperar libros de la base de datos :(");
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Libro updateLibro(String codlibro, Libro libro) {
        String queryUpdate = "UPDATE libro SET titulo = ?, numero_paginas = ? WHERE codigo_libro = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setInt(2, libro.getNumeroPaginas());
            preparedStatement.setString(3, codlibro);
            preparedStatement.executeUpdate();
            System.out.println("Libro actualizado exitósamente");
            return libro;
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el libro :(");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteLibro(String codLibro) {
        String queryDelete = "DELETE FROM libro WHERE codigo_libro = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setString(1, codLibro);
            preparedStatement.executeUpdate();
            System.out.println("Libro eliminado de la BD");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el libro :(");
            e.printStackTrace();
            return false;
        }
    }
}
