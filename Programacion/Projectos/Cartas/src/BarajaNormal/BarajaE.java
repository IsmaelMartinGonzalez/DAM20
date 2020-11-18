package BarajaNormal;

/**
 * Project name: DAM20/BarajaNormal
 * Filename: Faraja Francesa
 * Created:  18/11/2020 / 11:49
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.0
 */
public class BarajaE extends Baraja{
//Attriubutes
    private  boolean bCompleta;
//Builder
public BarajaE(boolean bCompleta){
    super();
    this.bCompleta=bCompleta;
    if (bCompleta){
        //Si se juega con la baraja completa, serian 48 cartas en la baraja y 12 cartas por tipo.
        this.numCartas=48;
        this.cartasPorTipo=12;
    }else {
        //Si se juega sin el 7 y el 8 serian 40 cartas en la baraja y 10 cartas por tipo.
        this.numCartas=40;
        this.cartasPorTipo=10;
    }
    crearBaraja(); //Creamos la baraja
    super.barajar();//Barajamos la baraja
}
//Getters/Setters
//Other Methods

    @Override
    public void crearBaraja() {
        this.cartas=(Carta<PalosE>[]) new Carta[numCartas];//Indicamos de que palos seran las coartas con (Carta<PalosE>[])...
        PalosE[] tipos=PalosE.values();

        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < cartasPorTipo; j++) {
                if (bCompleta){
                    cartas[i*cartasPorTipo+j]=new Carta(j+1, tipos[i]);
                }else {
                    if (!(j==7||j==8)){
                        if (j>=9){
                            cartas[i*(cartasPorTipo-2)+(j-2)]=new Carta(j+1, tipos[i]);
                        }else {
                            cartas[i*(cartasPorTipo-2)+j]=new Carta(j+1, tipos[i]);
                        }
                    }
                }
            }
        }
    }
}

