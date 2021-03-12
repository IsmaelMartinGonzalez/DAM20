package BasesDeDatosConJava;

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
public class bd {
//Attributes
//Builder

    public bd() throws SQLException {
    }

//Getters/Setters
//Others Methods
    public static Connection getConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/examen_2eval";
        String user="root";
        String psw="";
        Connection c=DriverManager.getConnection(url,user,psw);
        return c;
    }
    public static void main(String[] args) throws SQLException {
        Statement stmt=getConnection().createStatement();
        ResultSet rs= stmt.executeQuery("SELECT * FROM personas ORDER BY nombre");
        while(rs.next()){
            System.out.println("Nom: "+rs.getString("nombre"));
        }
        getConnection().close();
    }
}
