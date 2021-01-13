package EjerciciosClase.HashMap;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename:
 * Created:  14/11/2020 / 13:47
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Ac1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int intentos =3;
        boolean acces=false;
        HashMap<Integer,String> restringedArea=new HashMap<>();
        restringedArea.put(119,"Paco Martinez Soaria");
        do {
            System.out.println("Por favor introduce tu usuario y contresña.");
            System.out.print("Usuario: ");

        }while (!acces||intentos==0);
    }
}
