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
        CotxeSegonaPart_ismael_martin c1= new CotxeSegonaPart_ismael_martin("Ferrari","G1",TipusCanvi.CanviManual,true);
        try {
            System.out.println(c1.comprovaMotor());
            c1.CanviarMarxaManual('+');
            System.out.println(c1.getMarcha());
            c1.frenar();
            c1.acelerar();
            c1.arrancarMotor();
            c1.CanviarMarxaManual('+');
            c1.acelerar();
            c1.CanviarMarxaManual('+');
            System.out.println("Velocidad: "+c1.getVelocidad()+"Km/h");
            c1.quitarCapota();
            c1.CanviarMarxaManual('+');
            c1.quitarCapota();
            c1.CanviarMarxaManual('-');
            c1.frenar();
            c1.CanviarMarxaManual('-');
            c1.frenar();
            c1.CanviarMarxaAutomatic('-');
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}