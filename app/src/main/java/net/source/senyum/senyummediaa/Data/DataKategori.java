package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 06/01/2018.
 */

public class DataKategori {
    public int ImgKategori;
    public String txtJudul;

    public DataKategori() {
    }

    public DataKategori(int imgKategori, String txtJudul) {
        ImgKategori = imgKategori;
        this.txtJudul = txtJudul;
    }

    public int getImgKategori() {
        return ImgKategori;
    }

    public void setImgKategori(int imgKategori) {
        ImgKategori = imgKategori;
    }

    public String getTxtJudul() {
        return txtJudul;
    }

    public void setTxtJudul(String txtJudul) {
        this.txtJudul = txtJudul;
    }
}
