package BasesDeDatosConJava.Gestor_de_encargos;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
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
public class GestorEncarrecs {
//Attributes
    GestorBD gestor;
    BufferedReader entrada;

//Builder
    public GestorEncarrecs() throws Exception{
        gestor=new GestorBD();
        entrada=new BufferedReader(new InputStreamReader(System.in));
    }

//Others Methods
    public void start() throws Exception{
        int opcio;
        while (0!=(opcio=menuPrincilap())){
            try {
                switch (opcio){
                    case 1:
                        cercarClient();
                        break;
                    case 2:
                        menuEncarrec();
                        break;
                    case 3:
                        llistarProductes();
                        break;
                    case 4:
                        afegirClient();
                        break;
                    case 5:
                        afegirEncarrec();
                        break;
                    case 6:
                        afegirProducte();
                        break;
                    case 7:
                        eliminarEncarrec();
                        break;
                    default: mostrarDades("Opció incorrecta\n");
                }
            }catch (Exception e){
                mostrarDades("S'ha produit un error: "+e+"\n");
            }
        }
        gestor.tancar();
    }

    private int menuPrincilap() throws Exception {
        String menu="\nQuina acció vols realitzar?\n"+"[1] Cercar client\n"+
                "[2] Cercar encarrec\n"+"[3] Llistar Productes\n"+"[4] Afegir client\n"+"[5] Afegir encarrec\n"+
                "[6] Afegir producte\n"+"[7] Eliminar encarrec\n"+"[0] Sortir\n"+"Opcio>";
        String lin=entrarDades(menu);
        try {
            int opcio=Integer.parseInt(lin);
            return opcio;
        }catch (Exception e){
            return -1;
        }
    }

    //Amb els metodes entrarDades i mostrarDades, fem el codi independent de la interficie.
    // Si mai es fan canvis, nomes cal canviar aquests dos metodes.

    private String entrarDades(String pregunta) throws IOException{
        mostrarDades(pregunta);
        return entrarDades();
    }
    private  void mostrarDades(String dades) throws  IOException{
        System.out.print(dades);
    }
    private String entrarDades() throws IOException{
        String linea=entrada.readLine();
        if ("".equals(linea)) return null;
        return linea;
    }

    //Buscar un cliente de acuerdo con su nombre
    private void cercarClient() throws Exception{
        String nom=entrarDades("Introdueix el nom del client: "); if (null==nom) return;
        List<Client> llista= gestor.cercarClient(nom);
        Iterator it = llista.iterator();
        mostrarDades("Els clients trobats amb aquest nom son:\n" +
                "----------------------------\n");
        while (it.hasNext()){
            Client c=(Client) it.next();
            mostrarDades(c.toString()+"\n");
        }
    }

    //Buscar un encargo de acuerdo con el id del cliente
    private void cercarEncarrecReduit() throws Exception {
        int id=Integer.parseInt(entrarDades("Introdueix el identificador del Client (deixa en blan per sortir): ")); if (0==id) return;
        List<Encarrec> llista=gestor.cercarEncrrec(id);
        Iterator it= llista.listIterator();
        mostrarDades("Els encarrecs trobats son:\n"+
                "-----------------------------\n");
        while (it.hasNext()){
            Encarrec e=(Encarrec) it.next();
            mostrarDades(e.toString()+"\n");
        }
    }
    private void cercarEncarrecComplet() throws Exception{
        int id=Integer.parseInt(entrarDades("Introdueix el identificador del Client (deixa en blan per sortir): ")); if (0==id) return;
        List<String> llista=gestor.cercarEncarrecComplet(id);
        Iterator it= llista.listIterator();
        mostrarDades("Els encarrecs trobats son:\n"+
                "-----------------------------\n");
        while (it.hasNext()){
            String s=(String) it.next();
            mostrarDades(s+"\n");
        }
    }

    //Listado de todos los productos de la base de datos
    private void llistarProductes() throws Exception{
        List<Producte> llista=gestor.llistarProductes();
        Iterator it= llista.listIterator();
        mostrarDades("Productes donats de alta actualment:\n"+
                "-----------------------------\n");
        while (it.hasNext()){
            Producte p=(Producte) it.next();
            mostrarDades(p.toString()+"\n");
        }
    }

    //Agregar un nuevo cliente
    public void afegirClient() throws Exception{
        mostrarDades("Introdueix dades del nou client (deixaen blanc per sortir).\n");
        String nom=entrarDades("Nom: "); if (null==nom) return;
        String apostal=entrarDades("Adreça postal: "); if (null==apostal) return;
        String aelectronica=entrarDades("E-mail: "); if (null==aelectronica) return;
        String telefon=entrarDades("Telefon: "); if (null==telefon) return;
        int id = gestor.obtenirNouIDClient();
        gestor.afegirClient(new Client(id,nom,apostal,aelectronica,telefon));
        mostrarDades("Operació completada satisfactoriament.\n");
    }

    //Agregar un nuevo encargo
    //Para poder introducir fechas en la base de datos, llamamos a un convertidor de fechas en el gesto DB y le pasamos
    // como parametro una fecha de tipo Date.
    public void afegirEncarrec()throws Exception{
        mostrarDades("Introdueix dades del nou encarrec (deixa en blac per sortir.)\n");
        int id = gestor.obtenirNouIDEncarrec();

        //Le damos formato para poder introducir bien la fehca en la base de datos.
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date data =format.parse(entrarDades("Data: ")); if (null==data) return;

        int idClient=Integer.parseInt(entrarDades("Id Client: ")); if (0==idClient) return;

        encarrecProductes(id);

        gestor.afegirEncarrec(new Encarrec(id,gestor.covert(data),idClient));
        mostrarDades("Operació completada satisfactoriament.\n");
    }

    //Añade un producto a la base de datos
    public void afegirProducte()throws Exception{
        mostrarDades("Itrodueix dades del nou producte (deixaen blac per sortir.)\n");

        int id= gestor.obtenirNouIDProducte();

        String nom=entrarDades("Nom: "); if (null==nom) return;
        float preu=Float.parseFloat(entrarDades("Preu (Sense moneda): ")); if (0==preu) return;
        int stock=Integer.parseInt(entrarDades("Stok inicial: ")); if (0==stock) return;

        gestor.afegirProducte(new Producte(id,nom,preu,stock));
        mostrarDades("Operació completada satisfactoriament.\n");
    }

    public void eliminarEncarrec()throws Exception{
        int idEncarrec=Integer.parseInt(entrarDades("Escriu l'identficador del encarrec:"));
        gestor.eliminarEncarrec(idEncarrec);
        mostrarDades("Operació completada satisfactoriament.\n");
    }
    //Añadimos por cada producto que se llevan una entrada en la tabla EncargoProductos
    private void encarrecProductes(int idEncarrec) throws Exception{
        String producte= entrarDades("Escriu un producte: "); if (null==producte) return;
        int quantitat=Integer.parseInt(entrarDades("Quantitat: ")); if (0==quantitat) return;
        gestor.afegirEncarrecProducte(idEncarrec,producte,quantitat);
        boolean exit=false;
        while (!exit){
            producte=entrarDades("Escriu un altre producte(deixa en blanc per continua): "); if (null==producte) return;
            quantitat=Integer.parseInt(entrarDades("Quantitat: ")); if (0==quantitat) return;
            gestor.afegirEncarrecProducte(idEncarrec,producte,quantitat);
        }
    }

    private void menuEncarrec() throws Exception{
        int opcio;
        while (0!=(opcio=textMenuEcarrec())){
            try {
                switch (opcio){
                    case 1:
                        cercarEncarrecComplet();
                        break;
                    case 2:
                        cercarEncarrecReduit();
                        break;
                    default: mostrarDades("Opció incorrecta\n");
                    case 3:
                        return;
                }
            }catch (Exception e){
                mostrarDades("S'ha produit un error: "+e+"\n");
            }
        }

    }
    private int textMenuEcarrec() throws Exception{
        String menu="\nSelecciona el modo de visualizació\n"+"[1] Modo Complet\n"+
                "[2] Modo Reduit\n"+"[3] Sortir\n"+"Opcio>";
        String lin=entrarDades(menu);
        try {
            int opcio=Integer.parseInt(lin);
            return opcio;
        }catch (Exception e){
            return -1;
        }
    }

    //Main
    public static void main(String[] args) throws Exception {
    GestorEncarrecs gbd=new GestorEncarrecs();
    gbd.start();
    }
}
