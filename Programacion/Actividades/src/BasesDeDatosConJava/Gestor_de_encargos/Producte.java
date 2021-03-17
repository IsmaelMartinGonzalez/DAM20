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
    int stock;

//Builder
    public Producte(int id,String nom, float preu,int stock){
        this.id=id;
        this.nom=nom;
        this.preu=preu;
        this.stock=stock;
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

    public int getStock() {
        return stock;
    }

    //Others Methods
    @Override
    public String toString() {
        return id+"\t"+nom+"\t"+preu+"\t"+stock;
    }
}
