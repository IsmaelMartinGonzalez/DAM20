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
        boolean exit=false;
        Scanner sc =new Scanner(System.in);
        FicheroDam f=new FicheroDam();

      System.out.println("Por favor introduce la ruta del archivo: ");
      String ruta=sc.nextLine();
      f.fichero(ruta,"e");
        f.fichero(ruta,"e");
       /* while (!exit){
            System.out.println("1.Escritura\n" +
                    "2.Lectura\n" +
                    "3.Salir");
            System.out.print("Opcion: ");
            String modo= sc.nextLine();
            if (modo.equals("escritura")||modo.equals("Escritura")||modo.equals("lectura")||modo.equals("Lectura")||modo.equals("l")||modo.equals("e")){
                f.fichero(ruta,modo);
            }else if (modo.equals("Salir")||modo.equals("salir")||modo.equals("s")){
                exit=true;
            }else {
                System.out.println("Error. Vuelve a intentarlo");
            }
        }*/
    }
}
