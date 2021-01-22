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
public class main {
    public static void main(String[] args) {
        //Creamos la pelicula a reproducir
        Film film= new Film("Pitch Black",112,13,"David Twohy");

        //Creamos el cine
        Cine cine=new Cine(9,8,5,film);

        //int numViwers=(int)(Math.random()*50+1);

        //Variable y objetos que necesitaremos para generar y colocar a loes espectadores
        Person e;
        int row;
        char letter;
        boolean lleno=false;
        int i=0;
        while (cine.isThereRoom()) {
            //Genereamos un espectador, con su edad de forma aleatorio y su dinero tambien.
            e = new Person(Resources.generarNumAleatorio(1, 80), Resources.generarNumAleatorio(1, 50),
                    Resources.nombres[Resources.generarNumAleatorio(0, Resources.nombres.length - 1)]);
            //Generamos fila y letra
            //Si esta libre continua si no buca de nuevo
            do {
                row = Resources.generarNumAleatorio(0, cine.getRows() - 1);
                letter = (char) Resources.generarNumAleatorio('A', 'A' + (cine.getRows()) - 1);
            } while (cine.thereAreSeats(row, letter));
            //Si cumple con las condiciones de edad y dinero entra dentro del if
            if (cine.youCanEnter(e)) {
                e.pay(cine.getPrice()); //Se paga la entrada
                cine.sit(row, letter, e); //Se sienta el especator
            }
            i++;
            System.out.println(i);
        }
       /*for (int j = 0; j < cine.getCapacity() && cine.isThereRoom(); j++) {
            //Genereamos un espectador, con su edad de forma aleatorio y su dinero tambien.
            e=new Person(Resources.generarNumAleatorio(1,80),Resources.generarNumAleatorio(1,50),
                    Resources.nombres[Resources.generarNumAleatorio(0,Resources.nombres.length-1)]);
            //Generamos fila y letra
            //Si esta libre continua si no buca de nuevo
            do{
                row=Resources.generarNumAleatorio(0,cine.getRows()-1);
                letter=(char) Resources.generarNumAleatorio('A','A'+(cine.getRows())-1);
            }while (cine.thereAreSeats(row,letter));
            //Si cumple con las condiciones de edad y dinero entra dentro del if
            if (cine.youCanEnter(e)){
                e.pay(cine.getPrice()); //Se paga la entrada
                cine.sit(row,letter,e); //Se sienta el especator
            }
        }*/
        System.out.println("");
        cine.show();
        System.out.println("End");
    }
}
