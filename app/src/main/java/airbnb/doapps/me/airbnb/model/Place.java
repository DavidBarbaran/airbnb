package airbnb.doapps.me.airbnb.model;

import java.io.Serializable;

/**
 * Created by jorgeek on 20/09/17.
 */

public class Place implements Serializable{

    private int image;
    private boolean like;
    private String title;
    private String description;
    private String price;
    private int rating;
    private String calification;

    public Place(int image, boolean like, String title, String description, String price, int rating, String calification) {
        this.image = image;
        this.like = like;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.calification = calification;
    }

    public Place(){
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCalification() {
        return calification;
    }

    public void setCalification(String calification) {
        this.calification = calification;
    }
}