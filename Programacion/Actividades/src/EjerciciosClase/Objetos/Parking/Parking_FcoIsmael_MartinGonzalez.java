package EjerciciosClase.Objetos.Parking;

import java.io.*;
import java.util.*;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.Parking
 * Filename:
 * Created:  22/01/2021 / 18:23
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Parking_FcoIsmael_MartinGonzalez {
    //Attriubutes
    public enum TipusPlacesParking{Discapacitat,No_Discapacitat}
    private BufferedWriter bw;
    private BufferedReader br;
    private ArrayList<String> matriculas=new ArrayList<>();
    private String[] plazasD;
    private String[] plazas;
    private int plazasOcupadasD;
    private int plazasOcupadas;

    //Builder
    public Parking_FcoIsmael_MartinGonzalez(int places_no_discapacitats, int places_discapacitats) {
        this.plazasD=new String[places_discapacitats];
        this.plazas=new String[places_no_discapacitats];
        inicPlazas();
    }

    //Getters/Setters
    private String[] getPlazasD() {
        return plazasD;
    }

    //Other Methods
    /**Este metodo se encarga de leer y comprobar las matriculas que hay en un archivo de texto plano
     * Tambien se encargara de llenar el parking en función de las matriculas leidas
     * En caso de no estar bien formado el path, saltara una excepción
     * Si la matricula no esta bien formada saltara una excepción*/
    public void llegirMatricules(String path) throws Exception{
        String linea;
        try {
            //Comprovamos si la ruta es correcta
            br=new BufferedReader(new FileReader(path));
        }catch (Exception e){
            throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
        }
        linea=br.readLine();
        //Generamos un bucle que ira leyendo las lineas del archivo hasta encontrar una linea vacia
        while (linea!=null) {
            /*Por cada linea, comprobamos que este bien formado según nuestro patron[0-9]{4}[A-Z]{3}, en caso de un error
             * el programa lanzara una excepción*/
            if (linea.length()==7){
                char[] chars=linea.toCharArray();
                for (int i = 0; i < chars.length-3; i++) {
                    if (chars[i]>=48&&chars[i]<=57){
                    }else {
                        throw new Exception("ALERTA =====> Matrícula incorrecte.");
                    }
                }
                for (int i = 4; i < chars.length; i++) {
                    if (chars[i]>=65&&chars[i]<=90){
                    }else {
                        throw new Exception("ALERTA =====> Matrícula incorrecte.");
                    }
                }
            }else {
                throw new Exception("ALERTA =====> Matrícula incorrecte.");
            }
                matriculas.add(linea);
                linea = br.readLine();
            }
        br.close();
        /*Por ultimo recorremos nuestro array de matriculas para ir colocandolas en las plazas de nuestro parking en
        * funcion de un numero aleatorio*/
        for (int i = 0; i < matriculas.size(); i++) {
            int numRandom=(int) (Math.random()*2)+1;
            if (numRandom==1){
                entraCotxe(matriculas.get(i));
            }else if (numRandom==2){
                entraCotxeDiscapacitat(matriculas.get(i));
            }
        }
    }

    /**Este metodo se encarga de introducir coches en plazas para no discapacitados.
     * Si se supera el 85% saltara una excepción.
     * Si se llena el parking saltara una excepción.
     * Si un coche vuleve a entrar y ya esta aparcado saltara una excepción.*/
    public int entraCotxe(String matricula) throws Exception{
        //Lo primero que hacemos es comprobar que la matricula introducida es correcta.
        if (matricula.length()==7){
            char[] chars= matricula.toCharArray();
            for (int i = 0; i < chars.length-3; i++) {
                if (chars[i]>=48&&chars[i]<=57){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
            for (int i = 4; i < chars.length; i++) {
                if (chars[i]>=65&&chars[i]<=90){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
        }else {
            throw new Exception("ALERTA =====> Matrícula incorrecte.");
        }
        //Comprobamos si el parking esta lleno, o no.
        if (capacidad(TipusPlacesParking.No_Discapacitat)){
            throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
        }else {
            for (int i = 0; i < plazas.length; i++) {
                //Lo sigiente es comprobar si el coche ya esta en el parking.
                if (plazas[i].equals(matricula)){
                    throw new Exception("El cotxe ja està al parking. No pot entrar.");
                }else if (plazas[i]==""){ //Si la posición esta vacia introducimos la matricula
                    //Comprobamos si la matricula esta como un discapacitadado
                    for (int j = 0; j < plazasD.length; j++) {
                        if (plazasD[j].equals(matricula)){
                            throw new Exception("El cotxe ja està al parking. No pot entrar.");
                        }
                    }
                    plazas[i]=matricula;
                    plazasOcupadas++;
                    //Tras asignar la posición generamos un numero aleatorio para meter un garrulo de forma aleatoria en el parking de discapacitados.
                    int garrulo=(int)((Math.random()*99)+1);
                    if (garrulo<=10){
                        entraCotxeDiscapacitat(matricula);
                    }
                    //Tras asignar la posición comprobamos si se ha llegado al 85% de capacidad.
                    if (porcentCapacidad(TipusPlacesParking.No_Discapacitat)){
                        throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
                    }
                    return i;
                }
            }
        }
        return -1;
    }

    /**Este metodo se encarga de introducir coches en plazas para discapacitados
     * Si se supera el 85% saltara una excepción
     * Si se llena el parking saltara una excepción
     * Si un coche vuleve a entrar y ya esta aparcado saltara una excepción
     * Si un coche de no discapacitado entra en una plaza saltara una excepción*/
    public int entraCotxeDiscapacitat(String matricula) throws Exception {
        //Comprobamos si la matricula es correcta.
        if (matricula.length()==7){
            char[] chars= matricula.toCharArray();
            for (int i = 0; i < chars.length-3; i++) {
                if (chars[i]>=48&&chars[i]<=57){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
            for (int i = 4; i < chars.length; i++) {
                if (chars[i]>=65&&chars[i]<=90){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
        }else {
            throw new Exception("ALERTA =====> Matrícula incorrecte.");
        }
        //Comprobamos la capacidad del parking.
        if (capacidad(TipusPlacesParking.Discapacitat)&&!(capacidad(TipusPlacesParking.No_Discapacitat))){
            throw new Exception("ALERTA =====> Parking per discapacitats ple. Ha ocupat plaça normal num: "+entraCotxe(matricula));
        }else if (capacidad(TipusPlacesParking.Discapacitat)){
            throw new Exception("ALERTA =====> Parking per discapacitats ple.");
        }else {
            for (int i = 0; i < plazasD.length; i++) {
                //Comprobamos si la matricula ya esta en el parking.
                if (plazasD[i].equals(matricula)){
                    throw new Exception("El cotxe ja està al parking. No pot entrar.");
                }else if(plazasD[i]==""){
                    /*Comprobamos si la matricula es de un no Dicapacitado, si es asi lanzamos una excepción.
                    En caso contrario continua con el programa y le asigna una plaza*/
                    for (int j = 0; j <plazas.length; j++) {
                        /*Para saber si es un garrulo previamente lo hemos guardado en el parking de no discapacitados
                         y si esta es por tanto un garrulo. Lo sacamos del parkig normal y le asignamos uno del de discapacitados*/
                        if (plazas[j].equals(matricula)){
                            plazas[j]="";
                            plazasOcupadas--;
                            plazasD[i]=matricula;
                            plazasOcupadasD++;
                            throw new Exception("ALERTA =====> Garrulo detected!!! Ha aparcat a la plaça: "+i);
                        }
                    }
                    plazasD[i]=matricula;
                    plazasOcupadasD++;
                    //Comprobamos si llegamos al 85% de la ocupación.
                    if (porcentCapacidad(TipusPlacesParking.Discapacitat)){
                        throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
                    }
                    return i;
                }
            }
        }
        return -1;
    }

    /**Este metodo se encarga de sacar los coches de las plazas de parking para no discapacitados
     * Si se intenta sacar un coche que ya no esta en el parking saltara una excepción*/
    public void surtCotxe(String matricula) throws Exception {
        //Generamos un booleano para controlar si un coche esta en el parking o no.
        boolean bandera=false;
        //Comprobamos que la matricula es correcta.
        if (matricula.length()==7){
            char[] chars= matricula.toCharArray();
            for (int i = 0; i < chars.length-3; i++) {
                if (chars[i]>=48&&chars[i]<=57){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
            for (int i = 4; i < chars.length; i++) {
                if (chars[i]<=65&&chars[i]>=90){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
        }else {
            throw new Exception("ALERTA =====> Matrícula incorrecte.");
        }
        //Comprobamos si la matricula esta o no en el parking.
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].equals(matricula)){
                bandera=true;
            }
        }
        //Si la matricula no esta en el parking lanzamos una excepción, en caso contrario sacamos la matricula del parking.
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].equals(matricula)){
                plazas[i]="";
                plazasOcupadas--;
            }else if (!bandera){
                throw new Exception("El cotxe no és al parking.");
            }
        }
    }

    /**Este metodo se encarga de sacar los coches de las plazas de parking para discapacitados
     * Si se intenta sacar un coche que ya no esta en el parking saltara una excepción*/
    public void surtCotxeDiscapacitat(String matricula) throws Exception{
        //Generamos el boolean para comprovar la matricula.
        boolean bandera=false;
        //Comprovamos si esta bien formada la matricula.
        if (matricula.length()==7){
            char[] chars= matricula.toCharArray();
            for (int i = 0; i < chars.length-3; i++) {
                if (chars[i]>=48&&chars[i]<=57){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
            for (int i = 4; i < chars.length; i++) {
                if (chars[i]>=65&&chars[i]<=90){
                }else {
                    throw new Exception("ALERTA =====> Matrícula incorrecte.");
                }
            }
        }else {
            throw new Exception("ALERTA =====> Matrícula incorrecte.");
        }
        //Comprovamos si esta en el parking o no.
        for (int i = 0; i < plazasD.length; i++) {
            if (plazasD[i].equals(matricula)){
                bandera=true;
            }
        }
        //Si la matricula esta en el parking la sacamos, encaso contrario lanzamos una excepción.
        for (int i = 0; i < plazasD.length; i++) {
            if (plazasD[i].equals(matricula)){
                plazasD[i]="";
                plazasOcupadasD--;
            }else if (!bandera){
                throw new Exception("El cotxe no és al parking.");
            }
        }
    }

    /**Este metodo se encarga de indicar cuantas plazas estan ocupadas en nuestro parkig según el tipo de parking*/
    public int getPlacesOcupades(TipusPlacesParking tipus){
        int total=0;
        if (tipus.equals(TipusPlacesParking.Discapacitat)){
            total=plazasOcupadasD;
        }else if (tipus.equals(TipusPlacesParking.No_Discapacitat)){
            total=plazasOcupadas;
        }
        return total;
    }

    /**Este metodo se encarga de indicar cuantas plazas quedan libre en nuestro parkig según el tipo de parking*/
    public void getPlacesLliures(TipusPlacesParking tipus){
        int total=0;
        if (tipus.equals(TipusPlacesParking.Discapacitat)){
            total=plazasD.length-plazasOcupadasD;
            System.out.println("Plazas libres: "+ total);
        }else if(tipus.equals(TipusPlacesParking.No_Discapacitat)){
            total=plazas.length-plazasOcupadas;
            System.out.println("Plazas libres: "+total);
        }
    }

    /**Este metodo se encargara de guardar todas las matriculas del parking*/
    public void guardarMatricula(String path) throws  Exception{
        //Comprobamos que el path es correcto.
        try {
            bw=new BufferedWriter(new FileWriter(path,true));
        }catch (Exception e){
            throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
        }
        for (int i = 0; i < plazasD.length; i++) {
            if (plazasD[i]!=""){
                bw.write(plazasD[i]+"\n");
            }
        }
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i]!=""){
                bw.write(plazas[i]+"\n");
            }
        }
        bw.close();
    }

    /**Este metodo se encarga de llenar nuestro parking de plazas según se indique en el constructor*/
    private void inicPlazas(){
        for (int i = 0; i < plazas.length; i++) {
            plazas[i]="";
        }
        for (int i = 0; i < plazasD.length; i++) {
            plazasD[i]="";
        }
    }

    /**Este metodo se encarga de controlar si la capacidad del parking se llena o no.
     * Si se llena el parking se lanzara un booleano true, en caso contrario lanzara false si hay algun espacio*/
    private boolean capacidad(TipusPlacesParking tipo){
        boolean lleno=false;
        if (tipo.equals(TipusPlacesParking.No_Discapacitat)){
            for (int i = 0; i < plazas.length; i++) {
                if (plazas[i]!=""){
                    lleno=true;
                }else if (plazas[i]==""){
                    return false;
                }else {
                    lleno=false;
                }
            }
        }else if (tipo.equals(TipusPlacesParking.Discapacitat)){
            for (int i = 0; i < plazasD.length; i++) {
                if (plazasD[i]!=""){
                    lleno=true;
                }else if (plazasD[i]==""){
                    return false;
                }else {
                    lleno=false;
                }
            }
        }
        return lleno;
    }

    /**Este meto privado se encarga de calcular el cuando hay un volumen de coches superior al 85%*/
    private boolean porcentCapacidad(TipusPlacesParking tipo) throws Exception {
        boolean bandera=false;
        if (tipo.equals(TipusPlacesParking.No_Discapacitat)){
            int result=(int)(plazas.length*0.85);
            if (plazasOcupadas>result){
                bandera=true;
            }
        }else if (tipo.equals(TipusPlacesParking.Discapacitat)){
            int result=(int) (getPlazasD().length*0.85);
            if (plazasOcupadasD>result){
                bandera=true;
            }
        }
        return bandera;
    }
}

