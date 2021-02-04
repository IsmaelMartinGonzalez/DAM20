package Estanteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename:
 * Created:  14/11/2020 / 13:47
 * Description:
 * Revision:
 */
public class Estanteria {
//Attributes
    ArrayList<Juego> estanteria;
//Builder

    public Estanteria() {
        this.estanteria = new ArrayList<Juego>(10);
        iniciarEstanteria();
    }

//Getters/Setters
//Others Methods
    private void iniciarEstanteria(){
        for (int i = 0; i < 10; i++) {
            estanteria.add(null);
        }
    }
    public void meterJuego(int posicion, Juego j) throws Exception {
        if (estanteria.contains(null)){
            if (estanteria.contains(j)){
                throw new Exception("El juego ya esta en la estanteria");
            }else {
                if (estanteria.get(posicion)==null){
                    estanteria.set(posicion,j);
                }else {
                    System.out.println("error");
                }
            }
        }else {
            throw new Exception("Estanteria Llena!");
        }
    }
    public void sacarJuego(int posicion, String j) throws Exception {
        if (estanteria.contains(j)){
            estanteria.set(posicion, null);
        }else {
            throw new Exception("El juego no esta en la estanteria");
        }
    }
    public void top10(){
        Juego[] top=new Juego[10];
        for (int i = 0; i < estanteria.size(); i++) {
            if (estanteria.get(i).calificación==10){
                top[i]=estanteria.get(i);
                Collections.sort();
            }
        }
    }
}
