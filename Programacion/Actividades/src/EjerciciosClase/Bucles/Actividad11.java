package EjerciciosClase.Bucles;


import java.util.Scanner;
public class Actividad11 {
    public static void start() {

        //Declaramaos las variables a usar e instanciamos la variable scanner.
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int[] cuadrados = new int[5];
        int[] cubos = new int[5];
        int num;

        //Declaramos un bucle do/while para pedir los datos y hacer los calculos necesarios.
        for (int i = 0; i < nums.length ; i++) {
            System.out.println("Por favor introduce un valor entero");
            num = sc.nextInt();
            nums[i] = num;
            cuadrados[i] = nums[i]*nums[i];
            cubos[i] = nums[i]*nums[i]*nums[i];
        }
        //Imprimimos por pantalla el resultado.
        System.out.println("Los numeros son:");
        for (int j = 0; j<nums.length; j++){
            System.out.println(nums[j]+"\t"+cuadrados[j]+"\t"+cubos[j]);
        }
        System.out.println("Adios");
    }
}
