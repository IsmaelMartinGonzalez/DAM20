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
public class Parking {
        //Attriubutes
    public enum TipusPlacesParking{Discapacitat,No_Discapacitat}
    private Scanner sc=new Scanner(System.in);
    private BufferedWriter bw;
    private BufferedReader br;
    private ArrayList<String> matriculas=new ArrayList<>();
    private String[] plazasD;
    private String[] plazas;
    private int plazasOcupadasD;
    private int plazasOcupadas;

    //Builder
    public Parking(int places_no_discapacitats, int places_discapacitats) {
        this.plazasD=new String[places_discapacitats];
        this.plazas=new String[places_no_discapacitats];
        inicPlazas();
    }

    //Getters/Setters
    private ArrayList<String> getMatriculas() {
        return matriculas;
    }
    private String[] getPlazasD() {
        return plazasD;
    }
    private String[] getPlazas() {
        return plazas;
    }
    private int getPlazasOcupadasD() {
        return plazasOcupadasD;
    }
    private int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    //Other Methods
    /**Este metodo se encarga de leer y comprobar las matriculas que hay en un archivo de texto plano
     * En caso de no estar bien formado el path, saltara una excepción
     * Si la matricula no esta bien formada saltara una excepción*/
    public void llegirMatricules(String path) throws Exception{
        String linea;
        try {
            br=new BufferedReader(new FileReader(path));
            linea=br.readLine();
        }catch (Exception e){
            throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
        }
        while (linea!=null) {
            if (linea.length()==7){
                char[] chars= linea.toCharArray();
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
        for (int i = 0; i < matriculas.size(); i++) {
            int numRandom=(int) (Math.random()*2)+1;
            if (numRandom==1){
                entraCotxe(matriculas.get(i));
            }else if (numRandom==2){
                entraCotxeDiscapacitat(matriculas.get(i));
            }
        }
    }

    /**Este metodo se encarga de introducir coches en plazas para no discapacitados
     * Si se supera el 85% saltara una excepción
     * Si se llena el parking saltara una excepción
     * Si un coche vuleve a entrar y ya esta aparcado saltara una excepción*/
    public int entraCotxe(String matricula) throws Exception{
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
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].equals(matricula)){
                throw new Exception("El cotxe ja està al parking. No pot entrar.");
            }else if(plazas[i]!=""){
                if (capacidad(TipusPlacesParking.No_Discapacitat)){
                    throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
                }
            }else{
                plazas[i]=matricula;
                plazasOcupadas++;
                if (porcentCapacidad(TipusPlacesParking.No_Discapacitat)){
                    throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
                }
                return i;
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
        for (int i = 0; i < plazasD.length; i++) {
            if (plazasD[i].equals(matricula)){
                throw new Exception("El cotxe ja està al parking. No pot entrar.");
            }else if(plazasD[i]!=""){
                if (capacidad(TipusPlacesParking.Discapacitat)&&!(capacidad(TipusPlacesParking.No_Discapacitat))){
                    throw new Exception("ALERTA =====> Parking per discapacitats ple. Ha ocupat plaça normal num: "+entraCotxe(matricula));
                }else if (capacidad(TipusPlacesParking.Discapacitat)){
                    throw new Exception("ALERTA =====> Parking per discapacitats ple.");
                }
            }else {
                for (int j = 0; j <plazas.length; j++) {
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
                if (porcentCapacidad(TipusPlacesParking.Discapacitat)){
                    throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
                }
                return i;
            }
        }
        return -1;
    }

    /**Este metodo se encarga de sacar los coches de las plazas de parking para no discapacitados
     * Si se intenta sacar un coche que ya no esta en el parking saltara una excepción*/
    public void surtCotxe(String matricula) throws Exception {
        boolean bandera=false;
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
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].equals(matricula)){
                bandera=true;
            }
        }
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
        boolean bandera=false;
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
        for (int i = 0; i < plazasD.length; i++) {
            if (plazasD[i].equals(matricula)){
                bandera=true;
            }
        }
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

    /***/
    public void guardarMatricula(String path) throws  Exception{
        String txt;
        try {
            bw=new BufferedWriter(new FileWriter(path,true));
        }catch (Exception e){
            throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
        }
        System.out.print("Matricula: ");
        txt=sc.nextLine();
        if (txt.length()==7){
            char[] chars=txt.toCharArray();
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
            }        }else {
            throw new Exception("ALERTA =====> Matrícula incorrecte.");
        }
        bw.write(txt+"\n");
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

