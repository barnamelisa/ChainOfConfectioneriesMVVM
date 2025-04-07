package com.example.tema2_ps_final.viewmodel;

import com.example.tema2_ps_final.model.Prajitura;
import com.example.tema2_ps_final.model.repository.CakeRepository;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.List;

public class CsvAndDocViewModel {
    private final IntegerProperty idCofetarie = new SimpleIntegerProperty();
    private final Command generateFilesCommand;

    private final CakeRepository repository;

    public CsvAndDocViewModel() {
        this.repository = new CakeRepository();
        this.generateFilesCommand = new Command(this::handleGenerateFiles);
    }

    public void handleGenerateFiles() {
        int id = idCofetarie.get();

        if (!repository.checkCofetarieExists(id)) {
            showAlert("Eroare", "Cofetăria cu ID-ul " + id + " nu există!", Alert.AlertType.ERROR);
            return;
        }

        List<Prajitura> prajituri = repository.findExpiredOrOutOfStockCakes(id, LocalDate.now());

        if (prajituri.isEmpty()) {
            showAlert("Info", "Nu sunt prăjituri expirate sau fără stoc.", Alert.AlertType.INFORMATION);
            return;
        }

        repository.createCSV(prajituri);
      //  repository.savePrajituraToDoc(prajituri, "fisier_prajituri.doc");

        showAlert("Succes", "Fișierele CSV și DOC au fost generate!", Alert.AlertType.INFORMATION);
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public IntegerProperty idCofetarieProperty() {
        return idCofetarie;
    }

    public Command getGenerateFilesCommand() {
        return generateFilesCommand;
    }
}
