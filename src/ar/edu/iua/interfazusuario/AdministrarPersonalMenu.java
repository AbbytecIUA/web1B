package ar.edu.iua.interfazusuario;

import ar.edu.iua.Main;
import ar.edu.iua.modelo.academico.personal.Domicilio;
import ar.edu.iua.modelo.academico.personal.Estudiante;
import ar.edu.iua.modelo.academico.personal.Persona;
import ar.edu.iua.modelo.academico.personal.Profesor;
import ar.edu.iua.modelo.academico.personal.Persona.tipo;
import ar.edu.iua.persistencia.BaseDeDatos;

public class AdministrarPersonalMenu {
    public AdministrarPersonalMenu(){
        String dni = new String();
        System.out.println(" 1- Añadir estudiante");
        System.out.println(" 2- Añadir profesor/a");
        System.out.println(" 3- Modificar estudiante");
        System.out.println(" 4- Modificar profesor/a");
        System.out.println(" 5- Eliminar estudiante");
        System.out.println(" 6- Eliminar profesor/a");
        int valor = Main.scanner.nextInt();
        if(valor==1||valor==2||valor==3||valor==4||valor==5||valor==6){
            System.out.println("A continuación ingrese los datos del estudiante o profesor/a");
            System.out.println("Ingrese el dni:");
            dni = Main.readLine();
        }

        while(valor!=0){
            switch (valor) {
                case 1:
                    if(!Persona.comprobarExistencia(dni, tipo.ESTUDIANTE)){
                        System.out.println("Nombre y Apellido:");
                        String nombre = Main.readLine();

                        System.out.println("Edad:");
                        int edad = Main.scanner.nextInt();

                        System.out.println("Provincia de residencia:");
                        String provincia = Main.readLine();

                        System.out.println("Ciudad de residencia:");
                        String ciudad = Main.readLine();

                        System.out.println("Calle y numero:");
                        String calle_numero = Main.readLine();

                        System.out.println("Código postal:");
                        String codigoPostal = Main.readLine();

                        System.out.println("Teléfono de contacto");
                        String telefono = Main.readLine();

                        Domicilio domicilio = new Domicilio(calle_numero, ciudad, provincia, codigoPostal, telefono);
                        Estudiante estudiante = new Estudiante(dni, nombre, edad, domicilio, 0);

                        BaseDeDatos.addEstudiante(estudiante);
                    }else{
                        System.out.println("El estudiante que desea agregar ya existe en la base de datos.");
                    }
                    
                    break;
                case 2:
                    if(!Persona.comprobarExistencia(dni, tipo.ESTUDIANTE)){
                        System.out.println("Nombre y Apellido:");
                        String nombre = Main.readLine();

                        System.out.println("Edad:");
                        int edad = Main.scanner.nextInt();

                        System.out.println("Provincia de residencia:");
                        String provincia = Main.readLine();

                        System.out.println("Ciudad de residencia:");
                        String ciudad = Main.readLine();

                        System.out.println("Calle y numero:");
                        String calle_numero = Main.readLine();

                        System.out.println("Código postal:");
                        String codigoPostal = Main.readLine();

                        System.out.println("Teléfono de contacto:");
                        String telefono = Main.readLine();

                        
                        System.out.println("Ingrese la cantidad de títulos que tiene:");
                        int cant = Main.scanner.nextInt();
                        String[] titulos = new String[cant];
                        for(int i=0; i< cant; i++){
                            System.out.println("Titulo nro "+i+":");
                            titulos[i]=Main.readLine();
                        }

                        Domicilio domicilio = new Domicilio(calle_numero, ciudad, provincia, codigoPostal, telefono);
                        Profesor profe = new Profesor(dni, nombre, edad, domicilio, titulos);

                        BaseDeDatos.addProfesor(profe);
                    }else{
                        System.out.println("El profesor que desea agregar ya existe en la base de datos.");
                    }
                    
                    break;
                case 3:
                    Estudiante estAModificar = new Estudiante();
                    boolean estEncontrado = false;
                    for (int i = 0; i < BaseDeDatos.getSizeEstudiantes(); i++) {
                        if(BaseDeDatos.getEstudiante(i).getDocumento().equals(dni)){
                            estAModificar=BaseDeDatos.getEstudiante(i);
                            estEncontrado = true;
                        }
                    }
                    if(estEncontrado){
                        System.out.println("Presione enter en el caso que no desee modificar el dato, de lo contrario ingerse el nuevo");
                        System.out.println("Nombre y Apellido, "+estAModificar.getNombre()+":");
                        String nombre = Main.readLine();
                        if(!nombre.isBlank()){
                            estAModificar.setNombre(nombre);
                        }

                        System.out.println("Edad, "+estAModificar.getEdad()+":");
                        String edad = Main.readLine();
                        if(!edad.isBlank()){
                            estAModificar.setEdad(Integer.parseInt(edad));
                        }

                        System.out.println("Provincia de residencia, "+estAModificar.getDomicilio().getProvincia()+":");
                        String provincia = Main.readLine();
                        if(!provincia.isBlank()){
                            estAModificar.getDomicilio().setProvincia(provincia);
                        }

                        System.out.println("Ciudad de residencia, "+estAModificar.getDomicilio().getCiudad()+":");
                        String ciudad = Main.readLine();
                        if(!ciudad.isBlank()){
                            estAModificar.getDomicilio().setCiudad(ciudad);
                        }

                        System.out.println("Calle y numero, "+estAModificar.getDomicilio().getCalle_numero()+":");
                        String calle_numero = Main.readLine();
                        if(!calle_numero.isBlank()){
                            estAModificar.getDomicilio().setCalle_numero(calle_numero);
                        }

                        System.out.println("Código postal, "+estAModificar.getDomicilio().getCodigoPostal()+":");
                        String codigoPostal = Main.readLine();
                        if(!codigoPostal.isBlank()){
                            estAModificar.getDomicilio().setCodigoPostal(codigoPostal);
                        }

                        System.out.println("Teléfono, "+estAModificar.getDomicilio().getTelefono()+":");
                        String telefono = Main.readLine();
                        if(!telefono.isBlank()){
                            estAModificar.getDomicilio().setTelefono(telefono);
                        }

                        
                        System.out.println("Cantidad de amonestaciones, "+estAModificar.getAmonestaciones()+":");
                        String amonestaciones = Main.readLine();
                        if(!amonestaciones.isBlank()){
                            estAModificar.setAmonestaciones(Float.parseFloat(amonestaciones));
                        }
                    }else{
                        System.out.println("El estudiante que desea modificar no existe en la base de datos.");
                    }
                    break;
                case 4:
                    Profesor profAModificar = new Profesor();
                    boolean profEncontrado = false;
                    for (int i = 0; i < BaseDeDatos.getSizeProfesores(); i++) {
                        if(BaseDeDatos.getProfesor(i).getDocumento().equals(dni)){
                            profAModificar=BaseDeDatos.getProfesor(i);
                            profEncontrado = true;
                        }
                    }
                    if(profEncontrado){
                        System.out.println("Presione enter en el caso que no desee modificar el dato, de lo contrario ingerse el nuevo");
                        System.out.println("Nombre y Apellido, "+profAModificar.getNombre()+":");
                        String nombre = Main.readLine();
                        if(!nombre.isBlank()){
                            profAModificar.setNombre(nombre);
                        }

                        System.out.println("Edad, "+profAModificar.getEdad()+":");
                        String edad = Main.readLine();
                        if(!edad.isBlank()){
                            profAModificar.setEdad(Integer.parseInt(edad));
                        }

                        System.out.println("Provincia de residencia, "+profAModificar.getDomicilio().getProvincia()+":");
                        String provincia = Main.readLine();
                        if(!provincia.isBlank()){
                            profAModificar.getDomicilio().setProvincia(provincia);
                        }

                        System.out.println("Ciudad de residencia, "+profAModificar.getDomicilio().getCiudad()+":");
                        String ciudad = Main.readLine();
                        if(!ciudad.isBlank()){
                            profAModificar.getDomicilio().setCiudad(ciudad);
                        }

                        System.out.println("Calle y numero, "+profAModificar.getDomicilio().getCalle_numero()+":");
                        String calle_numero = Main.readLine();
                        if(!calle_numero.isBlank()){
                            profAModificar.getDomicilio().setCalle_numero(calle_numero);
                        }

                        System.out.println("Código postal, "+profAModificar.getDomicilio().getCodigoPostal()+":");
                        String codigoPostal = Main.readLine();
                        if(!codigoPostal.isBlank()){
                            profAModificar.getDomicilio().setCodigoPostal(codigoPostal);
                        }

                        System.out.println("Teléfono, "+profAModificar.getDomicilio().getTelefono()+":");
                        String telefono = Main.readLine();
                        if(!telefono.isBlank()){
                            profAModificar.getDomicilio().setTelefono(telefono);
                        }

                        
                        System.out.println("Ingrese la cantidad de títulos que tiene:");
                        int cant = Main.scanner.nextInt();
                        String[] titulos = new String[cant];
                        for(int i=0; i< cant; i++){
                            System.out.println("Titulo nro "+i+" = "+profAModificar.getTitulos()[i]+":");
                            titulos[i]=Main.readLine();
                            if(titulos[i].isBlank()){
                                titulos[i]=profAModificar.getTitulos()[i];
                            }
                        }
                        profAModificar.setTitulos(titulos);
                    }else{
                        System.out.println("El profesor que desea modificar no existe en la base de datos.");
                    }
                    break;
                case 5:
                    if(Persona.comprobarExistencia(dni, tipo.ESTUDIANTE)){
                        BaseDeDatos.removeEstudiante(dni);
                    }else{
                        System.out.println("El estudiante que desea borrar no existe en la base de datos.");
                    }
                    break;
                case 6:
                    if(Persona.comprobarExistencia(dni, tipo.PROFESOR)){
                        BaseDeDatos.removeProfesor(dni);
                    }else{
                        System.out.println("El profesor que desea borrar no existe en la base de datos.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
                
        }
    }
    
    
}
