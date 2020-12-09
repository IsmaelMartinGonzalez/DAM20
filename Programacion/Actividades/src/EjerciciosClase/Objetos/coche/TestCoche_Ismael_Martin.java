package EjerciciosClase.Objetos.coche;
/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename: Test
 * Created:  03/12/2020 / 13:08
 * Description:
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
/**------------------------------------------------------------------------------------------*/
public class TestCoche_Ismael_Martin {

    /**
     * Desde nuestro mmain llamamos al menu para que comienze nuestro programa a trabajar
     */
    public static void main(String[] args) {
        Coche_Ismael_Martin c1= new Coche_Ismael_Martin("Ferrari","G1",TipusCanvi.CanviManual);
        try {
            System.out.println(c1.getRevolucions());
            System.out.println(c1.comprovaMotor());
            c1.arrancarMotor();
            System.out.println(c1.comprovaMotor());
            System.out.println(c1.getRevolucions());
            c1.aturarMotor();
            System.out.println(c1.comprovaMotor());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}