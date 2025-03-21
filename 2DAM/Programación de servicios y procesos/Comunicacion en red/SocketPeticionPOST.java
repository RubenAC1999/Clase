package org.example.comunicacionRed;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketPeticionPOST {
    // Definición de constantes
    private static final int TIMEOUT_CONECTION = 5000;
    private static final String METODO_HTTP = "POST";

    public static void main(String[] args) {
        String destino = "jsonplaceholder.typicode.com";
        int puertoDestino = 80;
        String ruta = "/users";

        String respuesta = enviarPeticion(destino, puertoDestino, ruta);
        System.out.println("Respuesta del sevidor\n--------------------------");
        System.out.println(respuesta);
    }


    public static String enviarPeticion(String destino, int puertoDestino, String ruta) {
        // Creamos un Socket
        try (Socket socket = new Socket()) {
            // Establecer conexión
            socket.connect(new InetSocketAddress(destino, puertoDestino), TIMEOUT_CONECTION);
            System.out.println("Conexión establecida con " + destino + ":" + puertoDestino);

            enviarSolicitudHTTP(socket, destino, ruta);

           return leerRespuestaHTTP(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void enviarSolicitudHTTP(Socket socket, String destino, String ruta) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            StringBuilder solicitud = new StringBuilder(METODO_HTTP);

            solicitud.append(" " + ruta)
                    .append(" HTTP/1.1\r\nHost: ")
                    .append(destino + "\r\n")
                    .append("Connection: close\r\n\r\n");

            outputStream.write(solicitud.toString().getBytes());
            outputStream.flush();
            System.out.println("Solicitud enviada al servidor");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String leerRespuestaHTTP(Socket socket) {
        // Obtenemos flujo de entrada para leer los datos
        try(InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder respuesta = new StringBuilder();
            String linea;

            while((linea = bufferedReader.readLine()) != null) {
                respuesta.append(linea).append("\n");
            }

            return respuesta.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
