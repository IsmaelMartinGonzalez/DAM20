package EjerciciosClase.Objetos.Parking;

import java.util.Scanner;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.Parking
 * Filename:ParkingTest_FcoIsmael_MartinGonzalez
 * Created:  22/01/2021 / 18:23
 * Description:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class ParkingTest_FcoIsmael_MartinGonzalez {
    //Hay que crear una estructura de la bandera para generar un menu que permita llamar a los metodos de la clase Parking
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String user;
        String path;
        //Comprobamos si hay algo en el arry de args, en caso contrario igualamos a null el path
        if (args.length<1){
            path=args[0];
        }else {
            path=null;
        }
        //Instanciamos un objeto de nuestra clase parking.
        Parking_FcoIsmael_MartinGonzalez p=new Parking_FcoIsmael_MartinGonzalez(50,50);

       boolean exit=false;
        //Generamos un menu que se ira ejecuntando hasta que el usuario desee.
        while (!exit){
            System.out.println("----------------------\n"
                    +"1.Omplir parking a partir de fitxer");
            System.out.println("2.Entrar coche");
            System.out.println("3.Entrar coche Discapacitado");
            System.out.println("4.Salir Coche");
            System.out.println("5.Salir Coche Discapacitado");
            System.out.println("6.Guardar Matricula");
            System.out.println("7.Salir\n"+
                    "----------------------");
            System.out.print("Opcion: ");
            int opcion=sc.nextInt();
            try {
                switch (opcion){
                    case 1->{
                        if (path!=null){
                            p.llegirMatricules(path);
                        }else {
                            System.out.print("Path: ");
                            user=sc.next();
                            p.llegirMatricules(user);
                        }
                    }
                    case 2->{
                        System.out.print("Matricula: ");
                        String m=sc.next();
                        p.entraCotxe(m);
                    }
                    case 3->{
                        System.out.print("Matricula: ");
                        String m=sc.next();
                        p.entraCotxeDiscapacitat(m);
                    }
                    case 4->{
                        System.out.print("Matricula: ");
                        String m=sc.next();
                        p.surtCotxe(m);
                    }
                    case 5->{
                        System.out.print("Matricula: ");
                        String m=sc.next();
                        p.surtCotxeDiscapacitat(m);
                    }
                    case 6->{
                        System.out.print("Path: ");
                        user=sc.next();
                        p.guardarMatricula(user);
                    }
                    case 7->{
                        exit=true;
                    }
                    default -> System.out.println("Error.Selecciona una opción entre 1 y 7");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}