package BarajaNormal;

/**
 * Project name: DAM20/Cartas/BarajaNormal
 * Filename: Carta
 * Created:  14/11/2020 / 13:47
 * Description: Creamos un objeto llmado carta para mas adelante poder crear una barja de objetos carta.
 *              Utilizaremos esta clase carta como padre paoder crear distintas barajs de cartas.
 * Revision: 1
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.1
 */
public class Carta<T> {
//Attributes
    private int valor;
    private T tipo;

//Builder
    public Carta(int valor, T palo){
        this.valor=valor;
        this.tipo=palo;
    }
//Getters/Setters
    public int getValor() {
        return valor;
    }
    public T getTipo() {
        return tipo;
    }

    //Others Methods
    @Override
    public String toString() {
        String estado="";
        String nombreFigura="";
        if (tipo.getClass().getSimpleName().equals("PalosE")){
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
        }else if (tipo.getClass().getSimpleName().equals("PalosF")){
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
        }

        estado=nombreFigura+" de "+ tipo;
        return estado;
    }
}
