package EjerciciosClase.Objetos;
import java.util.Scanner;
/**
 * Project name: DAM20/EjerciciosClase.Objetos
 * Filename: Garaje
 * Created:  20/11/2020 / 9:39
 * Description: Esta es la primera actividad de metodos, en la que creamo una aplicación para calcular el precio total
 *              por estar estacionado en un garaje, siendo el minimi 2USD y el maximo 10 USD.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Garaje {
    //Attriubutes
    private double userHours;
    private Double charge;
    private String matricula;
    //Cosntants
    public static final double MINCHARGE = 2.00;
    public static final double MAXCHARGE = 10.00;
    public static final double EXTRACHARGE = 0.5;
    //Builder
    public Garaje(){}
    //Getters/Setters
    public double getCharge() {
        return this.charge;
    }
    public double getUserHours() {
        return this.userHours;
    }
    public void setUserHours(int sc) {
        this.userHours = sc;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String sc) {
        this.matricula = sc;
    }
    //Other Methods
    public double calculateChrages() {
        if (userHours <= 3) {
            charge = 2.0;
        } else if (userHours > 3 && userHours <= 24) {
            if (userHours <= 18) {
                charge = ((userHours - 3) * EXTRACHARGE) + MINCHARGE;
            } else if (userHours >= 19 && userHours <= 24) {
                charge = MAXCHARGE;
            }
        }else {
            System.out.println("El tiempo maximos es de 24 horas");
            charge=0.0;
        }
        return getCharge();
    }
    public String info(){
        String info ="Su matricula es "+getMatricula()+" tolat de horas estacionado "+getUserHours()+"\nTotal a pagar "+getCharge()+" USD";
        return info;
    }
}
/*
        Scanner sc = new Scanner(System.in);
        Garaje g = new Garaje();
        System.out.print("Introduce tu matricula");
        g.setMatricula(sc);
        System.out.println("Introduce las horas estacionadas");
        g.setUserHours(sc);
        g.calculateChrages();
        System.out.println(g.info());
        */
/*
* Scanner sc = new Scanner(System.in);
        Garaje[] personas= new Garaje[5];
        String matricula;
        int horas;

        for (int i = 0; i < personas.length; i++) {
            personas[i]=new Garaje();
            System.out.print("Introduce tu matricula");
            matricula=sc.next();
            personas[i].setMatricula(matricula);
            System.out.println("Introduce las horas estacionadas");
            horas=sc.nextInt();
            personas[i].setUserHours(horas);
            personas[i].calculateChrages();
        }

        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i].info());
        }
* */
