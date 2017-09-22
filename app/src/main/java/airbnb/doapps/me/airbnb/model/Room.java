package airbnb.doapps.me.airbnb.model;

/**
 * Created by 0x7b1 on 9/21/17.
 */

public class Room {

    private int imageRoom;
    private String tittleRoom;
    private String descriptionRoom;

    public Room(int imageRoom, String tittleRoom, String descriptionRoom) {
        this.imageRoom = imageRoom;
        this.tittleRoom = tittleRoom;
        this.descriptionRoom = descriptionRoom;
    }

    public int getImageRoom() {
        return imageRoom;
    }

    public void setImageRoom(int imageRoom) {
        this.imageRoom = imageRoom;
    }

    public String getTittleRoom() {
        return tittleRoom;
    }

    public void setTittleRoom(String tittleRoom) {
        this.tittleRoom = tittleRoom;
    }

    public String getDescriptionRoom() {
        return descriptionRoom;
    }

    public void setDescriptionRoom(String descriptionRoom) {
        this.descriptionRoom = descriptionRoom;
    }
}