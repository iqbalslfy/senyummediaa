package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 08/01/2018.
 */

public class DataRekomendasi {
    private int ImgRekomenasi;
    private String txtJudul;
    private String txtHarga;

    public DataRekomendasi() {
    }

    public DataRekomendasi(int imgRekomenasi, String txtJudul, String txtHarga) {
        ImgRekomenasi = imgRekomenasi;
        this.txtJudul = txtJudul;
        this.txtHarga = txtHarga;
    }

    public int getImgRekomenasi() {
        return ImgRekomenasi;
    }

    public void setImgRekomenasi(int imgRekomenasi) {
        ImgRekomenasi = imgRekomenasi;
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
