package Estanteria;

import java.util.ArrayList;
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
    private ArrayList<Juego> estanteria;
//Builder

    public Estanteria() {
        this.estanteria = new ArrayList<Juego>(10);
        iniciarEstanteria();
    }

//Getters/Setters

    public ArrayList<Juego> getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(ArrayList<Juego> estanteria) {
        this.estanteria = estanteria;
    }

    //Others Methods
    private void iniciarEstanteria(){
        for (int i = 0; i < 10; i++) {
            estanteria.add(new Juego("","",0));
        }
    }
    public void meterJuego(int posicion, Juego j) throws Exception {
        if (estanteria.get(posicion).getCalificación()==0){
            if (estanteria.contains(j)){
                throw new Exception("El juego ya esta en la estanteria");
            }else {
                if (estanteria.get(posicion).getCalificación()==0){
                    estanteria.set(posicion,j);
                }else {
                    System.out.println("error");
                }
            }
        }else {
            throw new Exception("Estanteria Llena!");
        }
    }

    public void sacarJuego(String j) throws Exception {
        for (int i = 0; i < estanteria.size(); i++) {
            while (estanteria.get(i).getTitulo().equals(j)){
                estanteria.remove(i);
                estanteria.add(new Juego("","",0));
            }
        }
    }

    public void top10(){
        ArrayList<Juego> juegos15=new ArrayList<Juego>();
        for (int i = 0; i < estanteria.size(); i++) {
            juegos15.add(estanteria.get(i));
        }
        Collections.sort(juegos15);
        System.out.println("Top 10 juegos:");
        for (int i = 0; i < juegos15.size(); i++) {
            if (juegos15.get(i).getCalificación()==0){
                System.out.println("\tTop "+(i+1)+": Vacio");
            }else {
                System.out.println("\tTop "+(i+1)+": "+juegos15.get(i).getTitulo());
            }
        }
    }

    public void verEstanteria(){
        System.out.println("Mi estanteria de Juegos:");
        for (int i = 0; i < estanteria.size(); i++) {
            if (estanteria.get(i).getCalificación()==0){
                System.out.println("\tJuego: Vacio");
            }else{
                System.out.println("\tJuego "+(i+1)+"-> "+estanteria.get(i).toString());
            }
        }
    }

}
