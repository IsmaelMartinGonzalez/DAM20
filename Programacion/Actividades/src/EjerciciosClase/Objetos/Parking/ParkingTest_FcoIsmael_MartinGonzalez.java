package EjerciciosClase.Objetos.Parking;

import java.util.Scanner;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.Parking
 * Filename:
 * Created:  22/01/2021 / 18:23
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class ParkingTest_FcoIsmael_MartinGonzalez {
    //Hay que crear una estructura de la bandera para generar un menu que permita llamar a los metodos de la clase Parking
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String user;
        Parking_FcoIsmael_MartinGonzalez p=new Parking_FcoIsmael_MartinGonzalez(50,50);

        try{
            p.llegirMatricules(args[0]);
        }catch (Exception e){
            System.out.println(e);
        }
       boolean exit=false;
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
                        p.llegirMatricules(args[0]);
                    }
                    case 2->{
                        System.out.print("Matricula: ");
                        user=sc.next();
                        p.entraCotxe(user);
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
                        String path=sc.next();
                        p.guardarMatricula(path);
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










































