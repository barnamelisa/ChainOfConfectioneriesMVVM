package com.example.tema2_ps_final.model;

import java.io.Serializable;

public class PrajituraDinCofetarie implements Serializable {
    private int id_cofetarie;
    private int prajitura_id;
    private int stocPrajituraDinCofetarie;

    public PrajituraDinCofetarie(int prajitura_id, int id_cofetarie, int cantitate_comandata){
        this.prajitura_id =prajitura_id;
        this.id_cofetarie =id_cofetarie;
        this.stocPrajituraDinCofetarie =cantitate_comandata;
    }
    public PrajituraDinCofetarie(){

    }

    public int getId_cofetarie() {
        return id_cofetarie;
    }

    public int getStocPrajituraDinCofetarie() {
        return stocPrajituraDinCofetarie;
    }

    public int getPrajitura_id() {
        return prajitura_id;
    }

    public void setStocPrajituraDinCofetarie(int stocPrajituraDinCofetarie) {
        this.stocPrajituraDinCofetarie = stocPrajituraDinCofetarie;
    }

    public void setPrajitura_id(int prajitura_id) {
        this.prajitura_id = prajitura_id;
    }

    public void setId_cofetarie(int id_cofetarie) {
        this.id_cofetarie = id_cofetarie;
    }

    @Override
    public String toString() {
        return "Student [produs id=" + id_cofetarie + ", client id=" + prajitura_id + ", cantitate comandata=" + stocPrajituraDinCofetarie + "]";
    }
}
