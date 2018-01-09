package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 30/10/2017.
 */

public class DataMenuProduct {
    private int Gambar;
    private String Judul,Harga;

    public DataMenuProduct() {
    }

    public DataMenuProduct(int gambar, String judul, String harga) {
        Gambar = gambar;
        Judul = judul;
        Harga = harga;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}
