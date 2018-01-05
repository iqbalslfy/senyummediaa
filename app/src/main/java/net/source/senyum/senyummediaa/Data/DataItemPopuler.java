package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 05/01/2018.
 */

public class DataItemPopuler  {
    private int ImageID;
    private String tvJudul;

    public DataItemPopuler() {

    }

    public DataItemPopuler(int imageID, String tvJudul) {
        this.ImageID = imageID;
        this.tvJudul = tvJudul;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getTvJudul() {
        return tvJudul;
    }

    public void setTvJudul(String tvJudul) {
        this.tvJudul = tvJudul;
    }
}
