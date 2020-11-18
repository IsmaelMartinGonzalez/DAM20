package BarajaNormal;

/**
 * Project name: DAM20/Cartas/BarajaNormal
 * Filename: Carta
 * Created:  14/11/2020 / 13:47
 * Description: Creamos un objeto llmado carta para mas adelante poder crear una barja de objetos carta.
 *              Utilizaremos esta clase carta como padre paoder crear distintas Cartas.
 * Revision: 2
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.2
 */
public abstract class Carta<T> {
    //Attributes
    protected int valor;
    protected T tipo;

    //Builder
    public Carta(int valor, T palo){
        this.valor=valor;
        this.tipo=palo;
    }
    public Carta(){}
    //Getters/Setters
    public int getValor() {
        return valor;
    }
    public T getTipo() {
        return tipo;
    }
    //Others Methods
}
