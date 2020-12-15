package EjerciciosClase.Objetos.calculoDias;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.calculoDias
 * Filename:
 * Created:  14/12/2020 / 12:13
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class DiesEntreDates_ismael_martin extends CalcularDiesEntreDates{
    //Attriubutes
    DataXS[] vvisiestos;
    //Builder
    public DiesEntreDates_ismael_martin() {
    }

    //Getters/Setters
    //Other Methods
    @Override
    protected int diesMes(int mes) {

        return 0;
    }

    @Override
    protected int diesMesInicial(DataXS dataXS) {
        return 0;
    }

    @Override
    protected int diesMesDesti(DataXS dataXS) {
        return 0;
    }

    @Override
    protected int diesResteAnyInicial(DataXS datainicial) {
        return 0;
    }

    @Override
    protected int diesResteAnyDesti(DataXS datadesti) {
        return 0;
    }

    @Override
    protected int diesNumAnysComplets(DataXS datainicial, DataXS datadesti) {
        return 0;
    }

    @Override
    protected int numDiesPerAnysdeTraspas(DataXS datainicial, DataXS datadesti) {
        return 0;
    }

    @Override
    protected boolean anyDeTraspas(int any) {
        return false;
    }
}
