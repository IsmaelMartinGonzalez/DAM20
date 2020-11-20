package Base;
import Pila.PilaDinamica;
import Recursos.numeros.Aleatorios;

import java.util.ArrayList;

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
    public Baraja() {
        this.cartas = new PilaDinamica<>();
        this.cartasMonton = new PilaDinamica<>();
    }
    //Others Methods
    public abstract void crearBaraja();
    public void barajar() {

        int posAleatoria = 0;
        T carta;

        while (!this.cartasMonton.isEmpty()) {
            this.cartas.push(this.cartasMonton.pop());
        }

        ArrayList<T> cartasBarajar = new ArrayList<>();

        while (!this.cartas.isEmpty()) {
            cartasBarajar.add(this.cartas.pop());
        }

        for (int i = 0; i < cartasBarajar.size(); i++) {

            do {
                posAleatoria = Aleatorios.generaNumeroAleatorio(0, cartasBarajar.size() - 1);
                carta = cartasBarajar.get(posAleatoria);
            } while (carta == null);

            this.cartas.push(carta);
            cartasBarajar.set(posAleatoria, null);

        }

    }
    public T siguienteCarta(boolean monton) {

        T carta = null;

        if (!this.cartas.isEmpty()) {
            carta = cartas.pop();
            if (monton) {
                this.cartasMonton.push(carta);
            }
        }

        return carta;

    }
    public ArrayList<T> darCartas(int numCartas, boolean monton) {

        if (numCartas > numCartas || cartasDisponible() < numCartas) {
            return null;
        } else {

            ArrayList<T> cartasDar = new ArrayList<>();

            //recorro el array que acabo de crear para rellenarlo
            for (int i = 0; i < numCartas; i++) {
                cartasDar.add(siguienteCarta(monton)); //uso el metodo anterior
            }

            //Lo devuelvo
            return cartasDar;

        }

    }
    public int cartasDisponible() {
        return this.cartas.size();
    }
    public void cartasMonton() {

        if (cartasDisponible() == numCartas) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            System.out.println(this.cartasMonton.toString());
        }

    }
    public void mostrarBaraja() {

        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            System.out.println(this.cartas.toString());
        }

    }
    public void agregarCartaMonton(T carta){
        this.cartasMonton.push(carta);
    }
}