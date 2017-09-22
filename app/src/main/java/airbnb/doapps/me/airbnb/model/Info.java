package airbnb.doapps.me.airbnb.model;

/**
 * Created by 0x7b1 on 9/21/17.
 */

public class Info {

    private String info;
    private int imageInfo;

    public Info(String info, int imageInfo) {
        this.info = info;
        this.imageInfo = imageInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(int imageInfo) {
        this.imageInfo = imageInfo;
    }
}