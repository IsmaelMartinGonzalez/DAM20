package Recursos;

/**
 * Project name: DAM20/Recursos
 * Filename: Numeros
 * Created:  18/11/2020 / 10:49
 * Description: En esta clase ira  implementado todo lo relacionado con numeros, como por ejemplo generar numeros
 *              aleatorios
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.0
 */
public class Numeros {
//Attriubutes
//Builder
//Getters/Setters
//Other Methods
public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
    int num = (int)Math.floor(Math.random() * (minimo - maximo + 1) + (maximo + 1));
    return num;
}
}
