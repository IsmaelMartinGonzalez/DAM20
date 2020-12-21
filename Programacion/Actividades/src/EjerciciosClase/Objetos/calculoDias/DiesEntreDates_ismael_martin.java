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
    //Builder
    public DiesEntreDates_ismael_martin() {
    }

    //Getters/Setters
    //Other Methods
    /**Este metodo nos devolverá los dias que tiene un me concreto.*/
    @Override
    protected int diesMes(int mes) {
        int dias=0;
        switch (mes){
            case 1,3,5,7,8,10,12->{
                dias= 31;
            }
            case 2->{
                dias= 28;
            }
            case 4,6,9,11->{
                dias= 30;
            }
        }
        return dias;
    }

    /**Este metodo nos devolverá los dias que quedán hasta el final del mes de la fecha inicial.*/
    @Override
    protected int diesMesInicial(DataXS dataXS) {
        return diesMes(dataXS.mes)-dataXS.dia;
    }

    /**Este metodo nos devolverá los dias que han pasado desde el principo del mes hasta el dia 1 del mismo*/
    @Override
    protected int diesMesDesti(DataXS dataXS) {
        return dataXS.dia;
    }

    /**Este mestodo nos devolvera los dias que quedán hasta el final del año, contando desde un mes en adelante
     * desde el mes de la fecha inicial
     * Para calcular los dias que quedan hasta el final generamos un buble, que ira sumando los dias de los meses desde un
     * mes en adelante hasta el final del año.*/
    @Override
    protected int diesResteAnyInicial(DataXS datainicial) {
        int dias=0;
        for (int i = 1; i <= 12-datainicial.mes; i++) {
            dias+=diesMes(datainicial.mes+i);
        }
        return dias;
    }

    /**Este mestodo nos devolvera los dias que quedán hasta el principio del año, contando desde un mes hacia atras
     * desde el mes de la fecha de destino
     * Para calcular los dias hasta el principio del año generamos un buble en la que vamos sumando los dias del mes
     * hacia atras.*/
    @Override
    protected int diesResteAnyDesti(DataXS datadesti) {
        int dias=0;
        for (int i = 1; i <= (datadesti.mes-1); i++) {
            dias+=diesMes(datadesti.mes-i);
        }
        return dias;
    }

    /**Este metodo nos devolverá los dias que hay entre el año de inicio y el año de destino
     * Para calcular la cantid de dia que hay entre años al año de destino le restamos el año inicial y al resultado
     * le restamos uno*/
    @Override
    protected int diesNumAnysComplets(DataXS datainicial, DataXS datadesti) {
        return 365*((datadesti.any-datainicial.any)-1);
    }

    /**Este metodo nos devolverá los dias extra que hay en los años bisiestos, que haya entre las dos fechas.
     * Para calcular el dia extra de un año bisiesto llamamos a anyDeTraspas para comprobar si el año es bisiesto o no.*/
    @Override
    protected int numDiesPerAnysdeTraspas(DataXS datainicial, DataXS datadesti) {
        int diasExtra=0;
        for (int i = 0; i <= ((datadesti.any-datainicial.any)-1); i++) {
            if (anyDeTraspas(datainicial.any+i)){
                diasExtra++;
            }
        }
        if(anyDeTraspas(datadesti.any)){
            diasExtra++;
        }
        return diasExtra;
    }

    /**Este metodo comprobará si el año que le pasomos es bisiesto o no
     * Para calcular si un año es bisiesto o no, comprobamos si el año dividido entre 400 da un resto de 0 o si divido
     * entre 4 y 100 da un resto de 0.*/
    @Override
    protected boolean anyDeTraspas(int any) {
        return (any % 400 == 0) || ((any % 4 == 0) && !(any % 100 == 0));
    }
}
