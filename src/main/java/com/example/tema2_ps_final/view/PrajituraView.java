package com.example.tema2_ps_final.view;

import com.example.tema2_ps_final.viewmodel.PrajituraViewModel;
import com.example.tema2_ps_final.viewmodel.dto.PrajituraDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PrajituraView {
    private final PrajituraViewModel viewModel = new PrajituraViewModel();
    public Button updateButton;
    public Button deleteButton;
    public Button clearFieldsButton;
    public Button addButton;
    public Button searchButton;
    public Button availabilityButton;
    public Button validityButton;

    @FXML private TableView<PrajituraDTO> cakeTable;

    @FXML private TableColumn<PrajituraDTO, String> numePrajituraColumn;
    @FXML private TableColumn<PrajituraDTO, String> descriereColumn;
    @FXML private TableColumn<PrajituraDTO, Integer> cofetarieIdColumn;
    @FXML private TableColumn<PrajituraDTO, Double> pretColumn;
    @FXML private TableColumn<PrajituraDTO, LocalDate> dataExpirareColumn;
    @FXML private TableColumn<PrajituraDTO, LocalDate> dataProductieColumn;
    @FXML private TableColumn<PrajituraDTO, String> imagineColumn;

    @FXML private TextField numePrajituraField;
    @FXML private TextField descriereField;
    @FXML private TextField cofetarieIdField;
    @FXML private TextField pretField;
    @FXML private TextField dataExpirareField;
    @FXML private TextField dataProductieField;
    @FXML private TextField imagineField;
    @FXML private TextField availabilityField;
    @FXML private TextField validityField;
    @FXML private Label messageLabel;


    @FXML private TextField searchField;

    @FXML
    public void initialize() {

        numePrajituraColumn.setCellValueFactory(new PropertyValueFactory<>("nume_prajitura"));
        descriereColumn.setCellValueFactory(new PropertyValueFactory<>("descriere"));
        cofetarieIdColumn.setCellValueFactory(new PropertyValueFactory<>("cofetarie_id"));
        pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));
        dataExpirareColumn.setCellValueFactory(new PropertyValueFactory<>("data_expirare"));
        dataProductieColumn.setCellValueFactory(new PropertyValueFactory<>("data_productie"));
        imagineColumn.setCellValueFactory(new PropertyValueFactory<>("imagine"));

        cakeTable.setItems(viewModel.getCakeList());

        numePrajituraField.textProperty().bindBidirectional(viewModel.nameProperty());
        descriereField.textProperty().bindBidirectional(viewModel.descriereProperty());

        cofetarieIdField.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setCofetarieId(newValue);
        });

        pretField.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.updatePret(newValue);
        });

        dataExpirareField.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDataExpirare(newValue);
        });

        dataProductieField.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDataProductie(newValue);
        });

        imagineField.textProperty().bindBidirectional(viewModel.imagineProperty());

        viewModel.selectedCakeProperty().bind(cakeTable.getSelectionModel().selectedItemProperty());

        updateButton.onActionProperty().bind(viewModel.getUpdateCommand());

        addButton.setOnAction(event -> {
            viewModel.addCake();
            cakeTable.refresh();
        });

        deleteButton.onActionProperty().bind(viewModel.getDeleteCommand());
        clearFieldsButton.onActionProperty().bind(viewModel.getClearFieldsCommand());

        searchField.textProperty().bindBidirectional(viewModel.searchQueryProperty());
        searchButton.setOnAction(event -> viewModel.searchByName());

        availabilityButton.setOnAction(event -> {
            int cofetarieId = Integer.parseInt(availabilityField.getText());
            viewModel.searchByAvailability(cofetarieId);
        });

        validityButton.setOnAction(event -> {
            int cofetarieId = Integer.parseInt(validityField.getText());
            viewModel.searchByValidity(cofetarieId);
        });
    }

    private void showAlert(String message, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
