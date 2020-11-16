import java.util.Scanner;
/*
 * Project name: ActividaesEntornos/PACKAGE_NAME
 * Filename: Actividad 2
 * Created:  12/11/2020 / 17:23
 * Description: Esta actividad es una continuación de la actividad anterior en la practicamos
 *              como hacer un menu sencillo.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Actividad2 {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;//Opcion elejida por el user

        while (!salir){
            System.out.println("Opcion 1: Crear ususario");
            System.out.println("Opcion 2: Buscar usuario");
            System.out.println("Opcion 3: Cambiar contraseña");
            System.out.println("Opcion 4: Dar de baja");
            System.out.println("Opcion 5: salir");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Creando!");
                    crearUser();
                }
                case 2 -> {
                    System.out.println("Buscando!");
                    buscarUser();
                }
                case 3 -> {
                    System.out.println("Cambiando!");
                    cambiarPass();
                }
                case 4 -> {
                    System.out.println("Baja!, no jhony!");
                    baja();
                }
                case 5 -> {
                    System.out.println("Adios");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 5");
            }
        }
    }

    private static void crearUser() {
        System.out.println("Estamos en ello, gracias por su atención");
    }
    private static void buscarUser() {

        System.out.println("Lugar en construcción");
    }
    private static void cambiarPass() {

        System.out.println("En breves te la cambiamos");
    }
    private static void baja() {

        System.out.println("Ha sido un placer jhony");
    }
}
