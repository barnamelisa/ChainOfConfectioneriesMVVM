package com.example.tema2_ps_final.model.repository;

import com.example.tema2_ps_final.model.Cofetarie;
import com.example.tema2_ps_final.model.Prajitura;

import java.io.Serializable;
import java.util.List;

public class CofetarieRepository extends Repository<Cofetarie> implements Serializable {
    private static CofetarieRepository instance;

    private CofetarieRepository() {
        super();
    }
    public List<Cofetarie> getTableContent() {
        return getTableContent2();
    }

    public static CofetarieRepository getInstance() {
        if (instance == null) {
            synchronized (CakeRepository.class) {
                if (instance == null) {
                    instance = new CofetarieRepository();
                }
            }
        }
        return instance;
    }
}
