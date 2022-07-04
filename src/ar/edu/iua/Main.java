package ar.edu.iua;

import java.util.Scanner;

import ar.edu.iua.interfazusuario.AdministrarPersonalMenu;
import ar.edu.iua.interfazusuario.BorrarPlanesMenu;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanes;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanesImpl;
import ar.edu.iua.interfazusuario.CrearPlanesMenu;
import ar.edu.iua.interfazusuario.ModificarPlanesMenu;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.modelo.exceptions.ModificarPlanEx;
import ar.edu.iua.network.Server;
import ar.edu.iua.util.Pruebas;

public class Main extends Thread{
    public static Scanner scanner = new Scanner(System.in);
    public static Server s1;
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        s1 = new Server();
        System.out.println("Comienzo de main\n\n");
        Thread servidor = new Thread(() -> {
            try {
                s1.IniciarServidor(8866);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        servidor.start();
        int i = -1;
        while (i != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1- Crear Planes");
            System.out.println("2- Borrar Planes");
            System.out.println("3- Modificar Planes");
            System.out.println("5- Buscar E Imprimir Planes");
            System.out.println("6- Ejecutar Prueba");
            System.out.println("0- Salir");
            i = scanner.nextInt();
            try {
                switch (i) {
                    default:
                        System.out.println("\n\nFin de main");
                        break;
                    case 1:
                        new CrearPlanesMenu();
                        break;
                    case 2:
                        new BorrarPlanesMenu();
                        break;
                    case 3:
                        new ModificarPlanesMenu();
                        break;
                    case 4:
                        new AdministrarPersonalMenu();
                        break;
                    case 5:
                        System.out.println("Ingrese los terminos de busqueda:");
                        String terminos = new String();
                        while (terminos.isEmpty()) {
                            terminos = Main.scanner.nextLine();
                        }
                        BuscarEImprimirPlanes buscarEImprimirPlanes = new BuscarEImprimirPlanesImpl();
                        buscarEImprimirPlanes.buscar(terminos);
                        break;
                    case 6:
                        Pruebas pruebas = new Pruebas();
                        pruebas.probar();
                        break;
                }
            } catch (CrearPlanEx | ModificarPlanEx | BorrarPlanEx e) {
                System.err.println(e.getMessage());
            }
        }
        scanner.close();
        s1.DetenerServidor();
        servidor.stop();
    }
    public static String readLine(){
        String temp = new String();
        while(temp.isEmpty()){
            temp = Main.scanner.nextLine();
        }
        return temp;
    }

}