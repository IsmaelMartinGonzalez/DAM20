package EjerciciosClase.Condicionales;

/**
 * Project name: DAM20/EjerciciosClase.Condicionales
 * Filename:
 * Created:  24/11/2020 / 11:16
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Actividad20 {
    public static void start() {
        System.out.print("Per favor, introduiu un dia de la setmana (de dilluns a divendres): ");
        String dia = System.console().readLine();

        int nombreDeDia = 0;

        switch(dia) {
            case "dilluns":
                nombreDeDia = 0;
                break;
            case "dimarts":
                nombreDeDia = 1;
                break;
            case "dimecres":
                nombreDeDia = 2;
                break;
            case "dijous":
                nombreDeDia = 3;
                break;
            case "divendres":
                nombreDeDia = 4;
                break;
            default:
                System.out.print("El dia introduit no és correcte.");
        }

        System.out.println("A continuació introduiu l'hora (hora i minuts)");

        System.out.print("Hora: ");
        int hores = Integer.parseInt(System.console().readLine());

        System.out.print("Minuts: ");
        int minuts = Integer.parseInt(System.console().readLine());

        int minutsTotals = (4 * 24 * 60) + (15 * 60);
        int minutsActuals = (nombreDeDia * 24 * 60) + (hores * 60) + minuts;

        System.out.print("Falten " + (minutsTotals - minutsActuals) + " minuts per arribar al cap de setmana.");
    }
}
