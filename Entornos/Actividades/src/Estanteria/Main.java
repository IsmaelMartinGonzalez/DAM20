package Estanteria;

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
    public static void main(String[] args) {
        Estanteria e=new Estanteria();
        Juego j1=new Juego("FalloutNewVegas","Bethesda",10);
        Juego j2=new Juego("MassEffect","EA",5);
        Juego j3=new Juego("Fallout3","Bethesda",9);

        try {

        }catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("Fin!");
    }
}
