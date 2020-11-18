package BarajaNormal;

import Enumerados.PalosE;

/**
 * Project name: DAM20/BarajaNormal
 * Filename: Carta de baraja Española
 * Created:  18/11/2020 / 14:39
 * Description: Creamos un objeto hijo de carta Que sera una carta de la baraja es
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class CartaE extends Carta<PalosE>{
    //Attriubutes

    //Builder
    public  CartaE(int valor, PalosE tipo){
        super(valor, tipo);
    }
    public CartaE(){}
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
                case 10:
                    nombreFigura="Sota";
                    break;
                case 11:
                    nombreFigura="Caballo";
                    break;
                case 12:
                    nombreFigura="Rey";
                    break;
                default:
                    nombreFigura=valor+"";
            }
        estado=nombreFigura+" de "+ tipo;
        return estado;
    }
}
