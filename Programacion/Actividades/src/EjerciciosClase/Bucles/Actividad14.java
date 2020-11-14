package EjerciciosClase.Bucles;

import java.util.Scanner;
/*
 * Project name: Actividades/PACKAGE_NAME
 * Filename: Activiada 14
 * Created:  13/11/2020 / 13:16
 * Description: En esta actividad hay que escrivir un programa que detecte numeros enteros para calcuclar su potencia.
 *              Si se detecta cualquier otra entrada que no es un numero entero saldra un error y el programa terminará.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Actividad14 {
    public static void start() {

        //Declaramos la variables a usar asi como la instancia de secaner.
        Scanner sc = new Scanner(System.in);
        int numero1;
        int numero2;
        try {
            System.out.print("Introduce el primer numero: ");
            numero1=sc.nextInt();
            System.out.print("Introduce el segundo numero: ");
            numero2=sc.nextInt();
            for (int i = 1; i < numero2; i++) {
                numero1*=numero1;
            }
            System.out.println(numero1);
        }catch (Exception e){
            System.out.println("Error");
            System.exit(1);
        }
    }
}
