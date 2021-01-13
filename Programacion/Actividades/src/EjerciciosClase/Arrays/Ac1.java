package EjerciciosClase.Arrays;

import java.util.ArrayList;

/**
 * Project name: DAM20/EjerciciosClase.Arrays
 * Filename:
 * Created:  13/01/2021 / 13:37
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Ac1 {
    public static void main(String[] args) {
        ArrayList<String> dam=new ArrayList<String>();
        dam.add("Ismael");
        dam.add("Adan");
        dam.add("Ivan");
        dam.add("Carlos");
        dam.add("Josh");
        dam.add("Miquel");
        for (int i = 0; i < dam.size(); i++) {
            System.out.println(dam.get(i));
        }
    }
}
