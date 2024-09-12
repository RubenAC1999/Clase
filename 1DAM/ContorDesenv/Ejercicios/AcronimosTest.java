package Ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcronimosTest {

    @Test
    void test1() {
        Acronimos instancia = new Acronimos();
        String cadena = "Ana Rodriguez";
        String resultado = instancia.obtenerAcronimo(cadena);
        assertEquals("A.R.", resultado);
    }

    @Test
    void test2() {
        Acronimos instancia = new Acronimos();
        String cadena = "AnaRodriguez";
        String resultado = instancia.obtenerAcronimo(cadena);
        assertEquals("A.", resultado);
    }

    @Test
    void test3() {
        Acronimos instancia = new Acronimos();
        String cadena = "";
        String resultado = instancia.obtenerAcronimo(cadena);
        assertEquals("", resultado);
    }

    @Test
    void test4() {   // No detecta saltos de línea.
        Acronimos instancia = new Acronimos();
        String cadena = "Ana\nRodriguez";
        String resultado = instancia.obtenerAcronimo(cadena);
        assertEquals("A.R.", resultado);
    }


}