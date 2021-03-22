package BasesDeDatosConJava.JDBC2;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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
    private static final String URL = "jdbc:mysql://194.224.79.42:43306/addressbook";
    private static final String USERNAME = "alumne";
    private static final String PASSWORD = "tofol";
    private Connection connection; // manages connection
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;
    private PreparedStatement updatePerson;
    private PreparedStatement deletePerson;

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
                    "SELECT * FROM ADDRESSES WHERE UPPER(LastName) LIKE ?");
            // create insert that adds a new entry into the database
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO ADDRESSES " +
                            "(AddressId,FirstName, LastName, Email, PhoneNumber) " +
                            "VALUES (?,?, ?, ?, ?)");
            updatePerson= connection.prepareStatement(
                    "UPDATE ADDRESSES SET FIRSTNAME=?, LASTNAME=?, EMAIL=?, PHONENUMBER=? WHERE ADDRESSID=?");
            deletePerson=connection.prepareStatement(
                    "DELETE FROM ADDRESSES WHERE ADDRESSID=?");
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
            insertNewPerson.setInt(1,generateNewID());
            insertNewPerson.setString(2,fname);
            insertNewPerson.setString(3,lname);
            insertNewPerson.setString(4,email);
            insertNewPerson.setString(5,num);

            // insert the new entry; returns # of rows updated
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    //update an entry
    public int updateEntry(String fname,String lname,String email, String num,String addressId){
        int result=0;
        int id=Integer.parseInt(addressId);
        try{
            updatePerson.setString(1,fname);
            updatePerson.setString(2,lname);
            updatePerson.setString(3,email);
            updatePerson.setString(4,num);
            updatePerson.setInt(5,id);
            result=updatePerson.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    //delete an entry
    public int deleteEntry(String addressId){
        int result=0;
        int id=Integer.parseInt(addressId);
        try{
            deletePerson.setInt(1,id);
            result=deletePerson.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }
        return result;
    }


    //generate new id
    private int generateID() throws SQLException {
        Statement searchMaxId=connection.createStatement();
        ResultSet rs=searchMaxId.executeQuery("SELECT MAX(ADDRESSID) FROM ADDRESSES");
        if(rs.next()) return (1+rs.getInt(1));
        else return 1;
    }

    private int generateNewID() throws SQLException {
        int id=generateRandomNum();
        if(!idExist(id)){
            return id;
        }else {
            return generateNewID();
        }
    }

    private int generateRandomNum(){
        return (int) (Math.random()*9999)+1;
    }
    private boolean idExist(int id) throws SQLException {
        boolean exist=false;
        Statement search=connection.createStatement();
        ResultSet rs= search.executeQuery("SELECT * FROM ADDRESSES WHERE ADDRESSID="+id);
        while (rs.next()){
            exist=true;
        }
        return exist;
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
