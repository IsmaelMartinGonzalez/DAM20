package EjerciciosClase.Objetos;

/**
 * Project name: DAM20/EjerciciosClase.Objetos
 * Filename:
 * Created:  20/11/2020 / 17:17
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Exponente {
    //Attriubutes
    int base;
    int exponente;
    //Builder
    public Exponente(int base, int exponente){
        if (base>0&&exponente>=0){
            for (int i = 0; i <exponente; i++) {
                base*=base;
            }
        }
    }
    //Getters/Setters

    public int getBase() {
        return base;
    }

    //Other Methods
}
