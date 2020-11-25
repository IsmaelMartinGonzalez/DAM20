package EjerciciosClase.Bucles;

public class Actividad1 {
    public static void start() {
        //Declaramos la variable numero para poder hacer los multiplos de 5.
        int numero = 5;
        //Declaramos el bucle for para poder mostrar los multiplos de 5, del 0 al 100.
        for (int i = 0; i<=100; i++) {
            int multiplo = numero * i;
            System.out.println(multiplo);
        }
        /* Terea corregida
        for(int i = 0; i <= 100; i += 5) {
            System.out.println(i);
        }
         */
    }
}
