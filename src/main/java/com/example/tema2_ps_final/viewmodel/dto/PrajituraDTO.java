package com.example.tema2_ps_final.viewmodel.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrajituraDTO {
    private final int prajitura_id;
    private final String nume_prajitura;
    private final String descriere;
    private final int cofetarie_id;
    private final BigDecimal pret;
    private final LocalDate data_expirare;
    private final LocalDate data_productie;
    private final String imagine;

    public PrajituraDTO(int prajitura_id,String nume_prajitura,String descriere,int cofetarie_id,BigDecimal pret,LocalDate data_expirare,LocalDate data_productie,String imagine) {
        this.prajitura_id=prajitura_id;
        this.nume_prajitura=nume_prajitura;
        this.descriere=descriere;
        this.cofetarie_id=cofetarie_id;
        this.pret=pret;
        this.data_expirare=data_expirare;
        this.data_productie=data_productie;
        this.imagine=imagine;
    }

    public int getPrajitura_id() {
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

    @Override
    public String toString() {
        return "PrajituraDTO{" +
                "prajitura_id=" + prajitura_id +
                ", nume_prajitura='" + nume_prajitura + '\'' +
                ", descriere='" + descriere + '\'' +
                ", cofetarie_id=" + cofetarie_id +
                ", pret=" + pret +
                ", data_expirare=" + data_expirare +
                ", data_productie=" + data_productie +
                ", imagine='" + imagine + '\'' +
                '}';
    }
}
