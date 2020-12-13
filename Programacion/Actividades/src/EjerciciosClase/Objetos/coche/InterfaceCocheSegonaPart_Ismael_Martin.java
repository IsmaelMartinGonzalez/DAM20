package EjerciciosClase.Objetos.coche;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename:
 * Created:  13/12/2020 / 9:18
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public interface InterfaceCocheSegonaPart_Ismael_Martin {
    /**
     * El metodo acelerar lanzara una excepcion si se intenta
     * acelerar el coche pero el coche ya esta acelerando.
     * @throws Exception
     * */
    public void acelerar() throws Exception;
    /**
     * El metodo frenar lanzara una excepcion si se intenta
     * frenar el coche pero el coche ya esta quieto.
     * @throws Exception
     * */
    public void frenar() throws  Exception;
    /**
     * El metodo getVelocidad() retornara un entero correspondiente
     * a las velocidades permtidas por trafico. Si el coche esta quieto retornara 0
     * Si el coche està en movimiento retornarà un numero aleatori entre 1 i 120
     * @return
     */
    public int getVelocidad();
    /**
     * El metodo limiaParabrisas lanzara una excepcion si la opcion de limpa parabrisas
     * no esta entre 0 y 3. Siendo 0 apagado y 3 la maxima velocidad del limpia parabrisas.
     * */
    public void quitarCapota() throws Exception;
    /**
     * El metodo ponerCapota lanzara una excepcion si se intenta
     * poner la capota del coche pero la capota ya esta puesta.
     * @throws Exception
     * */
    public void ponerCapota() throws  Exception;

}
