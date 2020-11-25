package EjerciciosClase.Bucles;
import java.util.Scanner;
/**
 * Project name: DAM20/EjerciciosClase.Bucles
 * Filename:
 * Created:  24/11/2020 / 10:46
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Actividad19 {
    public static void start() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Alçada de la piràmeide: ");
        int alsada = Integer.parseInt(sc.nextLine());

        System.out.print("Caràcter per fer la piràmide: ");
        String farcit = sc.nextLine();

        int planta = 1;
        int longitudDeLinia = 1;
        int espais = alsada-1;

        while (planta <= alsada) {

            // insereix espais
            for (int i = 1; i <= espais; i++) {
                System.out.print(" ");
            }

            // pinta la linia
            for (int i = 1; i <= longitudDeLinia; i++) {
                System.out.print(farcit);
            }

            System.out.println();

            planta++;
            espais--;
            longitudDeLinia += 2;
        }
    }
}
