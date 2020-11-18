package BarajaNormal;
import Recursos.Numeros;
/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename: Baraja
 * Created:  14/11/2020 / 13:47
 * Description: Creamos una clase baraja para poder utilizarla de padre a la hora de crear barajas nuevas.
 * Revision: 1
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.1
 */
public abstract class Baraja<T> {
//Attributes
    protected Carta<T>[] cartas;
    protected int posSigCarta; //Indica la posición de la siguiente carta.
    protected int numCartas;
    protected int cartasPorTipo;
    //Builder
    public Baraja(){
        this.posSigCarta=0;
    }
//Getters/Setters
//Others Methods
    /*private void crearBaraja(){
        String[] tipos=Carta.TIPOS;
        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < Carta.LIMITE; j++) {
                if (!(j==7||j==8)){
                    if (j>=9){
                        cartas[i*(Carta.LIMITE-2)+(j-2)]=new Carta(j+1, tipos[i]);
                    }else {
                        cartas[i*(Carta.LIMITE-2)+j]=new Carta(j+1, tipos[i]);
                    }
                }
            }
        }
    }*/
    public abstract void crearBaraja();
    public void barajar(){
        int posAleatoria=0;
        Carta c;
        for (int i = 0; i < cartas.length; i++) {
            posAleatoria= Numeros.generaNumeroEnteroAleatorio(0,numCartas-1);
            c=cartas[i];
            cartas[i]=cartas[posAleatoria];
            cartas[posAleatoria]=c;
        }
        this.posSigCarta=0;
    }
    public  Carta repartir(){
        Carta c=null;
        if (posSigCarta==numCartas){
            System.out.println("Fin de la baraja, volver a barajar");
        }else {
            c=cartas[posSigCarta];
            posSigCarta++;
        }
        return c;
    }
    public Carta[] darCartas(int numCartas){
        if (numCartas>numCartas){
            System.out.println("No se puede dar mas cartas de las que hay");
        }else {
            if (cartasDisponibles() < numCartas){
                System.out.println("No hay suficientes cartas que mostrar");
            }else {
                Carta[] cartasDar = new Carta[numCartas];
                for (int i = 0; i < cartasDar.length; i++) {
                    cartasDar[i]=repartir();
                }
                return cartasDar;
            }
        }
        return null;
    }
    public  int cartasDisponibles(){
        return numCartas-posSigCarta;
    }
    public void mostrarBarja(){
        if (cartasDisponibles()==0){
            System.out.println("No hay mas cartas que mostrar");
        }else {
            for (int i = posSigCarta; i < cartas.length; i++) {
                System.out.println(cartas[i]);
            }
        }
    }
    public void mostrarMano(){
        if (cartasDisponibles()==numCartas){
            System.out.println("No hay ninguna mano");
        }else {
            for (int i = 0; i <posSigCarta; i++) {
                System.out.println(cartas[i]);
            }
        }
    }
}
