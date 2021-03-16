package BasesDeDatosConJava.Gestor_de_encargos;

/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename:
 * Created:  14/11/2020 / 13:47
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Producte {
//Attributes
    int id;
    String nom;
    float preu;

//Builder
    public Producte(int id,String nom, float preu){
        this.id=id;
        this.nom=nom;
        this.preu=preu;
    }

//Getters/Setters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPreu() {
        return preu;
    }

//Others Methods
    @Override
    public String toString() {
        return id+"\t"+nom+"\t"+preu;
    }
}
