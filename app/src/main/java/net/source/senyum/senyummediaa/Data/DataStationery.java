package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 30/10/2017.
 */

public class DataStationery {
    private int Gambar;
    private String Nama_toko,harga,hargasebpotongan;

    public DataStationery() {
    }

    public DataStationery(int gambar, String nama_toko, String harga, String hargasebpotongan) {
        Gambar = gambar;
        Nama_toko = nama_toko;
        this.harga = harga;
        this.hargasebpotongan = hargasebpotongan;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public String getNama_toko() {
        return Nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        Nama_toko = nama_toko;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getHargasebpotongan() {
        return hargasebpotongan;
    }

    public void setHargasebpotongan(String hargasebpotongan) {
        this.hargasebpotongan = hargasebpotongan;
    }
}
