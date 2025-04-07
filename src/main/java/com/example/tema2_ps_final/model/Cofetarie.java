package com.example.tema2_ps_final.model;

import java.io.Serializable;

public class Cofetarie implements Serializable {
    private int id_cofetarie;
    private String adresa_cofetarie;

    public Cofetarie(int id, String address) {
        super();
        this.id_cofetarie = id;
        this.adresa_cofetarie = address;
    }

    public Cofetarie(String address) {
        super();
        this.adresa_cofetarie = address;
    }
    public Cofetarie(){
    }

    public int getId() {
        return id_cofetarie;
    }

    public void setId(int id) {
        this.id_cofetarie = id;
    }

    public String getAddress() {
        return adresa_cofetarie;
    }

    public void setAddress(String address) {
        this.adresa_cofetarie = address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id_cofetarie + ", address=" + adresa_cofetarie + "]";
    }
}

