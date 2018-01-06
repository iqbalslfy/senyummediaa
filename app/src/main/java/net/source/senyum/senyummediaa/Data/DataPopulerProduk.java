package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 06/01/2018.
 */

public class DataPopulerProduk {
    private int ImgProduk;
    private String txtJudul;
    private String txtHarga;

    public DataPopulerProduk() {
    }

    public DataPopulerProduk(int imgProduk, String txtJudul, String txtHarga) {
        ImgProduk = imgProduk;
        this.txtJudul = txtJudul;
        this.txtHarga = txtHarga;
    }

    public int getImgProduk() {
        return ImgProduk;
    }

    public void setImgProduk(int imgProduk) {
        ImgProduk = imgProduk;
    }

    public String getTxtJudul() {
        return txtJudul;
    }

    public void setTxtJudul(String txtJudul) {
        this.txtJudul = txtJudul;
    }

    public String getTxtHarga() {
        return txtHarga;
    }

    public void setTxtHarga(String txtHarga) {
        this.txtHarga = txtHarga;
    }
}
