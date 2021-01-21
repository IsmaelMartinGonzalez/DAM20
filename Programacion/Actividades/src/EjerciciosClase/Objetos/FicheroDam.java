package EjerciciosClase.Objetos;

import java.io.*;
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
    BufferedReader br;
    BufferedWriter bw;

//Builder

    public FicheroDam() {
    }

    //Getters/Setters


    //Others Methods
    public void fichero(String nombre, String modo) throws IOException {
        if (modo.equals("Lectura")|| modo.equals("L")||modo.equals("lectura")||modo.equals("l")){
            br=new BufferedReader(new FileReader(nombre));
            System.out.print("Cuantas lineas deseas leer?: ");
            int numlineas=sc.nextInt();
            leer(numlineas);
        }else if (modo.equals("escritura")||modo.equals("Escritura")||modo.equals("E")||modo.equals("e")){
            bw=new BufferedWriter(new FileWriter(nombre));
            System.out.println("Que deseas escribir: ");
            String w=sc.next();
            escribir(w);
        }

    }
    public boolean escribir(String text) throws IOException {
        bw.write(text);
        bw.newLine();
        return true;
    }
    public void leer(int numlineas) throws IOException {
        String linea=br.readLine();
        for (int i = 0; i < numlineas; i++) {
            System.out.println(linea);
            linea=br.readLine();
        }
    }
}
