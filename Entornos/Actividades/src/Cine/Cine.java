package Cine;

/**
 * Project name: DAM20/Cine
 * Filename:
 * Created:  18/01/2021 / 19:17
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Cine {
    //Attriubutes
    private Seats[][] seats;
    private int price;
    private Film film;
    //Builder

    public Cine(int rows,int cols, int price, Film film) {
        seats = new Seats[rows][cols];
        this.price = price;
        this.film = film;
        fillSeats();
    }

    //Getters/Setters

    public Seats[][] getSeats() {
        return seats;
    }
    public void setSeats(Seats[][] seats) {
        this.seats = seats;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    /**
     * Devolvemos un sitio concreto por su fila y letra*/
    public Seats getSeat (int row, char letter){
        return seats[seats.length-row-1][letter-'A'];
    }
    /**Numero de filas*/
    public int getRows(){
        return seats.length;
    }
    /**Numero de columnas*/
    public int getColumns(){
        return seats[0].length;
    }
    //Other Methods
    /**
     * Rellena nuestras butacas dandoles fila y numero
     * */
    private void fillSeats(){
        int row = seats.length;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                seats[i][j]=new Seats((char) ('A'+j),row);
            }
            row--;
        }
    }
    /**
     * Indicamos is hay sitio en el cine, cuando hay una butaca vacia se sale de la función
     * */
    public boolean isThereRoom(){
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (!seats[i][j].occupied())
                    return true;
            }
        }
        return false;
    }
    /**
     * Indicamos si una posición concreta esta ocupada o no
     * */
    public boolean thereAreSeats(int row, char letter){
        return getSeat(row, letter).occupied();
    }
    /**
     * Indicamos di el espectador cumple con los requisitos para ver la pelicula*/
    public boolean youCanEnter(Person e){
        return e.haveMoney(price) && e.haveAge(film.getMinAge());
    }
    /**
     * El espectador se sienta en una sitio*/
    public  void sit (int row, char letter, Person e){
        getSeat(row,letter).setViewer(e);
    }
    public void show(){
        System.out.println("Información del cine\n" +
                "Pelicula: "+film+"\n" +
                "Precio de la entrada: "+price+"€\n");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                System.out.println(seats[i][j]);
            }
            System.out.println("");
        }
    }

}
