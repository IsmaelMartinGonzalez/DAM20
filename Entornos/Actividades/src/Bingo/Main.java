package Bingo;

/**
 * Project name: DAM20/Bingo
 * Filename:
 * Created:  02/02/2021 / 9:10
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Main {
    static Maquina m=new Maquina();
    static Cartulina p1 = new Cartulina("Juan");
    static Cartulina p2 = new Cartulina("Maria");

    public static void jugar(){
        intro();

        while (!p1.cartulinaLLena()&&!p2.cartulinaLLena()){
            m.generarBola();
            p1.maracrCartulina(m.getBola());
            p2.maracrCartulina(m.getBola());
        }

        System.out.println(m.getBolas());
        comprobarGanador();
    }

    private static void comprobarGanador() {
        if (p1.cartulinaLLena()){
            if (m.compararNumBola(p1)){
                System.out.println("Jugador 1 Gana!");
            }
        }

        if (p2.cartulinaLLena()){
            if (m.compararNumBola(p2)){
                System.out.println("Jugador 2 Gana!");
            }
        }
    }
    private static void intro(){
        System.out.println("Bingo!\n" +
                p1.toString()+"\n" +
                p2.toString());
    }

}
