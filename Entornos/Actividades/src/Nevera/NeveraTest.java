package Nevera;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name: DAM20/Nevera
 * Filename:
 * Created:  19/02/2021 / 11:41
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
class NeveraTest {

    @Test
    public  void TestNevera(){
        Nevera n=new Nevera();
        String[] compra=new String[]{"Fresa","Leche","Agua","Azucar","Fresa"};
        for (String item : compra) {
            n.put(item);
            assertEquals(true,n.contains(item));
        }
        compra[4]="Bacon";
        for(String item:compra){
            if (n.contains(item)){
                try {
                    n.take(item);
                }catch (NoSuchItemException e){
                    fail("Bacon no esta en la nevera");
                }
            }
        }

    }


}