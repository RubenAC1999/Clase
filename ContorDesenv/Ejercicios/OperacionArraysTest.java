package Ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperacionArraysTest {

    @Test
    void test1() {
        OperacionArrays instancia = new OperacionArrays();
        char c = 'c';
        char[] v = {'a', 'b', 'c'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(true, resultado);
    }

    @Test
    void test2() {
        OperacionArrays instancia = new OperacionArrays();
        char c = 'd';
        char[] v = {'a', 'b', 'c'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(false, resultado);
    }

    @Test
    void test3() {
        OperacionArrays instancia = new OperacionArrays();
        char c = (byte) 97;
        char[] v = {'a', 'b', 'c'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(true, resultado);
    }

    @Test
    void test4() {
        OperacionArrays instancia = new OperacionArrays();
        char c = 'c';
        char[] v = {};
        boolean resultado = instancia.busca(c, v);
        assertEquals(false, resultado);
    }

    @Test
    void test5() {
        OperacionArrays instancia = new OperacionArrays();
        char c = 'c';
        char[] v = {'d', 'c', 'b','a', 'b', 'c','a', 'b', 'c','a','b'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(true, resultado);
    }

    @Test
    void test6() {              // No detecta mayus
        OperacionArrays instancia = new OperacionArrays();
        char c = 'C';
        char[] v = {'d', 'c', 'b','a', 'b', 'c','a', 'b', 'c','a','b'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(true, resultado);
    }

    @Test
    void test7() {      // Lista en orden descedente
        OperacionArrays instancia = new OperacionArrays();
        char c = 'a';
        char[] v = {'j', 'i', 'h','g', 'f', 'e','d', 'b', 'c','a'};
        boolean resultado = instancia.busca(c, v);
        assertEquals(false, resultado);
    }



}