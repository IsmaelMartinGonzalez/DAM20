package Estanteria;

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
public class Juego {
//Attributes
    String titulo;
    String compañia;
    int calificación;

//Builder
    public Juego(String titulo, String compañia, int calificación) {
        this.titulo = titulo;
        this.compañia = compañia;
        this.calificación = calificación;
    }

//Getters/Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCompañia() {
        return compañia;
    }
    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }
    public int getCalificación() {
        return calificación;
    }
    public void setCalificación(int calificación) {
        this.calificación = calificación;
    }

//Others Methods
}
