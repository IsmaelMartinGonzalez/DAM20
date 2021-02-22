package EjerciciosClase.Objetos.coche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name: DAM20/EjerciciosClase.Objetos.coche
 * Filename:
 * Created:  21/02/2021 / 20:57
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
class CotxeSegonaPart_nom_llinatgeTest {

    CotxeSegonaPart_Ismael_MartinGonzalez cM =new CotxeSegonaPart_Ismael_MartinGonzalez("Ferrar","G80",TipusCanvi.CanviManual);
    CotxeSegonaPart_Ismael_MartinGonzalez cA =new CotxeSegonaPart_Ismael_MartinGonzalez("Ferrari","G50",TipusCanvi.CanviAutomatic);
    /**Comprobamos todas las casuisticas de CanviarMarxaManualCotxe*/

    @Test
    void canviarMarxaManualCotxeAturat() {
        assertEquals(Marxes.MarxesManual.N, cM.getMarxesManualActual());
       try{
           cM.canviarMarxaManual(Marxes.MarxesManual.R);
       }catch (Exception e){
           assertEquals("El cotxe està aturat. No pots canviar de marxa",e.getMessage());
       }
    }

    @Test
    void canviarMarxaManualCotxeNoAutomatic(){
        try{
            cM.canviarMarxaAutomatic(Marxes.MarxesAutomatic.R);
        }catch (Exception e){
            assertEquals("Cotxe manual. No pots fer un canvi automàtic",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorMarxa(){
        try{
            cM.arrancarMotor();
            cM.canviarMarxaManual(Marxes.MarxesManual.M1);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualR_N(){
        /**Comprobamos que podemos poner la marcha N desde R*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.R)){
                cM.canviarMarxaManual(Marxes.MarxesManual.N);
            }
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.N, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualN_R_y_N_G1(){
        /**Comprobamos que podemos poner la marcha R desde N*/
        try{
            cM.arrancarMotor();
            cM.canviarMarxaManual(Marxes.MarxesManual.R);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.R, cM.getMarxesManualActual());
        /**Comprobamos que podemos poner la marcha G1 desde N*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
            cM.canviarMarxaManual(Marxes.MarxesManual.G1);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G1, cM.getMarxesManualActual());

    }

    @Test
    void canviarMarxaManualG1_N_y_G1_G2(){
        /**Comprobamos que podemos poner la marcha N desde G1*/
        try{
            cM.arrancarMotor();
            cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.N, cM.getMarxesManualActual());

        /**Comprobamos que podemos poner la marcha G2 desde G1*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
            cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            cM.canviarMarxaManual(Marxes.MarxesManual.G2);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G2, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualG2_G1_y_G2_G3(){
        /**Comprobamos que podemos poner la marcha G1 desde G2*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G1);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G1, cM.getMarxesManualActual());

        /**Comprobamos que podemos poner la marcha G3 desde G2*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G1)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G3);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G3, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualG3_G2_y_G3_G4(){

        /**Comprobamos que podemos poner la marcha G2 desde G3*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G2);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G2, cM.getMarxesManualActual());

        /**Comprobamos que podemos poner la marcha G4 desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G2)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G4);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G4, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualG4_G3_y_G4_G5(){

        /**Comprobamos que podemos poner la marcha G3 desde G4*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G3);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G3, cM.getMarxesManualActual());

        /**Comprobamos que podemos poner la marcha G5 desde G4*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G3)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G5);
        }catch (Exception e){
            fail();
        }
        assertEquals(Marxes.MarxesManual.G5, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualG5_G4_y_G5_G6(){
        /**Comprobamos que podemos poner la marcha G4 desde G5*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G4);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesManual.G4, cM.getMarxesManualActual());

        /**Comprobamos que podemos poner la marcha G6 desde G5*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G4)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G6);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesManual.G6, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualG6_G5(){
        /**Comprobamos que podemos poner la marcha G5 desde G6*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G5);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesManual.G5, cM.getMarxesManualActual());
    }

    @Test
    void canviarMarxaManualErrorN(){

        /**Comprobamos que no podemos poner la marcha G2 desde N*/
        try{
            cM.arrancarMotor();
            cM.canviarMarxaManual(Marxes.MarxesManual.G2);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G3 desde N*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G3);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G4 desde N*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G4);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G5 desde N*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G5);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde N*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G6);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorR(){

        /**Comprobamos que no podemos poner la marcha G1 desde R*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.G1);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G2 desde R*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G2);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G3 desde R*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G3);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G4 desde R*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G4);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G5 desde R*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G5);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde R*/
        try{
            cM.canviarMarxaManual(Marxes.MarxesManual.G6);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG1(){

        /**Comprobamos que no podemos poner la marcha R desde G1*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.R);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G3 desde G1*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G1)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G4 desde G1*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G1)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G5 desde G1*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G1)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde G1*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G1)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG2(){

        /**Comprobamos que no podemos poner la marcha N desde G2*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha R desde G2*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G2)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G4 desde G2*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G2)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G5 desde G2*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G2)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde G2*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G2)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG3(){

        /**Comprobamos que no podemos poner la marcha N desde G3*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha R desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G3)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G1 desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G3)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G5 desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G3)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G3)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG4(){

        /**Comprobamos que no podemos poner la marcha N desde G4*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha R desde G4*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G4)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G1 desde G4*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G4)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G2 desde G3*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G4)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G6 desde G1*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G4)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG5(){

        /**Comprobamos que no podemos poner la marcha N desde G5*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha R desde G5*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G5)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G1 desde G5*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G5)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G2 desde G5*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G5)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G3 desde G5*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G5)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualErrorG6(){

        /**Comprobamos que no podemos poner la marcha N desde G6*/
        try{
            cM.arrancarMotor();
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.N)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
                cM.canviarMarxaManual(Marxes.MarxesManual.G5);
                cM.canviarMarxaManual(Marxes.MarxesManual.G6);
            }else {
                fail();
            }
            cM.canviarMarxaManual(Marxes.MarxesManual.N);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha R desde G6*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G6)){
                cM.canviarMarxaManual(Marxes.MarxesManual.R);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G1 desde G6*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G6)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G1);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G2 desde G6*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G6)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G2);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G3 desde G6*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G6)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G3);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }

        /**Comprobamos que no podemos poner la marcha G4 desde G6*/
        try{
            if (cM.getMarxesManualActual().equals(Marxes.MarxesManual.G6)){
                cM.canviarMarxaManual(Marxes.MarxesManual.G4);
            }else {
                fail();
            }
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    /**Comprobamos todas las casuisticas de CanviarMarxaAutimatica*/

    @Test
    void canviarMarxaAutomaticCotxeAturat() {

        try{
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.N);
        }catch (Exception e){
            assertEquals("El cotxe està aturat. No pots canviar de marxa",e.getMessage());
        }
    }

    @Test
    void canviarMarxaManualCotxeNoManual(){
        try{
            cA.canviarMarxaManual(Marxes.MarxesManual.R);
        }catch (Exception e){
            assertEquals("Cotxe automàtic. No pots fer un canvi manual",e.getMessage());
        }
    }

    @Test
    void canviarMarxaAutomaticErrorMarxa(){
        try{
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.M1);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaAutomaticN_R_y_N_F(){
        try {
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.R);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesAutomatic.R, cA.getMarxesAutomaticActual());

        try{
            if (cA.getMarxesAutomaticActual().equals(Marxes.MarxesAutomatic.R)){
                cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.N);
                cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.F);
            }else {
                fail();
            }
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesAutomatic.F, cA.getMarxesAutomaticActual());
    }

    @Test
    void canviarMarxaAutomaticR_N(){
        try {
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.R);
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.N);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesAutomatic.N, cA.getMarxesAutomaticActual());
    }

    @Test
    void canviarMarxaAutomaticF_N(){
        try {
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.F);
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.N);
        }catch (Exception e){
            e.getMessage();
            fail();
        }
        assertEquals(Marxes.MarxesAutomatic.N, cA.getMarxesAutomaticActual());
    }

    @Test
    void canviarMarxaAutomaticErrorR(){
        try {
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.R);
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.F);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }

    @Test
    void canviarMarxaAutomaticErrorF(){
        try {
            cA.arrancarMotor();
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.F);
            cA.canviarMarxaAutomatic(Marxes.MarxesAutomatic.R);
        }catch (Exception e){
            assertEquals("Marxa incorrecta",e.getMessage());
        }
    }
}