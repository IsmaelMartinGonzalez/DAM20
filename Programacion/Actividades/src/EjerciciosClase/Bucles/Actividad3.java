package EjerciciosClase.Bucles;

public class Actividad3 {
    public static void start() {
        //Declaramos la variable i para tener un contador. Declaramos la variable numero con el numero a se multiplicar.
        int i = 0;
        int numero =5;
        //Declaramos el bucle do/while para calcular y mostrar los multiplos de 5.

        do {
            int multiplo = numero*i;
            System.out.println(multiplo);
            i++;
        }while (i<=100);
    }
    /*Tarea corregida
    int i = 0;

        do {
            System.out.println(i);
            i+=5;
        } while(i <= 100);
     */
}
