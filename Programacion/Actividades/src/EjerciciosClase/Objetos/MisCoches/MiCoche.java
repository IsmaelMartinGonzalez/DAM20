package EjerciciosClase.Objetos.MisCoches;

import EjerciciosClase.Objetos.coche.CotxeAbstracte;
import EjerciciosClase.Objetos.coche.EstatsMotorCotxe;
import EjerciciosClase.Objetos.coche.TipusCanvi;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename: Ejercicio de un coche
 * Created:  02/12/2020 / 17:44
 * Description: En este ejercicio practicamos la abstacción, la herencia, las interfaces y el uso de excepciones para
 *              nuestos programas.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class MiCoche extends CotxeAbstracte implements MiInterface {
    //Attriubutes
    private EstatsMotorCotxe estado= EstatsMotorCotxe.Aturat;
    private EstatsMotorCotxe velocidad=EstatsMotorCotxe.Quieto;
    private int vLimpia;
    private boolean descapotable;
    private boolean capota;
    private int opcion;

    //Builder
    /**Al constructos le añadimos un nuevo parametro que sera si el coches descapotable o no*/
    public MiCoche(String marca, String model, TipusCanvi tipuscanvi, boolean descapotable) {
        super(marca, model, tipuscanvi);
        this.descapotable=descapotable;
    }

    //Getters/Setters
    /**Introducimos la velocidad del limpia parabrisas que ha de ser un valor entero entre 0 y 3, siendo 0 apagado
     * y 3 la maxima velocidad*/
    public void setvLimpia(int vLimpia) throws Exception {
        if (vLimpia<0){
            throw new Exception("La velocidad ha de ser entre 0 y 3");
        }
        this.vLimpia = vLimpia;
    }
    /**Introducimos el aire que queremos usar. Siendo 0 apagado, 1 aire caliente y 2 aire frio*/
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    /**retornamos si el coche es descapotable o no*/
    public boolean getdescapotable() {
        return descapotable;
    }
    /**Retornamos el valor de la capota*/
    public boolean getcapota(){
        return capota;
    }

    //Other Methods
    /**Arrancamos el motor del coche*/
    public void arrancarMotor() throws Exception {
        if (estado.equals(EstatsMotorCotxe.EnMarxa)){
            throw new Exception("El motor ya esta encendido");
        }
        this.estado=EstatsMotorCotxe.EnMarxa;
    }
    /**Comprovamos si elestado del motor si esta encendidio o no*/
    public EstatsMotorCotxe comprovaMotor() {
        return estado;
    }
    /**Mostramos las revoluciones a las que va el motor*/
    public int getRevolucions() {
        int revoluciones=0;
        if (estado.equals(EstatsMotorCotxe.Aturat)){
            revoluciones=0;
        }else if (estado.equals(EstatsMotorCotxe.EnMarxa)){
            revoluciones= (int)(Math.random()*6500+1);
        }

        return revoluciones;
    }
    /**Apagamos el motor del coche*/
    public void aturarMotor() throws Exception {
        if (estado.equals(EstatsMotorCotxe.Aturat)){
            throw new Exception("El coche ya esta apagado");
        }
        this.estado=EstatsMotorCotxe.Aturat;
    }
    /**Comenzamos a mover el coche*/
    public void acelerar() throws Exception {
        if (velocidad.equals(EstatsMotorCotxe.Acelerando)){
            throw new Exception("Ya estas acelerando");
        }
        this.velocidad=EstatsMotorCotxe.Acelerando;
    }
    /**Paramos el coche, pero no el motor*/
    public void frenar() throws Exception {
        if (velocidad.equals(EstatsMotorCotxe.Quieto)){
            throw new Exception("No puedes frenar mas de lo que ya estas, por que ya estas quieto");
        }
        this.velocidad=EstatsMotorCotxe.Quieto;
    }
    /**Mostramos la velocidad a la que va el coche*/
    public int getVelocidad() {
        int velocidad=0;
        if (estado.equals(EstatsMotorCotxe.Aturat)){
            velocidad=0;
        }else if (estado.equals(EstatsMotorCotxe.EnMarxa)){
            velocidad= (int)(Math.random()*120+1);
        }

        return velocidad;
    }
    /**Añadomos la funcion encender el parabrisas y a que velocidad*/
    public void limiaParabrisas() throws Exception {
        if (vLimpia==0||vLimpia==1||vLimpia==2||vLimpia==3){
            switch (vLimpia){
                case 0:
                    System.out.println("Limpia parabisas apagado");
                    break;
                case 1:
                    System.out.println("Limpia parabrisas encendido. Velocidad 1");
                    break;

                case 2:
                    System.out.println("Limpia parabrisas encendido. Velocidad 2");
                    break;
                case 3:
                    System.out.println("Limpia parabrisas encendido. Velocidad 3. Maxima velocidad");
                    break;
            }
        }else {
            throw new Exception("El numero a de ser entero y entre 0 y 3 para poder usar el limpia parabrisas");
        }
    }
    /**Quitamos la capota del coche si es descapotable*/
    public void quitarCapota() throws Exception {
        if (descapotable){
            if (capota){
                throw new Exception("La capota ya esta quitada");
            }
            capota=true;
        }else {
            throw new Exception("El coche no es descapotable");
        }
    }
    /**Ponemos la capota del coche sie es descapotable*/
    public void ponerCapota() throws Exception {
        if (descapotable){
            if (!capota){
                throw new Exception("La capota ya esta puesta");
            }
            capota=false;
        }else {
            throw new Exception("El coche no es descapotable");
        }
    }
    /**Añadimos la funcion de poder encender y apagar elaire acondicionado*/
    public void aireAcondicionado() throws Exception {
        if (opcion==0||opcion==1||opcion==2){
            switch (opcion){
                case 0:
                    System.out.println("El aire acondicionado esta apagado");
                    break;
                case 1:
                    System.out.println("El aire caliente esta encendido");
                    break;
                case 2:
                    System.out.println("El aire frio esta encendido");
                    break;
            }
        }else {
            throw new Exception("El numero ha de ser entero y entre 0 y 2 para poder encender un aire");
        }

    }
}