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
                        afegirClient();
                        break;
                    case 3:
                        afegirEncarrec();
                        break;
                    case 4:
                        cercarEncarrec();
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
                "[2] Afegir client\n"+"[3] Afegir encarrec\n"+"[0] Sortir\n"+"Opcio>";
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

    //Buscar un elemento de acuerdo con su nombre
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

    private void cercarEncarrec() throws Exception {
        int id=Integer.parseInt(entrarDades("Introdueix el identificador de l'encarrec: ")); if (0==id) return;
        List<Encarrec> llista=gestor.cercarEncrrec(id);
        Iterator it= llista.listIterator();
        mostrarDades("El encarrec trobat es:\n"+
                "-----------------------------\n");
        while (it.hasNext()){
            Encarrec e=(Encarrec) it.next();
            mostrarDades(e.toString()+"\n");
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
    public void afegirEncarrec()throws Exception{
        mostrarDades("Introdueix dades del nou encarrec (deixaen blac per sortir.)\n");
        int id = gestor.obtenirNouIDEncarrec();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date data =format.parse(entrarDades("Data: ")); if (null==data) return;
        int idClient=Integer.parseInt(entrarDades("Id Client: ")); if (0==idClient) return;
        gestor.afegirEncarrec(new Encarrec(id,gestor.covert(data) ,idClient));
        mostrarDades("Operació completada satisfactoriament.\n");
    }
public static void main(String[] args) throws Exception {
    GestorEncarrecs gbd=new GestorEncarrecs();
    gbd.start();
}
}
