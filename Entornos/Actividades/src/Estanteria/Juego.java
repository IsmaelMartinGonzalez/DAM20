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
public class Juego implements Comparable<Juego>{
//Attributes
    private String titulo;
    private String compañia;
    private Integer calificación;

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
@Override
public int compareTo(Juego o) {
    if (o.getCalificación()<calificación){
        return -1;
    }else if (o.calificación<calificación){
        return 0;
    }else {
        return 1;
    }
}

    @Override
    public String toString() {
        return "titulo: '" + titulo + '\'' +
                ", compañia: '" + compañia + '\'' +
                ", calificación: " + calificación;
    }
}
