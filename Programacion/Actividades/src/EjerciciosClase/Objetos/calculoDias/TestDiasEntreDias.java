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
            DataXS fechaInicial = new DataXS("15/07/1998");
            DataXS fechaFinal= new DataXS("14/08/2014");
            d1.nombreDiesTotals(fechaInicial,fechaFinal);
        }catch (Exception e){

        }

    }
}
