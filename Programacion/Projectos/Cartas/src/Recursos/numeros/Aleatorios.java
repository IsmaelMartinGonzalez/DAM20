package Recursos.numeros;
import java.util.Arrays;

public class Aleatorios {
    public static final char[] CARACTERES_ESPECIALES = new char[]{'!', '%', '&', '(', ')', '*', '/', '-', '#', '@'};

    public Aleatorios() {
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int)Math.floor(Math.random() * (double)(minimo - (maximo + 1)) + (double)(maximo + 1));
        return num;
    }

    public static double generaNumeroRealAleatorio(int minimo, int maximo) {
        double num = Math.floor(Math.random() * (double)(minimo - (maximo + 1)) + (double)(maximo + 1));
        return num;
    }

    public static int[] generaNumeroAleatorios(int longitud, int minimo, int maximo) {
        if (longitud < 0) {
            return null;
        } else {
            int[] numeros = new int[longitud];

            for(int i = 0; i < numeros.length; ++i) {
                numeros[i] = generaNumeroAleatorio(minimo, maximo);
            }

            return numeros;
        }
    }

    public static int[] generaNumeroAleatoriosNoRepetidos(int longitud, int minimo, int maximo) {
        if (longitud < 0) {
            return null;
        } else {
            if (maximo < minimo) {
                int aux = minimo;
                minimo = maximo;
                maximo = aux;
            }

            if (maximo - minimo < longitud - 1) {
                return null;
            } else {
                int[] numeros = new int[longitud];
                Arrays.fill(numeros, minimo - 1);
                int i = 0;

                for(boolean var5 = false; i < numeros.length; ++i) {
                    boolean repetido;
                    int num;
                    do {
                        repetido = false;
                        num = generaNumeroAleatorio(minimo, maximo);

                        for(int j = 0; j < numeros.length && !repetido; ++j) {
                            if (numeros[j] == num) {
                                repetido = true;
                            }
                        }
                    } while(repetido);

                    numeros[i] = num;
                }

                return numeros;
            }
        }
    }

    public static char generaLetraMayus() {
        int letra = generaNumeroAleatorio(65, 90);
        return (char)letra;
    }

    public static char generaLetraMinus() {
        int letra = generaNumeroAleatorio(97, 122);
        return (char)letra;
    }

    public static char generaLetraCaracteresEspeciales() {
        int letra = (int)Math.floor(Math.random() * (double)CARACTERES_ESPECIALES.length);
        return CARACTERES_ESPECIALES[letra];
    }

    public static String generaPassword(int longitud) {
        if (longitud <= 0) {
            return null;
        } else {
            String password = "";

            for(int i = 0; i < longitud; ++i) {
                int eleccion = (int)Math.floor(Math.random() * 4.0D);
                switch(eleccion) {
                    case 0:
                        password = password + Integer.toString(generaNumeroAleatorio(0, 9));
                        break;
                    case 1:
                        password = password + generaLetraMayus();
                        break;
                    case 2:
                        password = password + generaLetraMinus();
                        break;
                    case 3:
                        password = password + generaLetraCaracteresEspeciales();
                }
            }

            return password;
        }
    }

    public static int generarNumeroPrimoAzar(int minimo, int maximo) {
        if (Calculo.cuentaPrimosEntre(minimo, maximo) == 0) {
            return -1;
        } else {
            int numPrimo;
            do {
                numPrimo = generaNumeroAleatorio(minimo, maximo);
            } while(!Calculo.esPrimo(numPrimo));

            return numPrimo;
        }
    }

    public static int[] generarNumerosPrimosEntre(int minimo, int maximo) {
        int[] numerosPrimos = new int[Calculo.cuentaPrimosEntre(minimo, maximo)];
        if (numerosPrimos.length == 0) {
            return null;
        } else {
            int i = minimo;

            for(int indice = 0; i < maximo; ++i) {
                if (Calculo.esPrimo(i)) {
                    numerosPrimos[indice] = i;
                    ++indice;
                }
            }

            return numerosPrimos;
        }
    }
}
