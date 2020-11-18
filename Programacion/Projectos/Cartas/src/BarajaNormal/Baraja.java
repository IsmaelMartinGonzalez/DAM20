package BarajaNormal;
import Pila.PilaDinamica;
import Recursos.Numeros;
/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename: Baraja
 * Created:  14/11/2020 / 13:47
 * Description: Creamos una clase baraja para poder utilizarla de padre a la hora de crear barajas nuevas.
 *              Utilizamos Pilas dinamicas para la construcción de la s barajas.
 * Revision: 3
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.3
 */
public abstract class Baraja<T extends Carta> {
    //Attributes
    protected PilaDinamica<T> cartas;
    protected PilaDinamica<T> cartasMonton;
    protected int numCartas;
    protected int cartasPorTipo;
    //Builder
    public Baraja(){
        this.cartas=new PilaDinamica<>();
        this.cartasMonton=new PilaDinamica<>();
    }
    //Getters/Setters
    //Others Methods
    public abstract void crearBaraja();
    public void barajar(){
        int posAleatoria=0;
        Carta c;

        while (!this.cartasMonton.isEmpty()){
            this.cartas.push(this.cartas.pop());
        }

        Carta[] cartasBarajar=new  Carta[this.numCartas];
        int iCarta=0;
        while (!this.cartas.isEmpty()){
            cartasBarajar[iCarta]=this.cartas.pop();
            iCarta++;
        }

        for (int i = 0; i < cartasBarajar.length; i++) {
            do {
                posAleatoria= Numeros.generaNumeroEnteroAleatorio(0,numCartas-1);
                c=cartasBarajar[posAleatoria];
            }while (c==null);

            this.cartas.push((T) c);
            cartasBarajar[posAleatoria]=null;
        }
    }
    public  Carta repartir(){
        Carta c=null;
        if (this.cartas.isEmpty()){
            System.out.println("Fin de la baraja, volver a barajar");
        }else {
            c=cartas.pop();
            this.cartasMonton.push((T) c);
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
        return cartas.size();
    }
    public void mostrarBarja(){
        if (cartasDisponibles()==0){
            System.out.println("No hay mas cartas que mostrar");
        }else {
            System.out.println(this.cartasMonton.toString());
        }
    }
    public void mostrarMano(){
        if (cartasDisponibles()==numCartas){
            System.out.println("No hay ninguna mano");
        }else {
            System.out.println(this.cartas.toString());
        }
    }
}