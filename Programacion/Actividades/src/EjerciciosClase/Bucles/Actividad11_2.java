package EjerciciosClase.Bucles;

import java.util.Scanner;
public class Actividad11_2 {
    public static void start() {
        //Declaramos las variables a usar e instanciamos el scanner
        Scanner sc = new Scanner(System.in);
        int numero;
        int cuadrado;
        int cubo;

        for (int i=0; i<5; i++){
            System.out.print("Introduce un valor ");
            numero=sc.nextInt();
            cuadrado=numero*numero;
            cubo=numero*numero*numero;
            System.out.println("Numero\tCuadrado\tCubo");
            System.out.println(numero+"\t\t"+cuadrado+"\t\t\t"+cubo);
        }
        System.out.println("Ha terminado el programa adios");
    }
}
