package EjerciciosClase.Arrays;

import java.util.ArrayList;

/**
 * Project name: DAM20/EjerciciosClase.Arrays
 * Filename:
 * Created:  13/01/2021 / 13:42
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Ac2 {
    public static void main(String[] args) {
        int n=(int)Math.floor(Math.random()*(20-10+1)+10);
        int valores;
        ArrayList<Integer> numeros=new ArrayList<Integer>();
        int suma=0;
        for (int i = 0; i < n; i++) {
            valores= (int)Math.floor(Math.random()*101);
            numeros.add(valores);
        }
        for (int numbres:
             numeros) {
            suma+=numbres;
        }
        System.out.println(suma);
    }
}
