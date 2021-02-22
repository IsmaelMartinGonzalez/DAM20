package EjerciciosClase.Objetos.coche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename:
 * Created:  21/02/2021 / 17:34
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
class Coche_Ismael_MartinTest {

    @Test
    void arrancarMotor() {
    }

    @Test
    void comprovaMotor() {
        Coche_Ismael_Martin c= new Coche_Ismael_Martin("Ferrari","M80",TipusCanvi.CanviManual);
        assertEquals(EstatsMotorCotxe.Aturat,c.comprovaMotor());
    }

    @Test
    void getRevolucions() {
    }

    @Test
    void aturarMotor() {
    }
}