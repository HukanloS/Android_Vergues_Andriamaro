package org.esiea.vergues_andriamaro.legrandprojet.model;

public class JSONmh4u {

    private String en_name;
    private String jp_name;
    private String fr_name;
    private String img_url;

    public JSONmh4u() {
    }

    public JSONmh4u(String en_name, String jp_name, String fr_name, String img_url) {
        this.en_name = en_name;
        this.jp_name = jp_name;
        this.fr_name = fr_name;
        this.img_url = img_url;
    }


    public String getEn_name() {
        return en_name;
    }

    public String getJp_name() {
        return jp_name;
    }

    public String getFr_name() {
        return fr_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public void setJp_name(String jp_name) {
        this.jp_name = jp_name;
    }

    public void setFr_name(String fr_name) {
        this.fr_name = fr_name;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
