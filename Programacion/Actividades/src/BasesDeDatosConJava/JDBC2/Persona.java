package BasesDeDatosConJava.JDBC2;

/**
 * Project name: DAM20/BasesDeDatosConJava.JDBC2
 * Filename: Persona
 * Created:  21/03/2021 / 15:47
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:1.0
 * -----------------------------------------------------------
 */
public class Persona {

    //Attriubutes
    private int addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // constructor
    public Persona()
    {
    }
    // constructor
    public Persona(int addressID, String firstName, String lastName,String email, String phoneNumber){
        setAddressID(addressID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    //Getters/Setters

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
