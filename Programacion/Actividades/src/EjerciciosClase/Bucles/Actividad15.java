package EjerciciosClase.Bucles;

/**
 * Project name: DAM20/EjerciciosClase.Bucles
 * Filename: Actividad 15
 * Created:  16/11/2020 / 16:56
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
class Actividad15 {
    public static void main(String[] args) {
        Persona paco= new Persona(52, "paco");
        paco.hola();
    }
}
class Persona{
    private int edad;
    private String nombre;

    public Persona(int e, String n){
        this.edad=e;
        this.nombre=n;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getEdad() {
        return edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void hola(){
        System.out.println("Me llmamo: "+nombre+" y mi edad es: "+edad);
    }
}

