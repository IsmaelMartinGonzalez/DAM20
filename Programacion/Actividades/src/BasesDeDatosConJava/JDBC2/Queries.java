package BasesDeDatosConJava.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Project name: DAM20/BasesDeDatosConJava.JDBC2
 * Filename:Queries
 * Created:  21/03/2021 / 15:50
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:1.0
 */
public class Queries {

    //Attriubutes
    private static final String URL = "jdbc:mysql://194.224.79.42:43306/addressbook?useUnicode=true&useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "alumne";
    private static final String PASSWORD = "tofol";
    private Connection connection; // manages connection
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    //Builder
    public Queries(){
        try{
            connection =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // create query that selects all entries in the AddressBook
            selectAllPeople =
                    connection.prepareStatement("SELECT * FROM ADDRESSES");
            // create query that selects entries with a specific last name
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT * FROM ADDRESSES WHERE LastName = ?");
            // create insert that adds a new entry into the database
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO ADDRESSES " +
                            "(FirstName, LastName, Email, PhoneNumber) " +
                            "VALUES (?, ?, ?, ?)");
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    //Other Methods

    // select all of the addresses in the database
    public List<Persona> getAllPeople(){

        List<Persona> results = null;
        ResultSet resultSet = null;
        try{
            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Persona>();
            while (resultSet.next()){
                results.add(new Persona(
                        resultSet.getInt("addressID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber")));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    // select person by last name
    public List<Persona> getPeopleByLastName(String name){
        List<Persona> results = null;
        ResultSet resultSet = null;
        try{
            selectPeopleByLastName.setString(1, name); // specify last name

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList<Persona>();
            while (resultSet.next()){
                results.add(new Persona(resultSet.getInt("addressID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber")));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    // add an entry
    public int addPerson(String fname, String lname, String email, String num){
        int result = 0;
        // set parameters, then execute
        try{
            insertNewPerson.setString(1,fname);
            insertNewPerson.setString(2,lname);
            insertNewPerson.setString(3,email);
            insertNewPerson.setString(4,num);

            // insert the new entry; returns # of rows updated
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    // close the database connection
    public void close(){
        try{
            connection.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
