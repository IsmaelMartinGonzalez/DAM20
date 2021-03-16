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
//Builder
    public Encarrec(int id, Date data){
        this.id=id;
        this.data=data;
    }
//Getters/Setters
//Others Methods

    @Override
    public String toString() {
        return id+"\t"+data;
    }
}
