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
    private Marchas marcha= Marchas.N;
    private  char cambio;

//Builder
    /**
     * Costructor de la clase
     * @param marca
     * @param model
     * @param tipuscanvi
     */
    public CotxeSegonaPart_ismael_martin(String marca, String model, TipusCanvi tipuscanvi) {
        super(marca, model, tipuscanvi);
    }
//Getters/Setters
//Others Methods
    public void CanviarMarxaAutomatic(char a) throws Exception{
        if (a=='+'||a=='-'){
            this.cambio=a;
        }else {
            throw new Exception("Por favor elige solo '+' o '-' para poder cambiar las marchas.");
        }
        switch (cambio){
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
    }
    public void CanviarMarxaManual(){

    }
}
