package EjerciciosClase.Bucles;

import java.util.*;
public class Actividad8 {
    public static void start() {
        //Instanciamos el escaner para tomar datos por teclado
        Scanner sc = new Scanner(System.in);
        //Delcaramos las variables nuymero y control para poder sacar la tabla de multiplicar y tener un control de datos correcto.
        int numero;
        boolean control = false;
        //Pedimos los datos
        System.out.print("Porfavor introduce un valor de 0 a 9 ");
        numero=sc.nextInt();
        //Utilizamos una estructura de control compleja para poder sacar las tabals de multiplicar.
        do {
            switch (numero){
                case 0: for (int i = 0; i<=10; i++){
                        int tabla = numero*i;
                        System.out.println(tabla);
                    }
                    control = true;
                    break;
                case 1: for (int i=0; i<=10; i++){
                        int tabla = numero*i;
                        System.out.println(tabla);
                    }
                    control=true;
                    break;
                case 2: for (int i=0; i<=10; i++){
                        int tabla = numero*i;
                        System.out.println(tabla);
                    }
                    control = true;
                    break;
                case 3: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 4: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 5: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 6: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 7: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 8: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                case 9: for (int i=0; i<=10; i++){
                    int tabla = numero*i;
                    System.out.println(tabla);
                }
                    control = true;
                    break;
                default:
                    System.out.println("No sabes leer? Por favor introduce un valor entre 0 y 9");
                    numero=sc.nextInt();
                    break;
            }
        }while (!control);
    }
}
