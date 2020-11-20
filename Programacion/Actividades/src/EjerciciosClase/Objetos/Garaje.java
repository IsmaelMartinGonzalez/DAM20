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
    private int userHours;
    private Double charge;
    private String matricula;
    //Cosntants
    public static final int MINCHARGE = 2;
    public static final int MAXCHARGE = 10;
    public static final Double EXTRACHARGE = 0.5;
    //Builder
    public Garaje(){}
    //Getters/Setters
    public Double getCharge() {
        return this.charge;
    }
    public int getUserHours() {
        return this.userHours;
    }
    public void setUserHours(Scanner sc) {
        this.userHours = sc.nextInt();
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(Scanner sc) {
        this.matricula = sc.next();
    }
    //Other Methods
    public double calculateChrages() {
        if (userHours <= 3) {
            charge = 2.0;
        } else if (userHours > 3 && userHours <= 24) {
            if (userHours <= 18) {
                charge = ((userHours - 3) * EXTRACHARGE) + MINCHARGE;
            } else if (userHours >= 19 && userHours <= 24) {
                charge = 10.0;
            }
        }else {
            System.out.println("El tiempo maximos es de 24 horas");
            charge=0.0;
        }
        return getCharge();
    }
    public String info(){
        String info ="Su matricula es "+getMatricula()+" tolat de horas estacionado "+userHours+"\nTotal a pagar "+getCharge()+" USD";
        return info;
    }
}
