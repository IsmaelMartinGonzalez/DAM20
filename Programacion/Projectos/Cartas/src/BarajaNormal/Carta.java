package BarajaNormal;

/**
 * Project name: DAM20/Cartas/BarajaNormal
 * Filename: Carta
 * Created:  14/11/2020 / 13:47
 * Description: Creamos un objeto llmado carta para mas adelante poder crear una barja de objetos carta.
 *              La baraja de ejmplo sera una baraja española, en la que quitaremos dos cartas la 8 y la 9
 *              por tanto tendremos una barja de 40 cartas.
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Carta {
//Attributes
    private int valor;
    private String palo;

    //Declaramos una constante de palos para una baraja española
    public static final String[] PALOS={"ESPADAS", "BASTOS", "OROS","COPAS"};
//Builder
    public Carta(int valor, String palo){
        this.valor=valor;
        this.palo=palo;
    }
//Getters/Setters
//Others Methods
    @Override
    public String toString(){
        return "valor=" + valor + ", palo=" + palo;
    }
}
