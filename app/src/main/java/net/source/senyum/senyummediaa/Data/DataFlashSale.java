package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 06/01/2018.
 */

public class DataFlashSale {
    private int ImgFlashSale;
    private String txtHarga;

    public DataFlashSale() {
    }

    public DataFlashSale(int imgFlashSale, String txtHarga) {
        ImgFlashSale = imgFlashSale;
        this.txtHarga = txtHarga;
    }

    public int getImgFlashSale() {
        return ImgFlashSale;
    }

    public void setImgFlashSale(int imgFlashSale) {
        ImgFlashSale = imgFlashSale;
    }

    public String getTxtHarga() {
        return txtHarga;
    }

    public void setTxtHarga(String txtHarga) {
        this.txtHarga = txtHarga;
    }
}
