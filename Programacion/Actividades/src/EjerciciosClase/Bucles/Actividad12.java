package EjerciciosClase.Bucles;

import java.util.Scanner;
public class Actividad12 {
    public static void start() {
        //Declaramos las variables ausar e insanciamos Scanner
        Scanner sc = new Scanner(System.in);
        int user;
        int z=0;
        int n1= 1;
        int n2;
        //Pedimos los datos para saber cuanto numero desea el ususario ver.
        System.out.println("¿Cuantos numero quieres ver?");
        user=sc.nextInt();
        //Declaramos un for para poder automatizar el calculo y poder mostrar el resultado.
        for (int i=0; i<=user;i++){
            n2=z;
            z=n1+z;
            n1=n2;
            System.out.print("\t"+n1);
        }
    }
}
