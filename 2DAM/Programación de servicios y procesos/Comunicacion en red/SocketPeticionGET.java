package org.example.comunicacionRed;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketPeticionGET {

    // Constantes para valores fijos
    private static final int TIMEOUT_CONEXION = 5000; // 5 segundos
    private static final String METODO_HTTP = "GET";
    private static final String VERSION_HTTP = "HTTP/1.1";
    private static final String CABECERA_HOST = "Host: ";
    private static final String CABECERA_CONNECTION = "Connection: close";

    public static void main(String[] args) {
        // Definimos el servidor, puerto y ruta a la que nos conectaremos
        String destino = "jsonplaceholder.typicode.com";
        int puertoDestino = 80;
        String ruta = "/users";

        try {
            // Enviamos la petición GET y obtenemos la respuesta
            String respuesta = enviarPeticionGET(destino, puertoDestino, ruta);
            // Mostramos la respuesta en la consola
            System.out.println("Respuesta del servidor:\n" + respuesta);
        } catch (IOException e) {
            // Manejo de errores (por ejemplo, si no se puede conectar al servidor)
            System.err.println("Error al enviar la petición: " + e.getMessage());
        }
    }

    /**
     * Envía una petición GET al servidor y devuelve la respuesta.
     */
    public static String enviarPeticionGET(String destino, int puertoDestino, String ruta) throws IOException {
        // Creamos un socket y nos conectamos al servidor
        try (Socket socket = new Socket()) {
            // Establecemos la conexión con un tiempo de espera máximo
            socket.connect(new InetSocketAddress(destino, puertoDestino), TIMEOUT_CONEXION);
            System.out.println("Conexión establecida con " + destino + ":" + puertoDestino);

            // Enviamos la solicitud HTTP
            enviarSolicitudHTTP(socket, destino, ruta);

            // Leemos y devolvemos la respuesta del servidor
            return leerRespuestaHTTP(socket);
        }
    }

    /**
     * Envía la solicitud HTTP al servidor.
     */
    private static void enviarSolicitudHTTP(Socket socket, String destino, String ruta) throws IOException {
        // Obtenemos el flujo de salida del socket para enviar datos
        try  {
            OutputStream outputStream = socket.getOutputStream();
            // Construimos la solicitud HTTP
            String solicitud = construirSolicitudHTTP(destino, ruta);
            // Enviamos la solicitud al servidor
            outputStream.write(solicitud.getBytes());
            outputStream.flush();
            System.out.println("Solicitud enviada al servidor...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Construye la solicitud HTTP.
     */
    private static String construirSolicitudHTTP(String destino, String ruta) {
        // Usamos un StringBuilder para construir la solicitud de manera eficiente
        StringBuilder solicitud = new StringBuilder();
        solicitud.append(METODO_HTTP).append(" ").append(ruta).append(" ").append(VERSION_HTTP).append("\r\n");
        solicitud.append(CABECERA_HOST).append(destino).append("\r\n");
        solicitud.append(CABECERA_CONNECTION).append("\r\n\r\n");
        return solicitud.toString();
    }

    /**
     * Lee la respuesta HTTP del servidor.
     */
    private static String leerRespuestaHTTP(Socket socket) throws IOException {
        // Obtenemos el flujo de entrada del socket para leer datos
        try (InputStream inputStream = socket.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            // Leemos la respuesta línea por línea
            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                respuesta.append(linea).append("\n");
            }
            return respuesta.toString();
        }
    }
}