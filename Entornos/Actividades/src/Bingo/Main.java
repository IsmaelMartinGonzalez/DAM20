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
    public static void play() {
        Maquina m=new Maquina();
        Cartulina p1 = new Cartulina("Juan");
        Cartulina p2 = new Cartulina("Maria");
        p1.getCartulina();
        m.generarBola();
        m.getBola();
        p1.maracrCartulina(m.getBola());
        m.generarBola();
        m.comprobarGanador(p1);
        m.comprobarGanador(p2);
    }

}
