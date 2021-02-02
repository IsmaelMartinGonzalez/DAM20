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
    private int bola;

    //Builder

    public Maquina() {
        this.bolas = new ArrayList<>();
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
        int bola= Resources.generarNumAleatorio(1,99);
        for (int i = 0; i < bolas.size(); i++) {
            if (bola==bolas.get(i)){
                bola=Resources.generarNumAleatorio(1,99);
            }
        }
        setBola(bola);
        bolas.add(bola);
        return bola;
    }
    public boolean comprobarGanador(Cartulina jugador) {
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
    public  void jugar(){
        for (int i = 0; i < 99; i++) {
            generarBola();
            if (jugador.cartulinaLLena()){
                break;
            }
        }
        while (!jugador.cartulinaLLena()){
            generarBola();
            jugador.maracrCartulina(getBola());
        }
    }

}
