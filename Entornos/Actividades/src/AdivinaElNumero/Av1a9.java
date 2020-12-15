package AdivinaElNumero;

import java.util.Scanner;
import java.util.SortedMap;

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
    String andmin;
    private int intento = 5;
    private int[] numIntentos=new int[5];
    private int numOculto;
    private int saldoUser=10;
    private int saldoGame=50;
    private String pass="GameOver";
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
        System.out.println("--------------------------------");
        System.out.println("Saldo inicial del jugador: "+saldoUser+"€\n" +
                "--------------------------------\n" +
                "¡Bienvenido a ADIVINA EL NUMERO!\n" +
                "--------------------------------\n" +
                "REGLAS:\n" +
                "El juego consiste en adivinar el numero dentro de un rango, para adivinarlo tendras 5 \n" +
                "intentos, tras los 5 intentos tendras que pagar un euro para recibir un intento extra.\n" +
                "Tras Adivinar el numero recibiras un premio segun el modo de juego selecionado,Ademas hay\n" +
                "un bonus si se adivina el numero a la primera. Para poder iniciar el juego por favor introduce \n" +
                "un euro.\n" +
                "--------------------------------");
        System.out.print("Esperando respuesta: ");
        user= sc.nextInt();
        if (user==1){
            saldoUser-=user;
            saldoGame+=user;
            System.out.println("Saldo del jugador: "+saldoUser+"€");
            while (!salir){
                System.out.print("¡Elige el modo de juego!\n" +
                        "Opcion 1: Adivina un numero entre el 1 y el 10\n" +
                        "Opcion 2: Adivina un numero entre el 1 y el 100\n" +
                        "Opcion 3: Salir\n" +
                        "Esperando respuesta: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1 ->{
                        System.out.println("Adivina el numero entre 1 y 10. Premio 3€. Bonus 5€");
                        System.out.println("----------------------");
                        try {
                            adivinaFacil();
                            salir=true;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2->{
                        System.out.println("Adivina el numero entre 1 y 100. Premio 5€. Bonus 10€\n" +
                                "Este modo de juego tiene una peuqeña ayuda.");
                        System.out.println("----------------------");
                        try {
                            adivinaDificil();
                            salir=true;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3->{
                        System.out.println("Para cerrar el juego introduce la contraseña.");
                        System.out.print("Esperando respuesta: ");
                        andmin=sc.next();
                        if (andmin.equals(pass)){
                            System.out.println("Saldo recogido de la maquina: "+saldoGame+"€");
                            salir=true;
                        }else {
                            System.out.println("Contraseña incorrecta.\n" +
                                    "----------------------");
                        }
                    }
                }
            }
        }else {
            System.out.println("Hay un error");
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
            if (intento==5){
                System.out.println("Bonus!");
                saldoUser+=5;
                saldoGame-=5;
                System.out.println("Salado del jugador: "+saldoUser+"€");
            }else {
                saldoUser+=3;
                saldoGame-=3;
                System.out.println("Salado del jugador: "+saldoUser+"€");
            }
        }else {
            String otra;
            System.out.println("----------------------");
            System.out.println("Game Over\n" +
                    "¿Deseas volver a intentarlo?");
            System.out.print("s/n: ");
            otra=sc.next();
            if (otra.equals("s")){

            }
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
                    if (user<numOculto){
                        System.out.println("El numero oculto es mayor de "+user);
                    }else if (user>numOculto){
                        System.out.println("El numero oculro es menor de "+user);
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
