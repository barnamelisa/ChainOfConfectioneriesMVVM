package com.example.tema2_ps_final.viewmodel;

import com.example.tema2_ps_final.model.Prajitura;
import com.example.tema2_ps_final.model.repository.CakeRepository;
import com.example.tema2_ps_final.viewmodel.dto.PrajituraDTO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PrajituraViewModel {
    private final CakeRepository repository;

    // Observable properties
    private final ObservableList<PrajituraDTO> cakeList = FXCollections.observableArrayList();
    private final StringProperty nume_prajitura = new SimpleStringProperty();
    private final StringProperty descriere = new SimpleStringProperty();
    private final IntegerProperty cofetarie_id = new SimpleIntegerProperty();
    private final ObjectProperty<BigDecimal> pret = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> data_expirare = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> data_productie = new SimpleObjectProperty<>();
    private final StringProperty imagine = new SimpleStringProperty();
    private final ObjectProperty<PrajituraDTO> selectedCake = new SimpleObjectProperty<>();
    private final StringProperty searchQuery = new SimpleStringProperty();

    // Commands
    private final Command updateCommand;
    private final Command addCommand;
    //private final Command updateCommand;
    private final Command deleteCommand;
    private final Command clearFieldsCommand;
    private final Command searchCommand;

    public PrajituraViewModel() {
        this.repository = CakeRepository.getInstance();

        loadCakes();
        setupListeners();

        this.addCommand = new Command(this::addCake);
        this.updateCommand = new Command(this::updateCake);
        this.deleteCommand = new Command(this::deleteCake);
        this.clearFieldsCommand = new Command(this::clearFields);
        this.searchCommand = new Command(this::searchByName);

        searchQuery.addListener((observable, oldValue, newValue) -> {
            filterCakesBySearchQuery(newValue);
        });

        selectedCake.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nume_prajitura.set(newValue.getNume_prajitura());
                descriere.set(newValue.getDescriere());
                cofetarie_id.set(newValue.getCofetarie_id());
                pret.set(newValue.getPret());
                data_expirare.set(newValue.getData_expirare());
                data_productie.set(newValue.getData_productie());
                imagine.set(newValue.getImagine());
            }
        });

    }
    private void filterCakesBySearchQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            loadCakes(); // If no query, load all cakes
        } else {
            List<PrajituraDTO> filteredList = cakeList.stream()
                    .filter(cake -> cake.getNume_prajitura().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
            cakeList.setAll(filteredList);
        }
    }

    public void loadCakes() {
        List<PrajituraDTO> dtos = repository.getTableContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        cakeList.setAll(dtos);
    }
    private PrajituraDTO convertToDTO(Prajitura prajitura) {
        return new PrajituraDTO(prajitura.getId(),prajitura.getNume_prajitura(),prajitura.getDescriere(),prajitura.getCofetarie_id(),prajitura.getPret(),prajitura.getData_expirare(),prajitura.getData_productie(),prajitura.getImagine());
    }

    public void searchByName() {
        filterCakesBySearchQuery(searchQuery.get());
    }

    private void updateCakeList(List<Prajitura> cakes) {
        ObservableList<PrajituraDTO> cakeDTOList = FXCollections.observableArrayList();
        for (Prajitura cake : cakes) {
            // Correctly create a PrajituraDTO object from the Prajitura object
            cakeDTOList.add(new PrajituraDTO(
                    cake.getId(),
                    cake.getNume_prajitura(),
                    cake.getDescriere(),
                    cake.getCofetarie_id(),
                    cake.getPret(),
                    cake.getData_expirare(),
                    cake.getData_productie(),
                    cake.getImagine()
            ));
        }
        cakeList.setAll(cakeDTOList);
    }

    public void searchByValidity(int cofetarieId) {
        List<Prajitura> validCakes = repository.findCakesByValidity(cofetarieId, LocalDate.now());

        if (validCakes.isEmpty()) {
            showAlert("No valid cakes", "There are no valid cakes at the moment.", Alert.AlertType.INFORMATION);
            loadCakes();
        } else {
            updateCakeList(validCakes);
        }
    }

    public void searchByAvailability(int cofetarieId) {
        // Căutăm prăjiturile disponibile
        List<Prajitura> availableCakes = repository.findCakesByAvailability(cofetarieId);

        if (availableCakes.isEmpty()) {
            // Dacă nu sunt prăjituri disponibile, afișăm un mesaj și reîncărcăm lista completă
            showAlert("No cakes available", "There are no available cakes at the moment.", Alert.AlertType.INFORMATION);
            loadCakes(); // Reîncarcă toate prăjiturile
        } else {
            // Actualizăm lista cu prăjiturile disponibile
            updateCakeList(availableCakes);
        }
    }

    public StringProperty searchQueryProperty() {
        return searchQuery;
    }

    private void setupListeners() {
        selectedCake.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nume_prajitura.set(newValue.getNume_prajitura());
                descriere.set(newValue.getDescriere());
                cofetarie_id.set(newValue.getCofetarie_id());
                pret.set(newValue.getPret());
                data_expirare.set(newValue.getData_expirare());
                data_productie.set(newValue.getData_productie());
                imagine.set(newValue.getImagine());
            }
        });
    }

    private void clearFields() {
        nume_prajitura.set("");
        descriere.set("");
        cofetarie_id.set(0);
        pret.set(null);
        data_expirare.set(null);
        data_productie.set(null);
        imagine.set("");
    }

    private void deleteCake() {
        if (selectedCake.get() != null && repository.delete(selectedCake.get().getPrajitura_id()) != 0) {
            loadCakes();
            showAlert("Success", "Plant deleted successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Failure", "Failed to delete plant.", Alert.AlertType.ERROR);
        }
    }

    private void updateCake() {
        if (selectedCake.get() == null) return;

        Prajitura prajitura = createCakeFromFields();
        if (prajitura != null) {
            prajitura.setPrajitura_id(selectedCake.get().getPrajitura_id());
            if (repository.update(prajitura) != false) {
                loadCakes();
                showAlert("Success", "Plant updated successfully!", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Failure", "Failed to update plant.", Alert.AlertType.ERROR);
            }
        }
    }

    public void addCake() {
        Prajitura prajitura = createCakeFromFields();
        if (prajitura != null) {
            Prajitura insertedCake = repository.insertCake(prajitura);
            if (insertedCake != null) {
                cakeList.add(convertToDTO(insertedCake));
                showAlert("Success", "Cake added successfully!", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Failure", "Failed to add cake.", Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Failure", "Invalid cake data.", Alert.AlertType.ERROR);
        }
    }

    public void setCofetarieId(String newValue) {
        try {
            if (!newValue.isEmpty()) {
                this.cofetarie_id.set(Integer.parseInt(newValue)); // Convert String to Integer
            } else {
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
    }

    public void setDataExpirare(String newValue) {
        try {
            if (!newValue.isEmpty()) {
                this.data_expirare.set(LocalDate.parse(newValue)); // Convert String to LocalDate
            } else {
                this.data_expirare.set(null); // Handle empty input
            }
        } catch (Exception e) {
            // Handle invalid input
        }
    }
    public void setDataProductie(String newValue) {
        try {
            if (!newValue.isEmpty()) {
                this.data_productie.set(LocalDate.parse(newValue)); // Convert String to LocalDate
            } else {
                this.data_productie.set(null); // Handle empty input
            }
        } catch (Exception e) {
            // Handle invalid input
        }
    }
    public void setPret(String newValue) {
        try {
            if (!newValue.isEmpty()) {
                this.pret.set(new BigDecimal(newValue));
            } else {
                this.pret.set(BigDecimal.ZERO);
            }
        } catch (NumberFormatException e) {
        }
    }
    public void updatePret(String newPret) {
        setPret(newPret);
    }

    private Prajitura createCakeFromFields() {
        try {
            return new Prajitura(nume_prajitura.get(),descriere.get(),cofetarie_id.get(),pret.get(),data_expirare.get(),data_productie.get(),imagine.get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public ObservableList<PrajituraDTO> getCakeList() { return cakeList; }
    public StringProperty nameProperty() { return nume_prajitura; }
    public StringProperty descriereProperty() { return descriere; }
    public IntegerProperty cofetarieIdProperty() { return cofetarie_id; }
    public ObjectProperty<BigDecimal> pretProperty() { return pret; }
    public ObjectProperty<LocalDate> dataExpirareProperty() { return data_expirare; }
    public ObjectProperty<LocalDate> dataProductieProperty() { return data_productie; }
    public StringProperty imagineProperty() { return imagine; }
    public ObjectProperty<PrajituraDTO> selectedCakeProperty() { return selectedCake; }

    public Command getUpdateCommand() {
        return updateCommand;
    }

    public Command getAddCommand() {
        return addCommand;
    }

    public Command getDeleteCommand() {
        return deleteCommand;
    }

    public Command getClearFieldsCommand() {
        return clearFieldsCommand;
    }
}

