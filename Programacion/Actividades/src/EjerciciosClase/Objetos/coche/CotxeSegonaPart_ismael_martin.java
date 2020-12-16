package EjerciciosClase.Objetos.coche;

/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename: Coche segunda parte
 * Created:  14/11/2020 / 13:47
 * Description: Actividad
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class CotxeSegonaPart_ismael_martin extends Coche_Ismael_Martin{

    //Attributes
    private enum EstadoCoche{ Acelerando,Quieto}
    private enum Marchas{ F,N,R,m1,m2,m3,m4}
    private Marchas marcha= Marchas.N;
    private  char cambio;
    private EstadoCoche estadoV = CotxeSegonaPart_ismael_martin.EstadoCoche.Quieto;
    private boolean descapotable;
    private boolean capota=false;

    //Builder
    /**
     * Costructor de la clase. Añadimos un nuevo parametro para indicar si el el coche es descapotable.
     */
    public CotxeSegonaPart_ismael_martin(String marca, String model, TipusCanvi tipuscanvi,boolean descapotable) {
        super(marca, model, tipuscanvi);
        this.descapotable=descapotable;
    }

    //Getters/Setters
    public Marchas getMarcha() {
        return marcha;
    }
    public char getCambio() {
        return cambio;
    }
    public EstadoCoche getEstadoV() {
        return estadoV;
    }
    public boolean isDescapotable() {
        return descapotable;
    }
    public boolean isCapota() {
        return capota;
    }
    /**Devuelve un numero aleatorio entre 1 y 120*/
    public int getVelocidad() {
        int velocidad=0;
        if (estadoV.equals(EstadoCoche.Quieto)){
            velocidad=0;
        }else if (estadoV.equals(EstadoCoche.Acelerando)){
            velocidad=(int)((Math.random()*120)+1);
        }
        return velocidad;
    }

    //Others Methods
    /** Metodo cambiar marcha automatica, permite cambiar de marcha si el coche es automatico y esta el motor encendido.
     * En caso de no estar encendido se lanzara un mensaje indicando que se a de encender el motor.
     * El metodo lanzara una excepción si no se introduce el caracter correcto, '+' o '-', para cambiar de marcha.
     * En caso de no ser automatico y cambiar de marcha se lanzara una excepción indicando que no lo es.*/
    public void CanviarMarxaAutomatic(char cambio) throws Exception{
        if (estado.equals(EstatsMotorCotxe.EnMarxa)){
            if (tipuscanvi.equals(TipusCanvi.CanviAutomatic)){
                if (cambio=='+'||cambio=='-'){
                    this.cambio=cambio;
                }else {
                    throw new Exception("Por favor elige solo '+' o '-' para poder cambiar las marchas.");
                }
                switch (this.cambio){
                    case '+'->{
                        if (marcha.equals(Marchas.F)){
                            System.out.println("No hay mas marchas");
                        }else if (marcha.equals(Marchas.R)){
                            this.marcha=Marchas.N;
                        }else {
                            this.marcha=Marchas.F;
                        }
                    }
                    case '-'->{
                        if (marcha.equals(Marchas.R)){
                            System.out.println("No hay mas marchas");
                        }else if (marcha.equals(Marchas.F)){
                            this.marcha=Marchas.N;
                        }else {
                            this.marcha=Marchas.R;
                        }
                    }
                }
            }else {
                throw new Exception("Tu coche no es automatico");
            }
        }else {
            System.out.println("Por favor arranca el coche");
        }


    }

    /** Metodo cambiar marcha manualmente, permite cambiar de marcha si el coche es manual y esta el motor encendido.
     * En caso de no estar encendido se lanzara un mensaje indicando que se a de encender el motor.
     * El metodo lanzara una excepción si no se introduce el caracter correcto, '+' o '-', para cambiar de marcha.
     * En caso de no ser manual y cambiar de marcha se lanzara una excepción indicando que no lo es.*/
    public void CanviarMarxaManual(char cambio) throws Exception{
        if (tipuscanvi.equals(TipusCanvi.CanviManual)){
            if (estado.equals(EstatsMotorCotxe.EnMarxa)){
                if (cambio=='+'||cambio=='-'){
                    this.cambio=cambio;
                }else {
                    throw new Exception("Por favor elige solo '+' o '-' para poder cambiar las marchas.");
                }

                switch (this.cambio){
                    case '+'->{
                        if (this.marcha.equals(Marchas.R)){
                            this.marcha=Marchas.N;
                        }else if (this.marcha.equals(Marchas.N)){
                            this.marcha=Marchas.m1;
                        }else if (marcha.equals(Marchas.m1)){
                            this.marcha=Marchas.m2;
                        }else if (marcha.equals(Marchas.m2)){
                            this.marcha=Marchas.m3;
                        }else if (marcha.equals(Marchas.m3)){
                            this.marcha=Marchas.m4;
                        }else if (marcha.equals(Marchas.m4)){
                            System.out.println("No hay mas marchas");
                        }
                    }
                    case '-'->{
                        if (marcha.equals(Marchas.m4)){
                            this.marcha=Marchas.m3;
                        }else if (marcha.equals(Marchas.m3)){
                            this.marcha=Marchas.m2;
                        }else if (marcha.equals(Marchas.m2)){
                            this.marcha=Marchas.m1;
                        }else if (marcha.equals(Marchas.m1)){
                            this.marcha=Marchas.N;
                        }else if (marcha.equals(Marchas.N)){
                            this.marcha=Marchas.R;
                        }else if (this.marcha.equals(Marchas.R)){
                            System.out.println("No hay mas marchas");
                        }
                    }
                }
            }else {
                System.out.println("Por favor arranca el motor");
            }
        }else {
            throw  new Exception("Tu coche no es manual");
        }
    }

    /** El metodo acelerar permite acelerar el coche si el motor esta encencido.
     * En caso de no estar encendido el coche se lanzara un mensaje que advertira de que se debe encender antes de acelerar
     * En caso de estar ya en el estado acelerando se lanzara un mensaje indicando que ya estas acelerando.*/
    public void acelerar() {
        if (estado.equals(EjerciciosClase.Objetos.coche.EstatsMotorCotxe.EnMarxa)){
            if (estadoV.equals(EstadoCoche.Acelerando)){
                System.out.println("Ya estas acelerando");
            }else {
                this.estadoV= EstadoCoche.Acelerando;
            }
        }else {
            System.out.println("Por favor arranca el coche para acelerar");
        }
    }

    /** El metodo frenar frenara el coche hasta 0 si el coche se encuentra acelerando.
     * En caso de no estar acelerando se lanzara un mensaje indicando que hay que acelerar primero.*/
    public void frenar() {
        if (estadoV.equals(EstadoCoche.Acelerando)){
            this.estadoV= EstadoCoche.Quieto;
        }else {
            System.out.println("Por favor acelera primero");
        }
    }

    /** El metodo quitar capota permite quitar la capota del coche en el caso de que el coche sea descapotable.
     * En caso de no serlo se lanzara un mensaje indicando que no es descapotable.*/
    public void quitarCapota() {
        if (descapotable){
            if (capota){
                System.out.println("La capota ya esta quitada");
            }else {
                this.capota=true;
            }
        }else {
            System.out.println("El coche no es descapotable");
        }
    }

    /** El metodo poner capota permite ponr la capota del coche en el caso de que el coche sea descapotable.
     * En caso de no serlo se lanzara un mensaje indicando que no es descapotable.*/
    public void ponerCapota() {
        if (descapotable){
            if (!capota){
                System.out.println("La capota ya esta puesta");
            }else {
                capota=false;
            }
        }else {
            System.out.println("El coche no es descapotable");
        }
    }
}
