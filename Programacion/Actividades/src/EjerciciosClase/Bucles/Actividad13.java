package EjerciciosClase.Bucles;

import java.util.Scanner;
/*
 * Project name: Actividades
 * Filename: Actividad 13
 * Description: En esta actividad hay que escribir un programa que lea una lista de 10 numeros y calcule cuantos son
 *              positivos y cuantos son negativos. Si se detecta una entrada que no sea un numero entero peositivo
 *              o negativo, mostrara un mesaje de eeror y se parara.
 * Created:  12/11/2020/16:46
 * Revision:
 * @Author: Usuario - fmartin@nigul.cide.es
 * @Version: 1.0
 * Extra: Toda la información a sido extraida del manual ocila de oracle.
 */

public class Actividad13 {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        int user;
        int[] numeros = new int[10];
        int positivos = 0;
        int negativos = 0;

        System.out.println("Por favor introduce 10 numeros");
        for (int i=0; i<numeros.length;i++){
            try {
                user=sc.nextInt();
                if (user<=0||user>=0){
                    numeros[i]=user;
                }
            }catch (Exception e){
                System.out.println("Error");
                System.exit(1);/*Con System.exit(); terminamos el programa, con el argumento 1 indicamos que es un
                                      cierre anormal. Por convenio se usa el 0 para cierres controlados.*/
            }
        }
        for (int j=0;j<numeros.length; j++){
            if (numeros[j]<=0){
                negativos++;
            }else if (numeros[j]>=0){
                positivos++;
            }
        }
        System.out.println("El recuento de numeros positivos es: "+positivos+" Y el recuento de numeros negativos son: "+negativos);
        System.out.println("Fin del programa");
    }
}
