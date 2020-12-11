package AdivinaElNumero;

import java.util.Scanner;

/**
 * Project name: DAM20/AdivinaElNumero
 * Filename:
 * Created:  10/12/2020 / 20:46
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Av1a9 {
    //Attriubutes
    int intento;
    int[] numIntentos;
    int numOculto;
    private boolean Salir=false;

    //Builder
    public Av1a9() {
    }

    //Getters/Setters
    public void setIntento(int intento) {
        this.intento = intento;
    }
    public void setNumIntentos(int[] numIntentos) {
        this.numIntentos = numIntentos;
    }
    public int getIntento() {
        return intento;
    }
    public int[] getNumIntentos() {
        return numIntentos;
    }
    public int getNumOculto() {
        return numOculto;
    }

    //Other Methods
    public int generarNumOculto(){
        numOculto = (int)(Math.random()*10);
        return numOculto;
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        int opcion;
        System.out.println("¡Bienvenido a ADIVINA EL NUMERO!\n" +
                "El juego consiste en adivinar el numero dentro de un rango, para adivinarlo tendras 5 \n" +
                "intentos, tras los 5 intentos tendras que pagar un euro para recibir un intento extra.");
        while (Salir){
            System.out.print("¡Elige el modo de juego!\n" +
                    "Opcion 1: Adivina un numero entre el 1 y el 9\n" +
                    "Opcion 2: Adivina un numero entre el 1 y el 100\n" +
                    "Opcion 3: Salir\n" +
                    "Esperando respuesta: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("Adivina el numero entre 1 y 9");
                    adivinaFacil();
                }
                case 2->{
                    System.out.println("Adivina el numero entre 1 y 100");
                    adivinaDificil();
                }

            }
        }


    }

    private void adivinaDificil() {
    }

    private void adivinaFacil() {
    }

}
