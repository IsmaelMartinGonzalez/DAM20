package EjerciciosClase.Objetos;

/**
 * Project name: DAM20/EjerciciosClase.Objetos
 * Filename: Numeros Redondos
 * Created:  20/11/2020 / 10:57
 * Description: Actividad 2 de metodos en la que aprendemos a redondear numero decimales.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class NumRedondo {
    //Attriubutes
    double num=5.5678;
    //Builder
    public NumRedondo(){
    }
    //Getters/Setters

    public double getNum() {
        return num;
    }

    //Other Methods
    public void redondo(){
        double redodno= Math.floor(num+0.5);
        System.out.println("Numero antes del redondeo "+num+" numero despues "+redodno);
    }
    public void redondo2(){
        double roundToInteger= Math.floor(num);
        double roundToTenths= Math.floor(num*10)/10;
        double roundToHundredths= Math.floor(num*100)/100;
        double roundToThousandths= Math.floor(num*1000)/1000;
        System.out.println("Numero original "+num+"\nNumero redondeado "+roundToInteger+"\nNumero a las decimas "+roundToTenths
                +"\nNumero a las centenas "+roundToHundredths+"\nNumero a las milesimas "+roundToThousandths);
    }
}
