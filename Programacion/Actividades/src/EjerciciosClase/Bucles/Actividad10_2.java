package EjerciciosClase.Bucles;

import java.util.*;
public class Actividad10_2 {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        int user;
        int i =0;
        int suma=0;
        int media;
        do{
            System.out.println("Introduce valores");
            user= sc.nextInt();
            if (user>0){
                suma=suma+user;
            }
            i++;
        }while(user>0);
        media=suma/(i-1);
        System.out.println("La media es "+media);
    }
}
