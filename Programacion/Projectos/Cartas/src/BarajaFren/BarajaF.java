package BarajaFren;
import Enumerados.PalosF;
import Base.*;
/**
 * Project name: DAM20/BarajaNormal
 * Filename: Baraja Francesa
 * Created:  18/11/2020 / 11:49
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.0
 */
public class BarajaF extends Baraja<CartaF>{
    //Attriubutes
    //Builder
    public BarajaF(){
        super();
        this.numCartas=52;
        this.cartasPorTipo=13;
        crearBaraja(); //Creamos la baraja
        super.barajar();//Barajamos la baraja
    }
    //Getters/Setters
    //Other Methods
    public boolean cartaRoja(Carta<PalosF> c){
        return c.getTipo()==PalosF.CORAZONES||c.getTipo()== PalosF.DIAMANTES;
    }
    public boolean cartaNegra(Carta<PalosF>c){
        return c.getTipo()==PalosF.TREBOLES||c.getTipo()== PalosF.PICAS;
    }

    @Override
    public void crearBaraja() {
        PalosF[] tipos=PalosF.values();

        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < cartasPorTipo; j++) {
                this.cartas.push(new CartaF(j+1, tipos[i]));
            }
        }
    }
}