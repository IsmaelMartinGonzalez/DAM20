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
public class CotxeSegonaPart_ismael_martin extends Coche_Ismael_Martin implements InterfaceCocheSegonaPart_Ismael_Martin{

    //Attributes
    private Marchas marcha= Marchas.N;
    private  char cambio;
    private EstatsMotorCotxe estadoV = EstatsMotorCotxe.Quieto;
    private boolean descapotable;
    private boolean capota=false;

    //Builder
    /**
     * Costructor de la clase
     * @param marca
     * @param model
     * @param tipuscanvi
     */
    public CotxeSegonaPart_ismael_martin(String marca, String model, TipusCanvi tipuscanvi,boolean descapotable) {
        super(marca, model, tipuscanvi);
        this.descapotable=descapotable;
    }

    //Getters/Setters
    @Override
    public int getVelocidad() {
        int velocidad=0;
        if (estadoV.equals(EstatsMotorCotxe.Quieto)){
            velocidad=0;
        }else if (estadoV.equals(EstatsMotorCotxe.Acelerando)){
            velocidad=(int)((Math.random()*120)+1);
        }
        return velocidad;
    }

    //Others Methods
    public void CanviarMarxaAutomatic(char cambio) throws Exception{
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
                        System.out.println("Neutro");
                        this.marcha=Marchas.N;
                    }else {
                        System.out.println("Fast");
                        this.marcha=Marchas.F;
                    }
                }
                case '-'->{
                    if (marcha.equals(Marchas.R)){
                        System.out.println("No hay mas marchas");
                    }else if (marcha.equals(Marchas.F)){
                        System.out.println("Neutro");
                        this.marcha=Marchas.N;
                    }else {
                        System.out.println("Retrocediendo");
                        this.marcha=Marchas.R;
                    }
                }
            }
        }else {
            System.out.println("Tu coche no es automatico");
        }

    }
    public void CanviarMarxaManual(char cambio) throws Exception{
        if (tipuscanvi.equals(TipusCanvi.CanviManual)){
            if (cambio=='+'||cambio=='-'){
                this.cambio=cambio;
            }else {
                throw new Exception("Por favor elige solo '+' o '-' para poder cambiar las marchas.");
            }

            switch (this.cambio){
                case '+'->{
                    if (this.marcha.equals(Marchas.R)){
                        System.out.println("Neutro");
                        this.marcha=Marchas.N;
                    }else if (this.marcha.equals(Marchas.N)){
                        this.marcha=Marchas.m1;
                        System.out.println("Marcha "+ this.marcha);
                    }else if (marcha.equals(Marchas.m1)){
                        this.marcha=Marchas.m2;
                        System.out.println("Marcha "+ this.marcha);
                    }else if (marcha.equals(Marchas.m2)){
                        this.marcha=Marchas.m3;
                        System.out.println("Marcha "+ this.marcha);
                    }else if (marcha.equals(Marchas.m3)){
                        this.marcha=Marchas.m4;
                        System.out.println("Marcha "+ this.marcha);
                    }else if (marcha.equals(Marchas.m4)){
                        System.out.println("No hay mas marchas");
                    }
                }
                case '-'->{
                        if (marcha.equals(Marchas.m4)){
                            this.marcha=Marchas.m3;
                            System.out.println("Marcha "+ this.marcha);
                        }else if (marcha.equals(Marchas.m3)){
                            this.marcha=Marchas.m2;
                            System.out.println("Marcha "+ this.marcha);
                        }else if (marcha.equals(Marchas.m2)){
                            this.marcha=Marchas.m1;
                            System.out.println("Marcha "+ this.marcha);
                        }else if (marcha.equals(Marchas.m1)){
                            System.out.println("Neutro");
                            this.marcha=Marchas.N;
                        }else if (marcha.equals(Marchas.N)){
                            System.out.println("Retrocediendo");
                            this.marcha=Marchas.R;
                        }else if (this.marcha.equals(Marchas.R)){
                            System.out.println("No hay mas marchas");
                        }
                }
            }
        }else {
            System.out.println("Tu coche no es manual");
        }

    }
    @Override
    public void acelerar() {
        if (estado.equals(EstatsMotorCotxe.EnMarxa)){
            if (estadoV.equals(EstatsMotorCotxe.Acelerando)){
                System.out.println("Ya estas acelerando");
            }else {
                System.out.println("Acelerando");
                this.estadoV=EstatsMotorCotxe.Acelerando;
            }
        }else {
            System.out.println("Por favor arranca el coche para acelerar");
        }
    }
    @Override
    public void frenar() {
        if (estadoV.equals(EstatsMotorCotxe.Acelerando)){
            System.out.println("Frenando");
            this.estadoV=EstatsMotorCotxe.Quieto;
        }else {
            System.out.println("Por favor acelera primero");
        }
    }
    @Override
    public void quitarCapota() {
        if (descapotable){
            if (capota){
                System.out.println("La capota ya esta quitada");
            }else {
                System.out.println("Quitando capota");
                this.capota=true;
            }
        }else {
            System.out.println("El coche no es descapotable");
        }
    }
    @Override
    public void ponerCapota() {
        if (descapotable){
            if (!capota){
                System.out.println("La capota ya esta puesta");
            }else {
                System.out.println("Poniendo capota");
                capota=false;
            }
        }else {
            System.out.println("El coche no es descapotable");
        }
    }
}
