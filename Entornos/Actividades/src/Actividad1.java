import java.util.Scanner;
/*
 * Project name: ActividaesEntornos/PACKAGE_NAME
 * Filename: Actividad 1
 * Created:  12/11/2020 / 16:54
 * Description: En esta actividad comenzamos ha crearun entrono bien estructurado para nuestros programas
 *              en la que llamamos a funciones que se ejecuntan en el main. Mas adelante llamaremos a clases.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Actividad1 {
    public static void main(String[] args) {
        menu();
    }
    //Delaramos una funcion llamada menu que servira para poder navegar por nuestro programa.
    private static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;//Opcion elejida por el user

        while (!salir){
            System.out.println("Opcion 1: Sumar");
            System.out.println("Opcion 2: Restar");
            System.out.println("Opcion 3: Multiplicar");
            System.out.println("Opcion 4: Dividir");
            System.out.println("Opcion 5: salir");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Suma!");
                    suma();
                }
                case 2 -> {
                    System.out.println("Restar!");
                    resta();
                }
                case 3 -> {
                    System.out.println("Multiplicar!");
                    mult();
                }
                case 4 -> {
                    System.out.println("Dividir!");
                    div();
                }
                case 5 -> {
                    System.out.println("Adios");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 5");
            }
        }
    }
    //Definimos las funciones dedicadas a las operaciones
    private static void div() {
        System.out.println("divididos");
    }

    private static void mult() {
        System.out.println("Multiplicados");
    }

    private static void resta() {
        System.out.println("Restados");
    }

    private static void suma() {
        System.out.println("Sumados");
    }

}
