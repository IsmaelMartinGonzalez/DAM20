package EjerciciosClase.Bucles;

import  java.util.*;
public class Actividad9 {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        String algo;
        int contador =1;
        System.out.print("Introduce una palabra");
        algo = sc.next();
        while (contador<algo.length()){
            contador++;
        }
        System.out.println("El total de digitos es "+contador);

    }
}
