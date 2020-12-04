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
    static PRU03E02Coche_Ismael_Martin[] coches;

    public static void start() {
        menu();
    }

    private static void menu() {
        boolean salir = false;
        int opcion;//Opcion elejida por el user

        while (!salir){
            System.out.println("Bienvenido a la practica coche de programacion de priemro de DAM por favor elije uan opcion");
            System.out.println("Opcion 1: Ver coches");
            System.out.println("Opcion 2: Crear coches");
            System.out.println("Opcion 3: salir");
            System.out.print("Opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("---------------------------");
                    System.out.println("Entrando en ver coches!");
                    System.out.println("---------------------------");
                    verCoches();
                }
                case 2 -> {
                    System.out.println("---------------------------");
                    System.out.println("Entrando de crear coches!");
                    System.out.println("---------------------------");
                    crearCoches();
                }
                case 3 -> {
                    System.out.println("---------------------------");
                    System.out.println("Hasta la proxima!");
                    System.out.println("---------------------------");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 3");
            }
        }
    }

    private static void crearCoches() {
        int numCoches;
        String marca;
        String modelo;
        String tipo;
        TipusCanvi cambio=TipusCanvi.CanviManual;
        String descapotable;
        boolean capota=false;
        System.out.println("¿Cuantos coches quieres crear?");
        numCoches=sc.nextInt();
        coches=new PRU03E02Coche_Ismael_Martin[numCoches];
        for (int i = 0; i < numCoches; i++) {
            System.out.println("Coche numero "+i);
            System.out.print("Introduce la marca del coche: ");
            marca=sc.next();
            System.out.print("Introduce el modelo del coche: ");
            modelo=sc.next();
            System.out.print("Introduce el tipo de cambio de marchas(automatico o manual): ");
            tipo=sc.next();
            if (tipo.equals("automatico")){
                cambio=TipusCanvi.CanviAutomatic;
            }else if (tipo.equals("manual")){
                cambio=TipusCanvi.CanviManual;
            }
            System.out.print("Introduce si el coche es descapotable o no (Si o No): ");
            descapotable=sc.next();
            if (descapotable.equals("Si")){
                capota=true;
            }else if (descapotable.equals("No")){
                capota=false;
            }
            coches[i]=new PRU03E02Coche_Ismael_Martin(marca,modelo,cambio,capota);
        }

    }

    private static void verCoches() {
        String userIntro;
        int userOpcion;
        boolean salir=false;
        while (!salir){
            System.out.println("Porfavor introduce el numero de coche con el que vas a trabajar, empezando desde 0 hasta n coches creados o escribe 'volver' para regresar al menu de inicio");
            System.out.print("Esperando respuesta: ");
            userIntro=sc.next();
            System.out.println("---------------------------");
            if (userIntro.equals("volver")){
                salir=true;
            }else {
                int user=Integer.parseInt(userIntro);
                boolean exit=false;
                while (!exit){
                    System.out.println("");
                    System.out.println("Acontinuación elije que operacion deseas realizar");
                    System.out.println("Opcion 1: Arrancar el motor");
                    System.out.println("Opcion 2: Comprovar motor");
                    System.out.println("Opcion 3: Ver revoluciones motor");
                    System.out.println("Opcion 4: Parar motor");
                    System.out.println("Opcion 5: Acelerar");
                    System.out.println("Opcion 6: Frenar");
                    System.out.println("Opcion 7: Ver la velocidad del coche");
                    System.out.println("Opcion 8: Activar el limpia parabirsas");
                    System.out.println("Opcion 9: Quitar capota(Si es descapotable)");
                    System.out.println("Opcion 10: Poner capota(Si es descapotable)");
                    System.out.println("Opcion 11: Activar el aire acondicionaado");
                    System.out.println("Opcion 12: Salir");
                    System.out.print("Esperando respuesta: ");
                    userOpcion=sc.nextInt();
                    try {
                            switch (userOpcion){
                                case 1:
                                    coches[user].arrancarMotor();
                                    System.out.println("---------------------------");
                                    System.out.println("Arrancando motor");
                                    System.out.println("---------------------------");
                                    break;
                                case 2:
                                    System.out.println("---------------------------");
                                    System.out.println("El estado del motor es "+coches[user].comprovaMotor());
                                    System.out.println("---------------------------");
                                    break;
                                case 3:
                                    System.out.println("---------------------------");
                                    System.out.println("El motor va a "+coches[user].getRevolucions()+" revoluciones");
                                    System.out.println("---------------------------");

                                    break;
                                case 4:
                                    coches[user].aturarMotor();
                                    System.out.println("---------------------------");
                                    System.out.println("Parando motor");
                                    System.out.println("---------------------------");
                                    break;
                                case 5:
                                    coches[user].acelerar();
                                    System.out.println("---------------------------");
                                    System.out.println("Acelerando");
                                    System.out.println("---------------------------");
                                    break;
                                case 6:
                                    coches[user].frenar();
                                    System.out.println("---------------------------");
                                    System.out.println("Frenando");
                                    System.out.println("---------------------------");
                                    break;
                                case 7:
                                    System.out.println("---------------------------");
                                    System.out.println("El coche va a "+ coches[user].getVelocidad()+" Km/h");
                                    System.out.println("---------------------------");
                                    break;
                                case 8:
                                    int vlimpia;
                                    System.out.println("---------------------------");
                                    System.out.println("Elige la velocidad del limpia. Ha de ser un valor entero entre 0 y 3");
                                    vlimpia= sc.nextInt();
                                    coches[user].setvLimpia(vlimpia);
                                    coches[user].limiaParabrisas();
                                    System.out.println("---------------------------");
                                    break;
                                case 9:
                                    coches[user].quitarCapota();
                                    System.out.println("---------------------------");
                                    System.out.println("Guardadndo capota");
                                    System.out.println("---------------------------");
                                    break;
                                case 10:
                                    coches[user].ponerCapota();
                                    System.out.println("---------------------------");
                                    System.out.println("Desplegando capota");
                                    System.out.println("---------------------------");
                                    break;
                                case 11:
                                    int opcion;
                                    System.out.println("---------------------------");
                                    System.out.println("Elige el modo de aire. Ha de ser un valor entero entre 0 y 2");
                                    opcion= sc.nextInt();
                                    coches[user].setOpcion(opcion);
                                    coches[user].aireAcondicionado();
                                    System.out.println("---------------------------");
                                    break;
                                case 12:
                                    System.out.println("---------------------------");
                                    System.out.println("Volviendo al menu");
                                    exit=true;
                                    System.out.println("---------------------------");
                                    break;
                                default:
                                    System.out.println("---------------------------");
                                    System.out.println("Introduce una de las opciones listadas anteriormente");
                                    System.out.println("---------------------------");
                            }
                    }catch (NullPointerException e){
                        System.out.println("---------------------------");
                        System.out.println("Para poder trabajar con coches primero hay que crearlos");
                        System.out.println("---------------------------");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("---------------------------");
                        System.out.println("No se puede trabajar con 0 coches");
                        System.out.println("---------------------------");
                    }catch (Exception e){
                        System.out.println("---------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("---------------------------");
                    }
                }
            }

        }
    }

}
