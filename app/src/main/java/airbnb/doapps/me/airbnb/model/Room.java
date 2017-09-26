package airbnb.doapps.me.airbnb.model;

/**
 * Created by 0x7b1 on 9/21/17.
 */

public class Room {

    private int image;
    private String tittle;
    private String description;

    public Room(int image, String tittle, String description) {
        this.image = image;
        this.tittle = tittle;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}