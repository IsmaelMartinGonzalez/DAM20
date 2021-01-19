package AdivinaElNumero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project name: DAM20/AdivinaElNumero
 * Filename: Adivina el numero.
 * Created:  16/12/2020 / 6:57
 * Description: Esta clase consiste en crear un juego de azar en el que el ususario intenta adivinar un numero aleatorio
 * dentro de un rango. En caso de fallar se le pedira que eche otro euro para poder tener otro intento.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class AdivinaV1 {
    //Attriubutes
    Scanner sc = new Scanner(System.in);
    int attempts=5;
    ArrayList<Integer> numsPlayer=new ArrayList<>();
    int randomNum;
    int playerBalance=10;
    int gameBalance=50;
    int menuOption;
    int intputPlayer;

    //Builder
    public AdivinaV1() {
    }

    //Getters/Setters
    public Scanner getSc() {
        return sc;
    }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public ArrayList<Integer> getNumsPlayer() {
        return numsPlayer;
    }
    public void setNumsPlayer(ArrayList<Integer> numsPlayer) {
        this.numsPlayer = numsPlayer;
    }
    public int getRandomNum() {
        return randomNum;
    }
    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }
    public int getPlayerBalance() {
        return playerBalance;
    }
    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }
    public int getGameBalance() {
        return gameBalance;
    }
    public void setGameBalance(int gameBalance) {
        this.gameBalance = gameBalance;
    }
    public int getMenuOption() {
        return menuOption;
    }
    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }
    public int getIntputPlayer() {
        return intputPlayer;
    }
    public void setIntputPlayer(int intputPlayer) {
        this.intputPlayer = intputPlayer;
    }

    //Other Methods
    private int randomNum(){
        if (menuOption==1){
            randomNum = (int)((Math.random()*10)+1);
        }else{
            randomNum = (int)((Math.random()*100)+1);
        }
        return randomNum;
    }
    public void mainMenu(){
        boolean exit=false;
        while (!exit){
            if (playerBalance<10||playerBalance>10){
                playerBalance=10;
            }
            System.out.println("--------------------------------\n" +
                    "¡Bienvenido a ADIVINA EL NUMERO!\n" +
                    "--------------------------------\n" +
                    "REGLAS:\n" +
                    "El juego consiste en adivinar el numero dentro de un rango, para adivinarlo tendras 5 \n" +
                    "intentos, tras los 5 intentos tendras que pagar un euro para recibir un intento extra.\n" +
                    "Tras Adivinar el numero recibiras un premio segun el modo de juego selecionado,Ademas hay\n" +
                    "un bonus si se adivina el numero a la primera. Para poder iniciar el juego por favor introduce \n" +
                    "un euro.\n"
                    +"--------------------------------");
            System.out.print("Esperando respuesta: ");
            intputPlayer= sc.nextInt();
            if (intputPlayer==1){
                playerBalance--;
                gameBalance++;
                gameMenu();
            }else if(intputPlayer==0) {
                System.out.println("Ganancias de hoy: "+gameBalance+"€\n" +
                        "Adios");
                exit=true;
            }else {
                mainMenu();
            }
        }

    }
    private void gameMenu(){
            boolean exit=false;
            while (!exit){
                System.out.println("Saldo del jugador: "+playerBalance+"€\n"+
                        "¡Elige el modo de juego!\n" +
                        "Opcion 1: Adivina un numero entre el 1 y el 10\n" +
                        "Opcion 2: Adivina un numero entre el 1 y el 100\n" +
                        "Opcion 3: Salir");
                System.out.print("Esperando respuesta: ");
                menuOption=sc.nextInt();
                switch (menuOption){
                    case 1 ->{
                        System.out.println("Adivina el numero entre 1 y 10. Premio 3€. Bonus 5€");
                        System.out.println("----------------------");
                        try {
                            adivinaFacil();
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
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3->{
                        System.out.println("Saldo final: "+playerBalance+"€\n" +
                                "Hasta la proxima");
                        exit=true;

                    }
                }
            }

    }

    private void adivinaDificil() throws Exception {
        randomNum();
        boolean exit=false;
        if (attempts<5){
            attempts=5;
        }
        while (!exit){
            if (playerBalance<0){
                System.out.println("Te has quedado sin dinero");
                exit=true;
                mainMenu();
            }else {
                while (!(intputPlayer==randomNum)&&!(attempts==0)) {
                    System.out.print("Espereando respuesta:");
                    intputPlayer=sc.nextInt();
                    if (intputPlayer>=1&&intputPlayer<=100){
                        if (intputPlayer==randomNum){
                            endGame();
                            exit=true;
                        }else {
                            numsPlayer.add(intputPlayer);
                            attempts--;
                            System.out.println("Te quedan "+attempts+" intentos");
                            if (intputPlayer<randomNum){
                                System.out.println("El numero oculto es mayor de "+intputPlayer);
                            }else if (intputPlayer>randomNum){
                                System.out.println("El numero oculto es menor de "+intputPlayer);
                            }
                        }
                    }else {
                        throw new Exception("Error. Por favor introduce un numero entre 1 y 100");
                    }
                }
            }
            if (attempts==0){
                String retry;
                System.out.println("-----------------------------\n" +
                        "Has perdido, deseas volver a intentarlo?\n" +
                        "Paga 1€, en caso contrario pulsa n");
                System.out.print("(s/n): ");
                retry=sc.next();
                if (retry.equals("s")){
                    playerBalance--;
                    gameBalance++;
                    attempts++;
                }else {
                    exit=true;
                    endGame();
                }
            }
        }
    }
    private void adivinaFacil() throws Exception{
        randomNum();
        boolean exit=false;
        if (attempts<5){
            attempts=5;
        }
        while (!exit){
            if (playerBalance<0){
                System.out.println("Te has quedado sin dinero");
                exit=true;
                mainMenu();
            }else{
                while (!(intputPlayer==randomNum)&&!(attempts==0)) {
                    System.out.print("Espereando respuesta:");
                    intputPlayer=sc.nextInt();
                    if (intputPlayer>=1&&intputPlayer<=10){
                        if (intputPlayer==randomNum){
                            endGame();
                            exit=true;
                        }else {
                            numsPlayer.add(intputPlayer);
                            attempts--;
                            System.out.println("Te quedan "+attempts+" intentos");
                        }
                    }else {
                        throw new Exception("Error. Por favor introduce un numero entre 1 y 10");
                    }
                }
            }
            if (attempts==0){
                String retry;
                System.out.println("Has perdido, deseas volver a intentarlo?\n" +
                        "Paga 1€, en caso contrario pulsa n");
                System.out.print("(s/n): ");
                retry=sc.next();
                if (retry.equals("s")){
                    playerBalance--;
                    gameBalance++;
                    attempts++;
                }else {
                    exit=true;
                    endGame();
                }
            }
        }
    }
    private void endGame() {
        if (menuOption==1){
            if (intputPlayer==randomNum) {
                System.out.println("----------------------");
                System.out.println("Enhorabuena has ganado");
                if (attempts == 5) {
                    System.out.println("Bonus!");
                    playerBalance += 5;
                    gameBalance -= 5;
                } else {
                    playerBalance += 3;
                    gameBalance -= 3;
                }
            }else {
                System.out.println("----------------------");
                System.out.println("Game Over\n" +
                        "Numero oculto: "+getRandomNum());
                System.out.print("Tus numeros han sido: ");
                System.out.println(numsPlayer+"\t");
            }
        }else if (menuOption==2){
            if (intputPlayer==randomNum) {
                System.out.println("----------------------");
                System.out.println("Enhorabuena has ganado");
                if (attempts == 5) {
                    System.out.println("Bonus!");
                    playerBalance += 10;
                    gameBalance -= 10;
                } else {
                    playerBalance += 5;
                    gameBalance -= 5;
                }
            }else {
                System.out.println("----------------------");
                System.out.println("Game Over\n" +
                        "Numero oculto: "+getRandomNum());
                System.out.print("Tus numeros han sido: ");
                System.out.println(numsPlayer+"\t");
            }
        }

    }
}
