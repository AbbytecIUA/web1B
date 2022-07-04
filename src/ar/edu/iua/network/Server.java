
package ar.edu.iua.network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author CARLOMAGNO
 */
public class Server {
    ServerSocket server;
    boolean finalize;
    public void IniciarServidor(int Puerto) {
        try {
            server = new ServerSocket(Puerto);
            System.out.println("Servidor del colegio funcionado en el Puerto: " + Puerto);
            finalize = false;
            while (!finalize) {
                new administradorSocket(server.accept()).procesarSocket();
            }
        } catch (Exception ex) {
            System.out.println("Socket cerrado.");
        }
    }

    public void DetenerServidor(){
        finalize=true;
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
