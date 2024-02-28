package Ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void test1() throws Exception {
        byte n = 0;
        Factorial numero = new Factorial();
        float resultado = numero.factorial(n);
        assertEquals(1, resultado);
    }

    @Test
    void test2()  throws Exception {
        byte n = 3;
        Factorial numero = new Factorial();
        float resultado = numero.factorial(n);
        assertEquals(6, resultado);
    }

    @Test
    void test3() throws Exception {
        byte n = (byte) 128;
        Factorial numero = new Factorial();
        float resultado = numero.factorial(n);
        assertEquals(3.856205e+215, resultado);
    }

    // Lo pasa a código ASCII ('a' = 97)

    @Test
    void test4() throws Exception {
        byte n = -5;
        Factorial numero = new Factorial();
        float resultado = numero.factorial(n);
        assertEquals(resultado, resultado);
    }

    @Test
    void test5() throws Exception {
        byte n = (byte) 'a';
        Factorial numero = new Factorial();
        float resultado = numero.factorial(n);
        assertEquals(resultado, resultado);
    }
}