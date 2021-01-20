package EjerciciosClase.Objetos;

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
public class FicheroDam {
//Attributes
    Scanner sc=new Scanner(System.in);
   private String fichero;
   private String modo;

//Builder

    public FicheroDam() {
    }

    //Getters/Setters
    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    //Others Methods
    public void fichero(String nombre, String modo){
        if (modo.equals("Lectura")|| modo.equals("L")||modo.equals("lectura")||modo.equals("l")){
            System.out.print("Cuantas lineas deseas leer?: ");
            int numlineas=sc.nextInt();
        }

    }
}
