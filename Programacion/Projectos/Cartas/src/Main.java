import BarajaNormal.*;
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
        //Ejecutar aqui las clsases
        BarajaF b = new BarajaF();
        System.out.println("Hay "+b.cartasDisponibles()+" cartas disponibles");
        b.repartir();
        b.darCartas(5);
        System.out.println("Hay "+b.cartasDisponibles()+" cartas disponibles");
        System.out.println("Castas sacadas de momento");
        b.mostrarMano();
    }
}
