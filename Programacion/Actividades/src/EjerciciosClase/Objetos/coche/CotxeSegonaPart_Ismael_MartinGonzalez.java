package EjerciciosClase.Objetos.coche;

import EjerciciosClase.Objetos.coche.Marxes.*;
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

    //Getters/Setters
    public MarxesManual getMarxesManualActual() {
        return marxesManualActual;
    }

    public MarxesAutomatic getMarxesAutomaticActual() {
        return marxesAutomaticActual;
    }

    //Other Methods
    public void canviarMarxaAutomatic(MarxesAutomatic marxa) throws Exception {
        if (tipuscanvi.equals(TipusCanvi.CanviAutomatic)){
            if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)){
                switch (marxa){
                    case F -> {
                       if (marxesAutomaticActual.equals(MarxesAutomatic.F)||marxesAutomaticActual.equals(MarxesAutomatic.N)){
                           this.marxesAutomaticActual=MarxesAutomatic.F;
                       }else{
                           throw new Exception("Marxa incorrecta");
                       }
                    }
                    case N -> {
                        if (marxesAutomaticActual.equals(MarxesAutomatic.F)||marxesAutomaticActual.equals(MarxesAutomatic.R)||
                                marxesAutomaticActual.equals(MarxesAutomatic.N)){
                            this.marxesAutomaticActual=MarxesAutomatic.N;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case R -> {
                        if (marxesAutomaticActual.equals(MarxesAutomatic.N)||marxesAutomaticActual.equals(MarxesAutomatic.R)) {
                            this.marxesAutomaticActual =MarxesAutomatic.R;
                        }else {
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    default -> {
                        throw new Exception("Marxa incorrecta");
                    }
                }
            }else {
                throw  new Exception("El cotxe està aturat. No pots canviar de marxa");
            }
        }else {
            throw new Exception("Cotxe manual. No pots fer un canvi automàtic");
        }

    }
    public void canviarMarxaManual(MarxesManual marxa) throws Exception {
        if (tipuscanvi.equals(TipusCanvi.CanviManual)){
            if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)){
                switch (marxa){
                    case R -> {
                        if (marxesManualActual.equals(MarxesManual.N)|| marxesManualActual.equals(MarxesManual.R)){
                            this.marxesManualActual =MarxesManual.R;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case N ->{
                        if (marxesManualActual.equals(MarxesManual.G1)|| marxesManualActual.equals(MarxesManual.R)|| marxesManualActual.equals(MarxesManual.N)){
                            this.marxesManualActual =MarxesManual.N;
                        }else{
                            throw new Exception("Marxa incorrecta");

                        }
                    }
                    case G1 -> {
                        if (marxesManualActual.equals(MarxesManual.G2)|| marxesManualActual.equals(MarxesManual.N)|| marxesManualActual.equals(MarxesManual.G1)){
                            this.marxesManualActual =MarxesManual.G1;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G2 -> {
                        if (marxesManualActual.equals(MarxesManual.G3)|| marxesManualActual.equals(MarxesManual.G1)|| marxesManualActual.equals(MarxesManual.G2)){
                            this.marxesManualActual =MarxesManual.G2;
                        }else{
                            throw new Exception("Marxa incorrecta");

                        }
                    }
                    case G3 -> {
                        if (marxesManualActual.equals(MarxesManual.G4)|| marxesManualActual.equals(MarxesManual.G2)|| marxesManualActual.equals(MarxesManual.G3)){
                            this.marxesManualActual =MarxesManual.G3;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G4 -> {
                        if (marxesManualActual.equals(MarxesManual.G5)|| marxesManualActual.equals(MarxesManual.G3)|| marxesManualActual.equals(MarxesManual.G4)){
                            this.marxesManualActual =MarxesManual.G4;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G5 -> {
                        if (marxesManualActual.equals(MarxesManual.G4)|| marxesManualActual.equals(MarxesManual.G6)|| marxesManualActual.equals(MarxesManual.G5)){
                            this.marxesManualActual =MarxesManual.G5;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    case G6 -> {
                        if (marxesManualActual.equals(MarxesManual.G5)|| marxesManualActual.equals(MarxesManual.G6)){
                            this.marxesManualActual =MarxesManual.G6;
                        }else{
                            throw new Exception("Marxa incorrecta");
                        }
                    }
                    default -> {
                        throw new Exception("Marxa incorrecta");
                    }
                }
            }else{
                throw new Exception("El cotxe està aturat. No pots canviar de marxa");
            }
        }else {
            throw new Exception("Cotxe automàtic. No pots fer un canvi manual");
        }
    }

}
