package org.example.comunicacionRed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEcho {
    public static void main(String[] args) throws IOException {
        final int PUERTO = 12345;

        try(ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor en espera de conexiones en el puerto: " + PUERTO);

            while(true) {
                // Aceptar la conexión del cliente
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado desde: " + cliente.getInetAddress());
                leerEntrada(cliente);

            }
        }
    }


    public static void leerEntrada(Socket socket) {
        // Usamos try-with-resources para manejar BufferedReader y PrintWriter
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            String mensaje;

            while((mensaje = entrada.readLine()) != null) {
                if (mensaje.isEmpty()) {
                    System.out.println("El cliente ha cerrado la sesión.");
                    break;
                }

               System.out.println("El cliente " + socket.getInetAddress() + "ha enviado:\n");
                System.out.println(mensaje);
                salida.println("Mensaje recibido correctamente");
            }

            socket.close();
            System.out.println("Conexión con el cliente cerrada");

        } catch (IOException e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al leer/escribir en el socket", e);
        }
    }

}
