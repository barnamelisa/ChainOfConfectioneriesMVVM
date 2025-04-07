package com.example.tema2_ps_final.model.repository;

import com.example.tema2_ps_final.model.Prajitura;

import java.io.Serializable;
import java.util.List;

public class CakeRepository extends Repository<Prajitura> implements Serializable {
    private static CakeRepository instance;

    public CakeRepository() {
        super();
    }
    public List<Prajitura> getTableContent() {
        return getTableContent1(); // Uses inherited method
    }

    public static CakeRepository getInstance() {
        if (instance == null) {
            synchronized (CakeRepository.class) {
                if (instance == null) {
                    instance = new CakeRepository();
                }
            }
        }
        return instance;
    }
}
