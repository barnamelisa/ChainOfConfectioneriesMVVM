package com.example.tema2_ps_final.viewmodel.dto;

public class CofetarieDTO {
    private int id_cofetarie;
    private String adresa_cofetarie;

    public CofetarieDTO(int id_cofetarie,String adresa_cofetarie){
        this.id_cofetarie=id_cofetarie;
        this.adresa_cofetarie=adresa_cofetarie;
    }

    public int getId_cofetarie() {
        return id_cofetarie;
    }

    public String getAdresa_cofetarie() {
        return adresa_cofetarie;
    }

    @Override
    public String toString() {
        return "CofetarieDTO{" +
                "id_cofetarie=" + id_cofetarie +
                ", adresa_cofetarie='" + adresa_cofetarie + '\'' +
                '}';
    }
}
