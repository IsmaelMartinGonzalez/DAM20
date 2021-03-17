package BasesDeDatosConJava.Gestor_de_encargos;
import java.util.Date;

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
public class Encarrec {
//Attributes
    int id;
    Date data;
    int idClient;
//Builder
    public Encarrec(int id, Date data, int idClient){
        this.id=id;
        this.data=data;
        this.idClient=idClient;
    }

//Getters/Setters
    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public int getIdClient() {
        return idClient;
    }

    //Others Methods
    @Override
    public String toString() {
        return id+"\t"+data;
    }
}
