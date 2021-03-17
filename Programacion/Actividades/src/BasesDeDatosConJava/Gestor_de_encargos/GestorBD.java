package BasesDeDatosConJava.Gestor_de_encargos;
import java.sql.Date;
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

//Others Methods
    public void tancar () throws Exception{
        this.conn.close();
    }
    public int obtenirNouIDClient() throws Exception{
        return obtenirID("CLIENTS");
    }
    public int obtenirNouIDEncarrec()throws Exception{
        return obtenirID("ENCARRECS");
    }
    public int obtenirNouIDProducte()throws Exception{
        return obtenirID("PRODUCTES");
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
    public List<Encarrec> cercarEncrrec(int id) throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs = cerca.executeQuery("SELECT * FROM ENCARRECS WHERE ID='"+id+"'");
        LinkedList<Encarrec> llista=new LinkedList<>();
        while (rs.next()){
            llista.add(new Encarrec(rs.getInt("ID"),rs.getTimestamp("DATE"),rs.getInt("IDCLIENT")));
        }
        return llista;
    }

    public void  afegirClient (Client c) throws Exception{
        Statement upadte= conn.createStatement();
        String valors = c.getId()+", '"+c.getNom()+"','"+c.getApostal()+"','"+c.getAelectronica()+"','"+c.getTelefon()+"'";
        upadte.executeUpdate("INSERT INTO CLIENTS VALUES("+valors+")");
    }
    public void afegirEncarrec(Encarrec e)throws Exception{
        Statement update=conn.createStatement();
        String valors = e.getId()+", '"+e.getData()+"','"+e.getIdClient()+"'";
        update.executeUpdate("INSERT  INTO ENCARRECS VALUE ("+valors+")");
    }

    //Convierte una fecha de tipo Date en una de tipo Date de mySQL.
    public Timestamp covert(java.util.Date data){
        Timestamp dataSql=new Timestamp(data.getTime());
        return dataSql;
    }

    private int obtenirID(String tabla)throws Exception{
        //Buscar ID Maximo segun la tabla
        Statement cercarMaxId= conn.createStatement();
        ResultSet rs=cercarMaxId.executeQuery("SELECT MAX(ID) FROM "+tabla);
        if (rs.next()) return (1+rs.getInt(1));
        else return 1;
    }

}