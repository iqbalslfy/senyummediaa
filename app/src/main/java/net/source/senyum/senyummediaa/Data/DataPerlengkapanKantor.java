package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 14/12/2017.
 */

public class DataPerlengkapanKantor {

    private int Gambar;
    private String judul,harga;

    public DataPerlengkapanKantor() {
    }

    public DataPerlengkapanKantor(int gambar, String judul, String harga) {
        Gambar = gambar;
        this.judul = judul;
        this.harga = harga;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
