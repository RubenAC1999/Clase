package Libro;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("ISBN 978-84-94687-11-5", "Titulo de ejemplo", "Rubén Agra",
                100);
        Libro libro2 = new Libro("ISBN 978-84-94677-20-2", "Otro titulo de ejemplo", "Paco González",
                200);

        String libroMasPags = (libro1.getNumPaginas() > libro2.getNumPaginas()) ? libro1.getTitulo() + " Tiene más páginas (" +
        libro1.getNumPaginas() + ")" : libro2.getTitulo() + " Tiene más páginas (" + libro2.getNumPaginas() + ")";

        System.out.println(libroMasPags);
    }
}
