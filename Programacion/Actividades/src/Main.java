import EjerciciosClase.Objetos.FicheroDam;

import java.io.IOException;
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
public class Main {
    public static void main(String[] args) throws IOException {
        //Añadir clase
        Scanner sc =new Scanner(System.in);
        FicheroDam f=new FicheroDam();
      System.out.println("Por favor introduce la ruta del archivo: ");
        String ruta=sc.next();
        System.out.println("Por favor introduce si es lectura o escritura: ");
        String modo= sc.next();
        f.fichero(ruta,modo);
    }
}
