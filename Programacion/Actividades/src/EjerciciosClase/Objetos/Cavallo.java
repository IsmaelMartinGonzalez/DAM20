package EjerciciosClase.Objetos;

/**
 * Project name: DAM20/ EjerciciosClase.Objetos
 * Filename: Cavallo
 * Created:  16/11/2020 / 16:04
 * Description: Creamos una clase llamada Cavallo para practicar el uso de objetos en java. Actividad 8.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Cavallo {
    //Atributos
    private String nombre;
    private int edad;
    private String colorOjos;
    private String colorPelaje;
    private int altura;
    private String sexo;

    //Constructor
    public Cavallo(String nombre, int edad, int altura, String sexo){
        this.nombre = nombre;
        this.edad=edad;
        this.altura=altura;
        this.sexo=sexo;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad>=0)
        this.edad = edad;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        if (sexo=="H"||sexo=="M")
        this.sexo = sexo;
    }
    public String getColorOjos() {
        return colorOjos;
    }
    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }
    public String getColorPelaje() {
        return colorPelaje;
    }
    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    //Otros Metodos
    public String correr(){
        String correr= "El cavallo comienza a correr";
        return correr;
    }
    public void aniversario(){
        this.edad++;
    }
}
