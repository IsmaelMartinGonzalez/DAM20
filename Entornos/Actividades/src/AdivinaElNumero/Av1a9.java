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
    Scanner sc= new Scanner(System.in);
    int user;
    private int intento = 5;
    private int[] numIntentos=new int[5];
    private int numOculto;
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
    public int generarNumOculto1_10(){
        numOculto = (int)((Math.random()*10)+1);
        return numOculto;
    }
    public int generarNumOculto1_100(){
        numOculto = (int)((Math.random()*100)+1);
        return numOculto;
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        int opcion;
        boolean salir = false;
        System.out.println("¡Bienvenido a ADIVINA EL NUMERO!\n" +
                "El juego consiste en adivinar el numero dentro de un rango, para adivinarlo tendras 5 \n" +
                "intentos, tras los 5 intentos tendras que pagar un euro para recibir un intento extra.");
        while (!salir){
            System.out.print("¡Elige el modo de juego!\n" +
                    "Opcion 1: Adivina un numero entre el 1 y el 10\n" +
                    "Opcion 2: Adivina un numero entre el 1 y el 100\n" +
                    "Opcion 3: Salir\n" +
                    "Esperando respuesta: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("Adivina el numero entre 1 y 10");
                    System.out.println("----------------------");
                    try {
                        adivinaFacil();
                        salir=true;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2->{
                    System.out.println("Adivina el numero entre 1 y 100");
                    System.out.println("----------------------");
                    try {
                        adivinaDificil();
                        salir=true;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }

            }
        }

    }

    private void adivinaFacil() throws Exception{
        generarNumOculto1_10();
        do {
            System.out.print("Espereando respuesta:");
            user=sc.nextInt();
            if (user>=1&&user<=10){
                if (user==numOculto){
                    System.out.println("Correcto!");
                }else {
                    numIntentos[intento-1]=user;
                    System.out.println("Nope vuelve a intentarlo");
                    intento--;
                    System.out.println("Te quedan "+intento+" intentos");
                }
            }else {
                throw new Exception("Error. Por favvor introduce un numero entre 1 y 10");
            }
        }while (!(user==numOculto)&&!(intento==0));
        if (user==numOculto){
            System.out.println("----------------------");
            System.out.println("Enhorabuena has ganado");
        }else {
            System.out.println("----------------------");
            System.out.println("Game Over");
            System.out.println("Numero oculto: "+getNumOculto());
            System.out.print("Tus numeros han sido: ");
            for (int i = 0; i < numIntentos.length; i++) {
                System.out.print(numIntentos[i]+"\t");
            }
        }
    }

    private void adivinaDificil() throws Exception {
        generarNumOculto1_100();
        do {
            System.out.print("Espereando respuesta:");
            user=sc.nextInt();
            if (user>=1&&user<=100){
                if (user==numOculto){
                    System.out.println("Correcto!");
                }else {
                    numIntentos[intento-1]=user;
                    System.out.println("Nope vuelve a intentarlo");
                    intento--;
                    System.out.println("Te quedan "+intento+" intentos");
                    if (numOculto<=100&&numOculto>=75){
                        System.out.println("El numero oculto es mayor de 75");
                    }else if (numOculto<=75&&numOculto>=50){
                        System.out.println("El numero oculto es mayor de 50");
                    }else if (numOculto<=50&&numOculto>25){
                        System.out.println("El numero oculto es mayor de 25");
                    }else if (numOculto<=25&&numOculto>=1){
                        System.out.println("El numero es menor de 25");
                    }else {
                        System.out.println("Ismael revisa los calculos");
                    }
                }
            }else {
                throw new Exception("Error. Por favvor introduce un numero entre 1 y 100");
            }
        }while (!(user==numOculto)&&!(intento==0));
        if (user==numOculto){
            System.out.println("----------------------");
            System.out.println("Enhorabuena has ganado");
        }else {
            System.out.println("----------------------");
            System.out.println("Game Over");
            System.out.println("Numero oculto: "+getNumOculto());
            System.out.print("Tus numeros han sido: ");
            for (int i = 0; i < numIntentos.length; i++) {
                System.out.print(numIntentos[i]+"\t");
            }
        }
    }

}
