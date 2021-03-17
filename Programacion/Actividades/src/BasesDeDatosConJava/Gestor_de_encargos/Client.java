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
public class Client {

//Attributes
    private  int id;
    private  String nom;
    private  String apostal;
    private  String aelectronica;
    private  String telefon;

//Builder
    public Client(int id,String nom, String apostal, String aelectronica,String telefon){
        this.id=id;
        this.nom=nom;
        this.apostal=apostal;
        this.aelectronica=aelectronica;
        this.telefon=telefon;
    }

//Getters/Setters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getApostal() {
        return apostal;
    }

    public String getAelectronica() {
        return aelectronica;
    }

    public String getTelefon() {
        return telefon;
    }

//Others Methods
    @Override
    public String toString() {
        return id+"\t"+nom+"\t"+apostal+"\t"+aelectronica+"\t"+telefon;
    }
}
