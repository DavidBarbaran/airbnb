package airbnb.doapps.me.airbnb.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by jorgeek on 20/09/17.
 */

public class PlaceItem implements Serializable{

    private int imagePlace;
    private boolean likePlace;
    private String tittlePlace;
    private String descriptionPlace;
    private String pricePlace;
    private int ratingPlace;
    private String calificationPlace;

    /*public PlaceItem(int imagePlace, boolean likePlace, String tittlePlace, String descriptionPlace, String pricePlace, int ratingPlace, String calificationPlace) {
        this.imagePlace = imagePlace;
        this.likePlace = likePlace;
        this.tittlePlace = tittlePlace;
        this.descriptionPlace = descriptionPlace;
        this.pricePlace = pricePlace;
        this.ratingPlace = ratingPlace;
        this.calificationPlace = calificationPlace;
    }*/


    public PlaceItem(){

    }




    public int getImagePlace() {
        return imagePlace;
    }

    public void setImagePlace(int imagePlace) {
        this.imagePlace = imagePlace;
    }

    public boolean isLikePlace() {
        return likePlace;
    }

    public void setLikePlace(boolean likePlace) {
        this.likePlace = likePlace;
    }

    public String getTittlePlace() {
        return tittlePlace;
    }

    public void setTittlePlace(String tittlePlace) {
        this.tittlePlace = tittlePlace;
    }

    public String getDescriptionPlace() {
        return descriptionPlace;
    }

    public void setDescriptionPlace(String descriptionPlace) {
        this.descriptionPlace = descriptionPlace;
    }

    public String getPricePlace() {
        return pricePlace;
    }

    public void setPricePlace(String pricePlace) {
        this.pricePlace = pricePlace;
    }

    public int getRatingPlace() {
        return ratingPlace;
    }

    public void setRatingPlace(int ratingPlace) {
        this.ratingPlace = ratingPlace;
    }

    public String getCalificationPlace() {
        return calificationPlace;
    }

    public void setCalificationPlace(String calificationPlace) {
        this.calificationPlace = calificationPlace;
    }
}