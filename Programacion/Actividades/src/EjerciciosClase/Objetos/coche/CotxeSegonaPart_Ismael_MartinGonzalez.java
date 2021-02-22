package EjerciciosClase.Objetos.coche;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename:
 * Created:  21/02/2021 / 17:27
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class CotxeSegonaPart_Ismael_MartinGonzalez extends Coche_Ismael_Martin {


    //Attriubutes
    private MarxesAutomatic marxesAutomaticActual = MarxesAutomatic.N;
    private MarxesManual marxesManualActual = MarxesManual.N;

    //Builder
    public CotxeSegonaPart_Ismael_MartinGonzalez(String marca, String model, TipusCanvi tipuscanvi) {
        super(marca, model, tipuscanvi);
    }

    //Other Methods

    /**El metodo canviarMarxaAutomatic se encarga de cambiar de marcha en función de un parámetro que ha de ser de tipo MaxesAutomatic
     * Si el coche no es automático saltara una excepción -> "Cotxe manual. No pots fer un canvi automàtic"
     * Si el motor no esta encendido saltara una excepción -> "El cotxe està aturat. No pots canviar de marxa"
     * Si se introduce una marcha errornea saltara una excepción -> "Marxa incorrecta"
     * Si se intenta saltar de una marcha a otra no secuencial saltara una excepción -> "Marxa incorrecta"*/
    public void canviarMarxaAutomatic(MarxesAutomatic marxa) throws Exception {

        /*Comprobamos si el coche es automatico o no*/
        if (tipuscanvi.equals(TipusCanvi.CanviAutomatic)){

            /*Comprovamos si el coche esta encendido o no*/
            if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)){

                /*Indicamos como caso cada una de las marcha a introducir, en caso de una marcha erronea se lanza una excepción*/
                switch (marxa){
                    case F -> {

                        /*Si la marcha actual es F o N se cambia la marcha a F*/
                       if (marxesAutomaticActual.equals(MarxesAutomatic.F)||marxesAutomaticActual.equals(MarxesAutomatic.N)){
                           this.marxesAutomaticActual=MarxesAutomatic.F;
                       }else {
                           throw new Exception("Marxa incorrecta");
                       }
                    }
                    case N -> {

                        /*Si la marcha actual es F,N o R se cambia la marcha a N*/
                        if (marxesAutomaticActual.equals(MarxesAutomatic.F)||marxesAutomaticActual.equals(MarxesAutomatic.R)||
                                marxesAutomaticActual.equals(MarxesAutomatic.N)){
                            this.marxesAutomaticActual=MarxesAutomatic.N;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case R -> {

                        /*Si la marcha actual es R o N se cambia la marcha a R*/
                        if (marxesAutomaticActual.equals(MarxesAutomatic.N)||marxesAutomaticActual.equals(MarxesAutomatic.R)) {
                            this.marxesAutomaticActual =MarxesAutomatic.R;
                        }else {
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    default -> {

                     /*En caso de no poner ninguna de las marchas previstas se lanza una excepción*/
                        throw new Exception("Marxa incorrecta");
                    }
                }
            }else {

                /*Encaso de no esta el coche encendido se lanza una excepción*/
                throw  new Exception("El cotxe està aturat. No pots canviar de marxa");
            }
        }else {

            /*En caso de no ser un coche automatico se lanza una excepción*/
            throw new Exception("Cotxe manual. No pots fer un canvi automàtic");
        }
    }

    /**El metodo canviarMarxaManual se encarga de cambiar de marcha en función de un parámetro que ha de ser de tipo MarxesManual
     * Si el coche no es manual saltara una excepción -> "Cotxe automàtic. No pots fer un canvi manual"
     * Si el motor no esta encendido saltara una excepción -> "El cotxe està aturat. No pots canviar de marxa"
     * Si se introduce una marcha errornea saltara una excepción -> "Marxa incorrecta"
     * Si se intenta saltar de una marcha a otra no secuencial saltara una excepción -> "Marxa incorrecta"*/
    public void canviarMarxaManual(MarxesManual marxa) throws Exception {

        /*Comprobamos si el coche es manual o no*/
        if (tipuscanvi.equals(TipusCanvi.CanviManual)){

            /*Comrpobamos si el coche esta encendido o no */
            if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)){

                /*Indicamos como caso cada una de las marcha a introducir, en caso de una marcha erronea se lanza una excepción*/
                switch (marxa){
                    case R -> {

                        /*Si la marcha actual es N o R se cambia la marcha a R en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.N)|| marxesManualActual.equals(MarxesManual.R)){
                            this.marxesManualActual =MarxesManual.R;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case N ->{

                        /*Si la marcha actual es N,R o G1 se cambia la marcha a N en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G1)|| marxesManualActual.equals(MarxesManual.R)|| marxesManualActual.equals(MarxesManual.N)){
                            this.marxesManualActual =MarxesManual.N;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G1 -> {

                        /*Si la marcha actual es G1,G2 o N se cambia la marcha a G1 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G2)|| marxesManualActual.equals(MarxesManual.N)|| marxesManualActual.equals(MarxesManual.G1)){
                            this.marxesManualActual =MarxesManual.G1;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G2 -> {

                        /*Si la marcha actual es G2,G1 o G3 se cambia la marcha a G2 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G3)|| marxesManualActual.equals(MarxesManual.G1)|| marxesManualActual.equals(MarxesManual.G2)){
                            this.marxesManualActual =MarxesManual.G2;
                        }else{
                            throw new Exception("Marxa incorrecta");

                        }
                    }
                    case G3 -> {

                        /*Si la marcha actual es G3,G4 o G2 se cambia la marcha a G3 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G4)|| marxesManualActual.equals(MarxesManual.G2)|| marxesManualActual.equals(MarxesManual.G3)){
                            this.marxesManualActual =MarxesManual.G3;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G4 -> {

                        /*Si la marcha actual es G4,G3 o G5 se cambia la marcha a G4 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G5)|| marxesManualActual.equals(MarxesManual.G3)|| marxesManualActual.equals(MarxesManual.G4)){
                            this.marxesManualActual =MarxesManual.G4;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G5 -> {

                        /*Si la marcha actual es G5,G4 o G6 se cambia la marcha a G5 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G4)|| marxesManualActual.equals(MarxesManual.G6)|| marxesManualActual.equals(MarxesManual.G5)){
                            this.marxesManualActual =MarxesManual.G5;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G6 -> {

                        /*Si la marcha actual es G6 o G5 se cambia la marcha a G6 en caso contrario soltamos una excepción*/
                        if (marxesManualActual.equals(MarxesManual.G5)|| marxesManualActual.equals(MarxesManual.G6)){
                            this.marxesManualActual =MarxesManual.G6;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    default -> {

                        /*En caso de no introducir una marcha prevista se lanzará una exccepción*/
                        throw new Exception("Marxa incorrecta");
                    }
                }
            }else{

                /*En caso de no estar encendido el coche se lanzará una excepción*/
                throw new Exception("El cotxe està aturat. No pots canviar de marxa");
            }
        }else {

            /*En caso de no ser un coche manual se lanzará una excepción*/
            throw new Exception("Cotxe automàtic. No pots fer un canvi manual");
        }
    }

}
