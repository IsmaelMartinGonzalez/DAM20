package EjerciciosClase.Objetos.coche;

import java.util.Scanner;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename: Test
 * Created:  03/12/2020 / 13:08
 * Description: Esta sera la clase test que comprovara nuestro ejercicio coche.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Test {
    static Scanner sc = new Scanner(System.in);
    public static void start() {
        menu();
    }
    private static void menu() {
        boolean salir = false;
        int opcion;//Opcion elejida por el user

        while (!salir){
            System.out.println("Opcion 1: Crear coches");
            System.out.println("Opcion 2: Coches");
            System.out.println("Opcion 3: salir");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Creacion de un coche");
                    crearCoches();

                }
                case 2 -> {
                    System.out.println("Restar!");
                    coches();
                }
                case 3 -> {
                    System.out.println("Adios");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 3");
            }
        }
    }

    private static void coches() {
    }

    private static void crearCoches() {
        int numCoches;
        String marca;
        String modelo;
        String tipo;
        TipusCanvi cambio=TipusCanvi.CanviManual;
        boolean descapotable;

        System.out.println("¿Cuantos coches quieres crear?");
        numCoches=sc.nextInt();
        PRU03E02Coche_Ismael_Martin[] coches= new PRU03E02Coche_Ismael_Martin[numCoches];
        for (int i = 0; i < numCoches; i++) {
            System.out.println("Coche numero "+i);
            System.out.print("Introduce la marca del coche: ");
            marca=sc.next();
            System.out.print("Introduce el modelo del coche: ");
            modelo=sc.next();
            System.out.print("Introduce el tipo de cambio de marchas(Cambio automatico o Cambio manual): ");
            tipo=sc.next();
            if (tipo.equals("Cambio automatico")){
                cambio=TipusCanvi.CanviAutomatic;
            }else if (tipo.equals(" Cambio manual")){
                cambio=TipusCanvi.CanviManual;
            }
            System.out.print("Introduce si el coche es descapotable o no (Si o No): ");
            descapotable=sc.hasNext();

            coches[i]=new PRU03E02Coche_Ismael_Martin(marca,modelo,cambio,descapotable);
        }
    }
}
