package ar.edu.iua.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.*;

public class GenerarEjemplosDePlanes {


    // Este metodo primero crea 2 planes, segun https://monserrat.unc.edu.ar/secundario/plan-de-estudios/#1523542585948-acc3dfd8-8da3
    // y tambien crea de forma aleatoria una determinada cantidad de planes
    public static List<Plan> generar(int cantidadAGenerar, boolean imprimirResultado) {

        List<Plan> planes = new ArrayList<Plan>();

        // ==========================================================================

        // PLAN 2018

        Plan plan2018 = new PlanImpl();

        plan2018.setAnio(2018);
        plan2018.setEstadoActivo();

        planes.add(plan2018);

        // AÑOS DEL PLAN 2018

        AnioPlan primero = new AnioPlanImpl(1, "Primer año");
        AnioPlan segundo = new AnioPlanImpl(2, "Segundo año");
        AnioPlan tercero = new AnioPlanImpl(3, "Tercero año");
        AnioPlan cuarto = new AnioPlanImpl(4, "Cuarto año");
        AnioPlan quinto = new AnioPlanImpl(5, "Quinto año");

        plan2018.getAnios().add(primero);
        plan2018.getAnios().add(segundo);
        plan2018.getAnios().add(tercero);
        plan2018.getAnios().add(cuarto);
        plan2018.getAnios().add(quinto);

        // MATEIAS DEL PLAN 2018 - PRIMER AÑO

        int codigoMateria = 1;

        Materia m1 = new MateriaImpl(codigoMateria++, "Ciencias de la Vida y de la Tierra ", 3.0);
        Materia m2 = new MateriaImpl(codigoMateria++, "Lengua y Literatura Castellanas I", 5.0);
        Materia m3 = new MateriaImpl(codigoMateria++, "Lengua y Cultura Latinas I ", 4.0);
        Materia m4 = new MateriaImpl(codigoMateria++, "Lengua y Cultura Inglesas I ", 3.0);
        Materia m5 = new MateriaImpl(codigoMateria++, "Formación Musical I ", 3.0);
        Materia m6 = new MateriaImpl(codigoMateria++, "Formación Plástica I ", 3.0);
        Materia m7 = new MateriaImpl(codigoMateria++, "Matemática I", 4.0);
        Materia m8 = new MateriaImpl(codigoMateria++, "Geografía I ", 3.0);
        Materia m9 = new MateriaImpl(codigoMateria++, "Historia I", 3.0);
        Materia m10 = new MateriaImpl(codigoMateria++, "Formación Ética y Ciudadana I", 3.0);
        Materia m11 = new MateriaImpl(codigoMateria++, "Estrategias de Aprendizaje y Entornos Virtuales", 4.0);
        Materia m12 = new MateriaImpl(codigoMateria++, "Educación Física y Deportes I", 0.0);

        primero.getMaterias().add(m1);
        primero.getMaterias().add(m2);
        primero.getMaterias().add(m3);
        primero.getMaterias().add(m4);
        primero.getMaterias().add(m5);
        primero.getMaterias().add(m6);
        primero.getMaterias().add(m7);
        primero.getMaterias().add(m8);
        primero.getMaterias().add(m9);
        primero.getMaterias().add(m10);
        primero.getMaterias().add(m11);
        primero.getMaterias().add(m12);

        // MATEIAS DEL PLAN 2018 - SEGUNDO AÑO

        codigoMateria = 1;

        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Educación para la Salud", 4.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Lengua y Literatura Castellanas II ", 5.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Lengua y Cultura Latinas II ", 4.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Lengua y Cultura Inglesas II  ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Formación Musical II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Formación Plástica II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Matemática II ", 4.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Geografía II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Historia II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Formación Ética y Ciudadana II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Educación Física y Deportes II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Espacios Optativos 2019/2021", 3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++, "Espacios Optativos 2022", 3.0));



        // MATEIAS DEL PLAN 2018 - TERCER AÑO

        codigoMateria = 1;

        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Ciencias Naturales",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura Castellanas III",5.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas III",4.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Inglesas III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Formación Plástica III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática III",4.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia III",4.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Formación Ética y Ciudadana III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Tecnológica",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física y Deportes III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Espacios Optativos 2021",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Espacios Optativos 2022",3.0));
;


        // MATEIAS DEL PLAN 2018 - CUARTO AÑO

        codigoMateria = 1;

        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología I",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Físico-Química",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura Castellanas IV",4.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas IV",4.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Inglesa IV",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Francesas I",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia del Arte",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática IV",5.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía IV",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia IV",4.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física y Escuadras I",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Espacios Optativos 2021",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Espacios Optativos 2022",3.0));


        // MATEIAS DEL PLAN 2018 - QUINTO AÑO

        codigoMateria = 1;

        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología II",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Química",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura Castellanas IV",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Griegas",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Inglesas IV",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Francesas II",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática V",5.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía V",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia V",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lógica",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física y Escuadras",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Espacios Optativos 2022",3.0));


        // PLAN 2001

        Plan plan2001 = new PlanImpl();

        plan2001.setAnio(2001);
        plan2001.setEstadoNoActivo();

        planes.add(plan2001);

        // AÑOS DEL PLAN 2001

        primero = new AnioPlanImpl(1, "Primer año");
        segundo = new AnioPlanImpl(2, "Segundo año");
        tercero = new AnioPlanImpl(3, "Tercero año");
        cuarto = new AnioPlanImpl(4, "Cuarto año");
        quinto = new AnioPlanImpl(5, "Quinto año");
        AnioPlan sexto = new AnioPlanImpl(6, "Sexto año");
        AnioPlan septimo = new AnioPlanImpl(7, "Septimo año");

        plan2001.getAnios().add(primero);
        plan2001.getAnios().add(segundo);
        plan2001.getAnios().add(tercero);
        plan2001.getAnios().add(cuarto);
        plan2001.getAnios().add(quinto);
        
        // MATEIAS DEL PLAN 2001 - PRIMER AÑO

        codigoMateria = 1;

        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura I",5.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas I",5.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés I",3.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía I",3.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia I",2.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática I",4.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Plástica I",2.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Música I",2.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Ciencias Naturales I",3.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Técnicas De Trabajo Intelectual I",2.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Informática I",2.0));
        primero.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física I",2.0));

        // MATEIAS DEL PLAN 2001 - SEGUNDO AÑO

        codigoMateria = 1;

        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura II",5.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas II",5.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés II",3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Formación Ética y Cívica I",2.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía II",3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia II",4.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática II",4.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Plástica II",2.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Música II",2.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Ciencias Naturales II",3.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Técnicas de Trabajo Intelectual II",2.0));
        segundo.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física II",2.0));

        // MATEIAS DEL PLAN 2001 - TERCER AÑO

        codigoMateria = 1;

        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura III",5.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas III",4.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Formación Ética y Cívica II",2.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia III",4.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia del Arte I",2.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Plástica III",2.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Música III",2.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Ciencias Naturales III",3.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática III",5.0));
        tercero.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física III",2.0));
        
        // MATEIAS DEL PLAN 2001 - CUARTO AÑO

        codigoMateria = 1;

        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura IV",4.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas IV",5.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés IV",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía IV",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia IV",4.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Formación Ética y Cívica III",2.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia del Arte II",2.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Plástica IV",2.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática IV",5.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología I",2.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Físico-química",3.0));
        cuarto.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física IV",2.0));


        // MATEIAS DEL PLAN 2001 - QUINTO AÑO

        codigoMateria = 1;

        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura V",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Latinas V",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Griegas I",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés V",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Francés I",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografía V",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia V",4.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Química I",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología II",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática V – Algebra",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Estadística y Probabilidades",3.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Informática II",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Metodología De La Investigación",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Filosofía I",2.0));
        quinto.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física V",2.0));


        // MATEIAS DEL PLAN 2001 - SEXTO AÑO

        codigoMateria = 1;

        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Literatura VI",3.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua y Cultura Griegas II",3.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Inglés VI",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Francés II",4.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia VI",3.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia de la Cultura I",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geografia VI",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Filosofía II",4.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Matemática Vi – Trigonometría",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Geometría",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología III",3.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Química II",3.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Física I",4.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Informática III",2.0));
        sexto.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física VI",2.0));


        // MATEIAS DEL PLAN 2001 - SEPTIMO AÑO

        codigoMateria = 1;

        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua Y Literatura VII",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Lengua Y Cultura Griegas III",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Francés III",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia VII",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Filosofía III",4.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Psicología",2.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Análisis Matemático y Geometría Analítica",4.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Biología IV",2.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Sociología",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Economía Política",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Historia De La Cultura II",2.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Elementos De Derecho Y Derecho Constitucional Argentino",3.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Informática IV",2.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Educación Física VII",2.0));
        septimo.getMaterias().add(new MateriaImpl(codigoMateria++,"Física II",3.0));

        // ==========================================================================

        generarYAgregarPlanesAleatoriamente(cantidadAGenerar, planes);

        // ==========================================================================

        if (imprimirResultado) {
            imprimirPlanes(planes);
        }

        return planes;

    }

    private static void generarYAgregarPlanesAleatoriamente(int cantidadAGenerar, List<Plan> planes){
        // todos los planes q se generen deben agregarse al parametro planes
        Plan temp;
        for(int i=0;i<cantidadAGenerar;i++){
            temp = new PlanImpl();
            temp.setAnio(2022+i);
            temp.setEstadoBorrador();
            planes.add(temp);
        }

    } 


    private static void imprimirPlanes(List<Plan> planes) {
        for (Plan plan : planes) {
            System.out.println("\n" + plan);
            for (AnioPlan anio : plan.getAnios()) {
                System.out.println("\t" + anio);
                for (Materia materia : anio.getMaterias()) {
                    System.out.println("\t\t" + String.format("%1$" + 2 + "s", materia.getCodigo()) + " - " + materia);
                }
                if (anio.getMaterias().size() == 0) {
                    System.out.println("\t\tA este año no se le cargaron materias!!");
                }
            }
            if (plan.getAnios().size() == 0) {
                System.out.println("\tA este plan no se le cargaron años!!");
            }

        }
    }

}
