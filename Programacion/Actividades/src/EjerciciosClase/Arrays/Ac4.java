package EjerciciosClase.Arrays;

import java.util.ArrayList;
import java.util.Collections;
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
public class Ac4 {
    public static void main(String[] args) {
        ArrayList<String> words=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <= 10; i++) {
            System.out.print("Introduce un nombre: ");
            words.add(sc.next());
        }
        System.out.println(words);
        Collections.sort(words);
        System.out.println(words);
    }
}
