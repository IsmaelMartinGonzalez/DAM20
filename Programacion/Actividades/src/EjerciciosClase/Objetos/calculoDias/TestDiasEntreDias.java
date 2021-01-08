package EjerciciosClase.Objetos.calculoDias;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.calculoDias
 * Filename:
 * Created:  15/12/2020 / 10:43
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class TestDiasEntreDias {
    public static void main(String[] args) {
        DiesEntreDates_ismael_martin d1 = new DiesEntreDates_ismael_martin();
        try {
            DataXS fechaInicial = new DataXS("01/03/2014");
            DataXS fechaFinal= new DataXS("28/04/2014");
            System.out.println(d1.nombreDiesTotals(fechaInicial,fechaFinal));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
