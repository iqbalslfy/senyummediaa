package net.source.senyum.senyummediaa.Data;

/**
 * Created by SONY on 10/01/2018.
 */

public class DataMenuProfile {
    private int ImgMenu;
    private String txtTitile,txtLihat;

    public DataMenuProfile(int imgMenu, String txtTitile, String txtLihat) {
        ImgMenu = imgMenu;
        this.txtTitile = txtTitile;
        this.txtLihat = txtLihat;
    }

    public int getImgMenu() {
        return ImgMenu;
    }

    public void setImgMenu(int imgMenu) {
        ImgMenu = imgMenu;
    }

    public String getTxtTitile() {
        return txtTitile;
    }

    public void setTxtTitile(String txtTitile) {
        this.txtTitile = txtTitile;
    }

    public String getTxtLihat() {
        return txtLihat;
    }

    public void setTxtLihat(String txtLihat) {
        this.txtLihat = txtLihat;
    }

    public DataMenuProfile() {
    }


}
