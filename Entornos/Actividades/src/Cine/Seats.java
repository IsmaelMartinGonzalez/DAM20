package Cine;

/**
 * Project name: DAM20/Cine
 * Filename:
 * Created:  18/01/2021 / 19:52
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Seats {
    //Attriubutes
    private char letter;
    private int row;
    private Person viewer;
    //Builder
    public Seats(char letter, int row){
        this.letter=letter;
        this.row=row;
        this.viewer=null;//No habra nadie sentado cuando se inicie el asiento.
    }
    //Getters/Setters

    public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public Person getViewer(){
        return viewer;
    }
    public void  setViewer(Person viewer){
        this.viewer=viewer;
    }
    //Methods

    public  boolean occupied(){
        return viewer !=null;
    }

    @Override
    public String toString() {
        if (occupied())
            return "Asiento: "+getRow()+getLetter()+" se encuentra ocupado por "+viewer.getName();
        return "Asiento: "+getRow()+getLetter()+" esta vacio";
    }
}
