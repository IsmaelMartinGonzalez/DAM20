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
    private String url="jdbc:mysql://localhost:3306/GestioEncarrecs";
    private String user="root";
    private String psw="Fmartin250814";
    private Connection conn;
//Builder
    public GestorBD() throws Exception{
        this.conn=DriverManager.getConnection(url,user,psw);
    }

//Others Methods
    //Cierra la conexión con la base de datos.
    public void tancar () throws Exception{
        this.conn.close();
    }

    //Obtenemos nuevos IDs para las tablas
    public int obtenirNouIDClient() throws Exception{
        return obtenirID("CLIENTS");
    }
    public int obtenirNouIDEncarrec()throws Exception{
        return obtenirID("ENCARRECS");
    }
    public int obtenirNouIDProducte()throws Exception{
        return obtenirID("PRODUCTES");
    }

    //Obtenemos datos de la tabla Clientes
    public List<Client> cercarClient(String nom) throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs= cerca.executeQuery("SELECT * FROM CLIENTS WHERE NOM='" + nom + "'");
        LinkedList<Client> llista=new LinkedList<Client>();
        while (rs.next()){
            llista.add(new Client(rs.getInt("ID"),rs.getString("NOM"),rs.getString("APOSTAL"),rs.getString("AELECTRONICA"),rs.getString("TELEFON")));
        }
        return llista;
    }
    //Obtenemos datos de la tabla Encargos
    public List<Encarrec> cercarEncrrec(int idClient) throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs = cerca.executeQuery("SELECT * FROM ENCARRECS WHERE IDCLIENT='"+idClient+"'");
        LinkedList<Encarrec> llista=new LinkedList<>();
        while (rs.next()){
            llista.add(new Encarrec(rs.getInt("ID"),rs.getTimestamp("DATA"),rs.getInt("IDCLIENT")));
        }
        return llista;
    }
    public List<String> cercarEncarrecComplet(int idClient) throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs=cerca.executeQuery(
                "SELECT C.NOM,E.ID AS IDENCARREC, E.DATA, P.NOM AS PRODUCTO, B.QUANTITAT FROM CLIENTS C " +
                "join ENCARRECS E ON E.IDCLIENT=C.ID " +
                "JOIN ENCARRECSPRODUCTES B ON B.IDENCARREC=E.ID " +
                "join PRODUCTES P ON P.ID=B.IDPRODUCTE " +
                "where C.ID="+idClient);
        LinkedList<String> llista =new LinkedList<>();
        while (rs.next()){
            llista.add(rs.getString("NOM")+"\t"+rs.getInt("IDENCARREC")+"\t"+rs.getString("DATA")+"\t"+
                    rs.getString("PRODUCTO")+"\t"+rs.getInt("QUANTITAT"));
        }
        return llista;
    }
    //Obtenemos datos de la tabla Productos
    public List<Producte> llistarProductes() throws Exception{
        Statement cerca= conn.createStatement();
        ResultSet rs=cerca.executeQuery("SELECT * FROM PRODUCTES");
        LinkedList<Producte> llista=new LinkedList<>();
        while (rs.next()){
            llista.add(new Producte(rs.getInt("ID"),rs.getString("NOM"),rs.getFloat("PREU"),rs.getInt("QUANTITAT")));
        }
        return llista;
    }

    //Añadimos datos a la tabla Clientes
    public void  afegirClient (Client c) throws Exception{
        Statement upadte= conn.createStatement();
        String valors = c.getId()+",'"+c.getNom()+"','"+c.getApostal()+"','"+c.getAelectronica()+"','"+c.getTelefon()+"'";
        upadte.executeUpdate("INSERT INTO CLIENTS VALUES("+valors+")");
    }
    //Añadimos datos a la tabla Encargos
    public void afegirEncarrec(Encarrec e)throws Exception{
        Statement update=conn.createStatement();
        String valors = e.getId()+", '"+e.getData()+"','"+e.getIdClient()+"'";
        update.executeUpdate("INSERT  INTO ENCARRECS VALUE ("+valors+")");
    }
    //Añadimos datos a la tabla Productos
    public void afegirProducte(Producte p)throws Exception{
        Statement update= conn.createStatement();
        String valors= p.getId()+", '"+p.getNom()+"','"+p.getPreu()+"','"+p.getStock()+"'";
        update.executeUpdate("INSERT INTO PRODUCTES VALUE ("+valors+")");
    }

    //Elimanamos registros de la tabla Encargos
    public void eliminarEncarrec(int idEncarrec) throws Exception {
        Statement update= conn.createStatement();
        update.executeUpdate("DELETE  FROM ENCARRECS WHERE ID="+idEncarrec);
        sumarStok(idEncarrec);
        update.executeUpdate("DELETE FROM ENCARRECSPRODUCTES WHERE IDENCARREC="+idEncarrec);
    }

    //Añadimos la conexion del encargo con el producto mediante la tabla EncargoProductos
    public void afegirEncarrecProducte(int idEncarrec, String producte, int quantitat) throws Exception{
        int idProducte=cercarProducte(producte);
        Statement update= conn.createStatement();
        String valors = idEncarrec+",'"+idProducte+"','"+quantitat+"'";
        update.executeUpdate("INSERT INTO ENCARRECSPRODUCTES VALUE("+valors+")");
        restarStok(idProducte,quantitat);
    }

    //Convierte una fecha de tipo Date en una de tipo Date de mySQL.
    public Timestamp covert(java.util.Date data){
        Timestamp dataSql=new Timestamp(data.getTime());
        return dataSql;
    }

    //Obtenemos un ID para cada tabla
    private int obtenirID(String tabla)throws Exception{
        //Buscar ID Maximo segun la tabla
        Statement cercarMaxId= conn.createStatement();
        ResultSet rs=cercarMaxId.executeQuery("SELECT MAX(ID) FROM "+tabla);
        if (rs.next()) return (1+rs.getInt(1));
        else return 1;
    }

    //Obtenemos el ID de un producto en concreto a través de su nombre.
    private int cercarProducte(String producte) throws Exception {
        int idProducte = 0;
        Statement cerca = conn.createStatement();
        ResultSet rs= cerca.executeQuery("SELECT * FROM PRODUCTES WHERE NOM='" + producte + "'");
        while (rs.next()) {
            idProducte = rs.getInt("ID");
        }
        return idProducte;
    }

    //Cambiamos los datos de la tabla productos
    private void restarStok(int idProducte, int quantitat) throws Exception{
        int quantitatProducte=0;
        for (int i = 0; i < llistarProductes().size(); i++) {
            if (llistarProductes().get(i).getId()==idProducte){
                quantitatProducte= llistarProductes().get(i).getStock();
            }
        }
        int quantitatfinal=quantitatProducte-quantitat;
        Statement update= conn.createStatement();
        update.executeUpdate("UPDATE PRODUCTES SET QUANTITAT ="+quantitatfinal+" WHERE ID="+idProducte);
    }
    private void sumarStok(int idencarrec) throws Exception {
        Statement cerca= conn.createStatement();
        Statement update=conn.createStatement();
        int quantitatProducte=0;
        int quantitatStock=0;
        int quantitatFinal=0;
        int idProducte=0;
        ResultSet rs=cerca.executeQuery("SELECT * FROM ENCARRECSPRODUCTES WHERE IDENCARREC="+idencarrec);
        while (rs.next()){
            quantitatProducte=rs.getInt("QUANTITAT");
            idProducte=rs.getInt("IDPRODUCTE");
        }
        for (int i = 0; i < llistarProductes().size(); i++) {
            if (llistarProductes().get(i).getId()==idProducte){
                quantitatStock=llistarProductes().get(i).getStock();
            }
        }
        quantitatFinal=quantitatStock+quantitatProducte;
        update.executeUpdate("UPDATE PRODUCTES SET QUANTITAT ="+quantitatFinal+" WHERE ID="+idProducte);
    }


}