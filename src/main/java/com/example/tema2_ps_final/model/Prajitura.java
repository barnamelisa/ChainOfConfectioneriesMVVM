package com.example.tema2_ps_final.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Prajitura implements Serializable {
    private int prajitura_id;
    private String nume_prajitura;
    private String descriere;
    private int cofetarie_id;
    private BigDecimal pret;
    private LocalDate data_expirare;
    private LocalDate data_productie;
    private String imagine;

    public Prajitura(int id, String name, String descriere, int cofetarie_id, BigDecimal pret, LocalDate data_productie, LocalDate data_expirare, String imagineUrl) {
        this.prajitura_id = id;
        this.nume_prajitura = name;
        this.descriere = descriere;
        this.cofetarie_id = cofetarie_id;
        this.pret = pret;
        this.data_productie = data_productie;
        this.data_expirare = data_expirare;
        this.imagine =  imagineUrl;
    }

    public Prajitura(String name, String descriere, int cofetarie_id, BigDecimal pret, LocalDate data_productie, LocalDate data_expirare, String imagineUrl) {
        this.nume_prajitura = name;
        this.descriere = descriere;
        this.cofetarie_id = cofetarie_id;
        this.pret = pret;
        this.data_productie = data_productie;
        this.data_expirare = data_expirare;
        this.imagine =  imagineUrl;
    }


    public Prajitura() {
    }

    public int getId() {
        return prajitura_id;
    }

    public String getNume_prajitura() {
        return nume_prajitura;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getCofetarie_id() {
        return cofetarie_id;
    }

    public BigDecimal getPret() {
        return pret;
    }

    public LocalDate getData_expirare() {
        return data_expirare;
    }

    public LocalDate getData_productie() {
        return data_productie;
    }
    public String getImagine() {
        return imagine;
    }

    public void setPrajitura_id(int prajitura_id) {
        this.prajitura_id = prajitura_id;
    }

    public void setNume_prajitura(String nume_prajitura) {
        this.nume_prajitura = nume_prajitura;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setCofetarie_id(int cofetarie_id) {
        this.cofetarie_id = cofetarie_id;
    }

    public void setPret(BigDecimal pret) {
        this.pret = pret;
    }

    public void setData_expirare(LocalDate data_expirare) {
        this.data_expirare = data_expirare;
    }

    public void setData_productie(LocalDate data_productie) {
        this.data_productie = data_productie;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    @Override
    public String toString() {
        return "Prajitura [id=" + prajitura_id + ", name=" + nume_prajitura + ", descriere=" + descriere +
                ", cofetarie_id=" + cofetarie_id + ", pret=" + pret +
                ", data_productie=" + data_productie + ", data_expirare=" + data_expirare + "]";
    }

}
