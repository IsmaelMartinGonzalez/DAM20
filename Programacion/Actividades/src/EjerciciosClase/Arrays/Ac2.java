package EjerciciosClase.Arrays;

import java.util.ArrayList;
import java.util.Collections;

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
        int media=0;
        int max=0;
        for (int i = 0; i < n; i++) {
            valores= (int)Math.floor(Math.random()*101);
            numeros.add(valores);
        }
        System.out.println(numeros);
        Collections.sort(numeros);
        for (int numbres:
             numeros) {
            suma+=numbres;
        }
        media=suma/n;
        System.out.println("Cantidadde numeros= "+n);
        System.out.println("La sumad de los numero es = "+suma);
        System.out.println("La media es = "+media);
        System.out.println(numeros);
        System.out.println(numeros.get(0));
        System.out.println(numeros.get(n-1));
    }
}
