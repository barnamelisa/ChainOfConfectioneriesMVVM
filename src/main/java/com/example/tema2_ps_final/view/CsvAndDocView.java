package com.example.tema2_ps_final.view;

import com.example.tema2_ps_final.viewmodel.CsvAndDocViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CsvAndDocView {

    private final CsvAndDocViewModel viewModel = new CsvAndDocViewModel();

    @FXML private TextField cofetarieIdField;
    @FXML private Button generateButton;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        cofetarieIdField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                viewModel.idCofetarieProperty().set(Integer.parseInt(newVal));
            } catch (NumberFormatException e) {
                statusLabel.setText("ID invalid");
            }
        });

        generateButton.setOnAction(event -> viewModel.handleGenerateFiles());
    }
}
