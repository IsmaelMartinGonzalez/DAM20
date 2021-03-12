import java.util.Scanner;
/*
 * Project name: ActividaesEntornos/PACKAGE_NAME
 * Filename: Actividad 3
 * Created:  12/11/2020 / 17:35
 * Description: Ultima actividad de practicas de menus.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Actividad3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean salir = false;
        int opcion;//Opcion elejida por el user

        while (!salir){
            System.out.println("Opcion 1: Gestión de empledados");
            System.out.println("Opcion 2: Gestión de productos");
            System.out.println("Opcion 3: Gestión de compra/ventas");
            System.out.println("Opcion 4: salir");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Entrando en la gestion de RRHH!");
                    gRRHH();
                }
                case 2 -> {
                    System.out.println("Entrando en la gestion de productos!");
                    productos();
                }
                case 3 -> {
                    System.out.println("Entrando en la gestion de compra/ventas!");
                    compraVentas();
                }
                case 4 -> {
                    System.out.println("Adios");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 4");
            }
        }
    }
    private static void compraVentas() {
        boolean salir = false;
        int opcion;
        while (!salir){
            System.out.println("Opcion 1: Gestion de pedidios");
            System.out.println("Opcion 2: Ver estadisticas y graficos");
            System.out.println("Opcion 3: Volver");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Entrando en las gestiones!");
                    gestionPedidios();
                }
                case 2 -> {
                    System.out.println("Entrando en las estadisticas y graficos!");
                    estadisticas();
                }
                case 3 -> {
                    System.out.println("Volviendo!");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 5");
            }
        }
    }
    private static void productos() {
        boolean salir = false;
        int opcion;

        while (!salir){
            System.out.println("Opcion 1: Dar de alta un producto");
            System.out.println("Opcion 2: Modificar un producto");
            System.out.println("Opcion 3: Dar de baja un producto");
            System.out.println("Opcion 4: Volver al menu");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Dando de alta!");
                    crearProduct();
                }
                case 2 -> {
                    System.out.println("Cambiando producto!");
                    cambiarProduct();
                }
                case 3 -> {
                    System.out.println("Dando de baja!");
                    bajaProduct();
                }
                case 4 ->{
                    System.out.println("volviendo!");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 5");
            }
        }
    }
    private static void gRRHH() {
        boolean salir = false;
        int opcion;

        while (!salir){
            System.out.println("Opcion 1: Dar de alta un empleado");
            System.out.println("Opcion 2: Modificar un empleado");
            System.out.println("Opcion 3: Dar de baja un empledao, otravez no jhony...");
            System.out.println("Opcion 4: Volver al menu");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Dando de alta!");
                    crearUser();
                }
                case 2 -> {
                    System.out.println("Cambiando ususario!");
                    cambiarUser();
                }
                case 3 -> {
                    System.out.println("Baja, nooo!");
                    baja();
                }
                case 4 ->{
                    System.out.println("volviendo!");
                    salir = true;
                }
                default -> System.out.println("La opcion elejida no es correcta, animal. Por favor elije una opcion entre 1 y 5");
            }
        }
    }

    private static void crearUser() {
        System.out.println("Estamos en ello, gracias por su atención");

    }
    private static void cambiarUser() {

        System.out.println("En breves te la cambiamos");
    }
    private static void baja() {

        System.out.println("Ha sido un placer jhony");
    }
    private static void crearProduct() {
        System.out.println("Preducto añadidio");

    }
    private static void cambiarProduct() {
        System.out.println("Preoducto cambiado");

    }
    private static void bajaProduct() {
        System.out.println("Preoducto quitado");

    }
    private static void estadisticas() {
        System.out.println("Estadisticas y grafisoc, como si alguines se los viera XD");

    }
    private static void gestionPedidios() {
        System.out.println("Todo correcto y yo que me alegro");

    }
}
