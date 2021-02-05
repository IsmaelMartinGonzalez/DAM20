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
        Juego j1=new Juego("Fallout New Vegas","Bethesda",10);
        Juego j2=new Juego("Mass Effect","EA",5);
        try {
            e.meterJuego(0,j1);
            e.meterJuego(1,j2);
            Juego j3=new Juego("Fallout 3","Bethesda",8);
            Juego j4=new Juego("Diablo 3","Blizard",7);
            Juego j5=new Juego("Dark Souls 3","FromSoftware ",9);
            e.meterJuego(2,j3);
            e.meterJuego(3,j4);
            e.meterJuego(4,j5);
            e.top10();
            e.sacarJuego(j3.getTitulo());
            e.verEstanteria();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
