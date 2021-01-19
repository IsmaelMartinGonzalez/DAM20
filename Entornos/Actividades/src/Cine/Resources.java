package Cine;

/**
 * Project name: DAM20/Cine
 * Filename:
 * Created:  19/01/2021 / 9:42
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Resources {
    //Metodo usado para generar numero enteros aleatorios.
    public static int generarNumAleatorio(int min, int max){
        int num= (int)(Math.random()*(min-(max+1))+(max+1));
        return num;
    }
    //Metodo para generar nombres de forma aleatoria.
    public static final String nombres[] = {"Fernando", "Laura", "Pepe", "Eufrasio"};

}
