package Bingo;

import java.util.ArrayList;

/**
 * Project name: DAM20/Bingo
 * Filename:
 * Created:  02/02/2021 / 9:10
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Maquina {
    //Attriubutes
    private ArrayList<Integer> bolas;
    int bola;

    //Builder

    public Maquina() {
        this.bolas = new ArrayList<Integer>(99);
    }

    //Getters/Setters

    public ArrayList<Integer> getBolas() {
        return bolas;
    }

    public void setBolas(ArrayList<Integer> bolas) {
        this.bolas = bolas;
    }

    public int getBola() {
        return bola;
    }

    public void setBola(int bola) {
        this.bola = bola;
    }

    //Other Methods
    public int generarBola(){
        this.bola =Resources.generarNumAleatorio(1,99);
        if (bolas.contains(this.bola)){
            generarBola();
        }else {
            bolas.add(bola);
            return bola;
        }
        return -1;
    }

    public boolean compararNumBola(Cartulina jugador) {
        int contador = 0;
        if (jugador.cartulinaLLena()) {
            for (int i = 0; i < bolas.size(); i++) {
                for (int j = 0; j < jugador.getCartulina().length; j++) {
                    if (jugador.getCartulina()[j] == bolas.get(i)) {
                        contador++;
                    }
                }
            }
            if (contador == 10) {
                return true;
            }
        }
        return false;
    }

}
