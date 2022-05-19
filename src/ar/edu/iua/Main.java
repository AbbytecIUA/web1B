package ar.edu.iua;

import java.util.Scanner;

import ar.edu.iua.interfazusuario.BorrarPlanesMenu;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanes;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanesImpl;
import ar.edu.iua.interfazusuario.CrearPlanesMenu;
import ar.edu.iua.interfazusuario.ModificarPlanesMenu;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.modelo.exceptions.ModificarPlanEx;
import ar.edu.iua.util.Pruebas;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Comienzo de main\n\n");

        int i = -1;
        while (i != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1- Crear Planes");
            System.out.println("2- Borrar Planes");
            System.out.println("3- Modificar Planes");
            System.out.println("4- Buscar E Imprimir Planes");
            System.out.println("5- Ejecutar Prueba");
            System.out.println("0- Salir");
            i = scanner.nextInt();
            try{
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
                        System.out.println("Ingrese los terminos de busqueda:");
                        String terminos = new String();
                        while (terminos.isEmpty()) {
                            terminos = Main.scanner.nextLine();
                        }
                        BuscarEImprimirPlanes buscarEImprimirPlanes = new BuscarEImprimirPlanesImpl();
                        buscarEImprimirPlanes.buscar(terminos);
                        break;
                    case 5:
                        Pruebas pruebas = new Pruebas();
                            pruebas.probar();
                        
                        break;
                }
            }
            catch (CrearPlanEx | ModificarPlanEx | BorrarPlanEx e) {
                System.err.println(e.getMessage());
            } 
        }
        scanner.close();  
    }

}