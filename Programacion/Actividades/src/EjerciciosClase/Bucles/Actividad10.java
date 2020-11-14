package EjerciciosClase.Bucles;

import  java.util.*;
public class Actividad10 {
    public static void start() {

        // Programa que calcule la media de números introducidos por el usuario. No habrá más números en el Array cuando se introduzca un negativo
        int user;
        int suma =0;

        ArrayList<Integer> numeros = new ArrayList<>();
        //Inicializamos el scaner fuera y pedimos el primer valor
        Scanner input_user = new Scanner(System.in);
        user = input_user.nextInt();

        //Luego declaramos un while para pedir valores hasta canzarnos
        while(user > 0){
            numeros.add(user);
            user=input_user.nextInt();
        }

        //Hacemos las operaciones necesarias para sacar la media
        for (var i:numeros){
            suma +=i;
        }
        int media = suma/numeros.size();
        System.out.println(media);
    }

}
