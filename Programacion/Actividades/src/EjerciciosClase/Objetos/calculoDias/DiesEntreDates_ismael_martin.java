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
    int diasMes;
    int diasMesInicial;
    int diasMesDestio;
    int diasRestoAñoInicial;
    int diasRestoAñoDestino;
    boolean añoBisiesto;
    int diasAñosCompletos;
    int diasAñosBisiestos;
    //Builder
    public DiesEntreDates_ismael_martin() {
    }

    //Getters/Setters

    //Other Methods
    @Override
    protected int diesMes(int mes) {
        switch (mes){
            case 1,3,5,7,8,10,12->{
                this.diasMes= 31;
            }
            case 2->{
                this.diasMes=28;
            }
            case 4,6,9,11->{
                this.diasMes= 30;
            }
        }
        return this.diasMes;
    }

    @Override
    protected int diesMesInicial(DataXS dataXS) {
        diasMesInicial=diesMes(dataXS.mes)-dataXS.dia;
        return diasMesInicial;
    }

    @Override
    protected int diesMesDesti(DataXS dataXS) {
        int restoDia= diesMes(dataXS.mes)-dataXS.dia;
        diasMesDestio=diesMes(dataXS.mes)-restoDia;
        return diasMesDestio;
    }

    @Override
    protected int diesResteAnyInicial(DataXS datainicial) {

        for (int i = 0; i < 12-datainicial.mes; i++) {
            diasRestoAñoInicial+=diesMes(datainicial.mes+i);
        }
        return diasRestoAñoInicial;
    }

    @Override
    protected int diesResteAnyDesti(DataXS datadesti) {
        for (int i = 0; i < (datadesti.mes-1); i++) {
            diasRestoAñoDestino+=diesMes(datadesti.mes-i);
        }
        return diasRestoAñoDestino;
    }

    @Override
    protected int diesNumAnysComplets(DataXS datainicial, DataXS datadesti) {
        diasAñosCompletos=365*((datadesti.any-datainicial.any)-1);
        return diasAñosCompletos;
    }

    @Override
    protected int numDiesPerAnysdeTraspas(DataXS datainicial, DataXS datadesti) {
        for (int i = 0; i < ((datadesti.any-datainicial.any)-1); i++) {
            if (anyDeTraspas(datainicial.any+i)){
                diasAñosBisiestos++;
            }
        }
        return diasAñosBisiestos;
    }

    @Override
    protected boolean anyDeTraspas(int any) {
        if ((any % 400 == 0) || ((any % 4 == 0) && !(any % 100 == 0))){
            añoBisiesto= true;
        }else{
            añoBisiesto=false;
        }
        return añoBisiesto;
    }
}
