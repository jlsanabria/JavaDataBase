package model;

/**
 * Clase POJO (Plain Old Java Object)
 */
public class Libro {
    private String codigoLibro;
    private String titulo;
    private Integer numeroPaginas;

    // Constructor
    public Libro() {

    }

    public Libro(String codigoLibro, String titulo, Integer numeroPaginas) {
        this.codigoLibro = codigoLibro;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    // Getters & Setters
    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "codigoLibro='" + codigoLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}
