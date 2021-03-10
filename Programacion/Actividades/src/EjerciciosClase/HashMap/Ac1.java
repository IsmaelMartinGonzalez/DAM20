package EjerciciosClase.HashMap;

import java.util.HashMap;
import java.util.Map;
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
        String user;
        int pass;

        restringedArea.put(119,"PacoMartinezSoaria");
        restringedArea.put(67,"JoseMariaAznar");
        restringedArea.put(83,"JuanCarlos");

        while (!acces&&intentos>0){
            System.out.println("Por favor introduce tu usuario y contresña.");
            System.out.print("Usuario: ");
            user=sc.next();
            System.out.print("Contraseña: ");
            pass=sc.nextInt();
            for (Map.Entry c:restringedArea.entrySet()){
                if (c.getValue().equals(user)&&c.getKey().equals(pass)){
                    acces=true;
                }else {
                    intentos--;
                }
            }
            if (acces){
                System.out.println("Has accedido");
            }else if(intentos<=0){
                System.out.println("acceso denegado");
            }
        }

        System.out.println("Pedos saliste bien");
    }
}
