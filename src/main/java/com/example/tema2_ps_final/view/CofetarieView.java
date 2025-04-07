package com.example.tema2_ps_final.view;

import com.example.tema2_ps_final.viewmodel.CofetarieViewModel;
import com.example.tema2_ps_final.viewmodel.dto.CofetarieDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CofetarieView {

    private CofetarieViewModel viewModel = new CofetarieViewModel();

    @FXML private TextField adresaCofetarieField;
    @FXML private TableView<CofetarieDTO> cofetarieTable;
    @FXML private TableColumn<CofetarieDTO, String> adresaCofetarieColumn;
    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button clearFieldsButton;
    @FXML private Label messageLabel;

    @FXML
    public void initialize() {

        adresaCofetarieColumn.setCellValueFactory(new PropertyValueFactory<>("adresa_cofetarie"));

        cofetarieTable.setItems(viewModel.getCofetarieList());

        adresaCofetarieField.textProperty().bindBidirectional(viewModel.adresaProperty());

        addButton.setOnAction(event -> {
            viewModel.addCofetarie();
            cofetarieTable.refresh();
        });

        deleteButton.onActionProperty().bind(viewModel.getDeleteCommand());
        updateButton.onActionProperty().bind(viewModel.getUpdateCommand());
        clearFieldsButton.onActionProperty().bind(viewModel.getClearFieldsCommand());
    }


    private void showMessage(String message) {
        messageLabel.setText(message);
    }
}
