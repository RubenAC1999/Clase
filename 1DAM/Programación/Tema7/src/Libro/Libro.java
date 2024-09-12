package Libro;

import java.util.regex.*;
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;

    public Libro(String ISBN, String titulo, String autor, int numPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public boolean comprobacionISBN() {
        Pattern patron = Pattern.compile("^ISBN\\s\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d{1}$");
        Matcher match = patron.matcher(getISBN());

        if(match.find()) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPaginas=" + numPaginas +
                '}';
    }
}
