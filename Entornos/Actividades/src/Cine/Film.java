package Cine;

/**
 * Project name: DAM20/Cine
 * Filename:
 * Created:  18/01/2021 / 20:13
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Film {
    //Attriubutes
    private  String title;
    private int duration;
    private int minAge;
    private String director;
    //Builder

    public Film(String title, int duration, int minAge, String director) {
        this.title = title;
        this.duration = duration;
        this.minAge = minAge;
        this.director = director;
    }

    //Getters/Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //Methods

    @Override
    public String toString() {
        return "'"+getTitle()+"' del director "+getDirector()+", con una duración de "+getDuration()+" minutos y la edad minima es de "+
                minAge+"años";
    }
}
