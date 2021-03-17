package BasesDeDatosConJava.Gestor_de_encargos;
//import java.util.Date;
import java.sql.Timestamp;

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
    Timestamp data;
    int idClient;
//Builder
    public Encarrec(int id, Timestamp data, int idClient){
        this.id=id;
        this.data=data;
        this.idClient=idClient;
    }

//Getters/Setters
    public int getId() {
        return id;
    }

    public Timestamp getData() {
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
