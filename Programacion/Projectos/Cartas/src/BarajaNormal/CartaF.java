package BarajaNormal;

import Enumerados.PalosE;
import Enumerados.PalosF;

/**
 * Project name: DAM20/BarajaNormal
 * Filename:
 * Created:  18/11/2020 / 14:39
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class CartaF extends Carta<PalosF> {
    //Attriubutes
    //Builder
    public  CartaF(int valor, PalosF tipo){
        super(valor, tipo);
    }
    public CartaF(){}
    //Getters/Setters
    //Other Methods
    @Override
    public String toString() {
        String estado="";
        String nombreFigura="";
        switch (valor){
            case 1:
                nombreFigura="AS";
                break;
            case 11:
                nombreFigura="Jack";
                break;
            case 12:
                nombreFigura="Reina";
                break;
            case 13:
                nombreFigura="Rey";
                break;
            default:
                nombreFigura=valor+"";
        }
        estado=nombreFigura+" de "+ tipo;
        return estado;
    }
    //Getters/Setters
    //Other Methods
}
