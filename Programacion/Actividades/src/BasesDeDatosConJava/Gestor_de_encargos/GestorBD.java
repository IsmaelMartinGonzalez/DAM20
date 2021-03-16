package BasesDeDatosConJava.Gestor_de_encargos;
import java.util.*;
import java.sql.*;
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
public class GestorBD {
//Attributes
    Connection conn;
//Builder
    public GestorBD() throws Exception{
        String url="jdbc:mysql://localhost:3306/GestioEncarrecs";
        String user="root";
        String psw="Fmartin250814";
        this.conn=DriverManager.getConnection(url,user,psw);
    }
//Getters/Setters
//Others Methods
    public void tancar () throws Exception{
        this.conn.close();
    }
    public int obtenirNouIDClient() throws Exception{
        //Buscar ID Maximo
        Statement cercaMaxId=conn.createStatement();
        ResultSet rs=cercaMaxId.executeQuery("SELECT MAX(ID) FROM CLIENTS");
        if (rs.next()) return (1+rs.getInt(1));
        else return 1;
    }
    public List<Client> cercarClient(String nom) throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs= cerca.executeQuery("SELECT * FROM CLIENTS WHERE NOM='" + nom + "'");
        LinkedList<Client> llista=new LinkedList<Client>();
        while (rs.next()){
            llista.add(new Client(rs.getInt("ID"),rs.getString("NOM"),rs.getString("APOSTAL"),rs.getString("AELECTRONICA"),rs.getString("TELEFON")));
        }
        return llista;
    }
    public void  afegirClient (Client c) throws Exception{
        Statement upadte= conn.createStatement();
        String valors = c.getId()+", '"+c.getNom()+"','"+c.getApostal()+"','"+c.getAelectronica()+"','"+c.getTelefon()+"'";
        upadte.executeUpdate("INSERT INTO CLIENTS VALUES("+valors+")");
    }

}