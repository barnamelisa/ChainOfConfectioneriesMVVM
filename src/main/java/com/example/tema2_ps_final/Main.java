package com.example.tema2_ps_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Parent cakeView;
    private Parent confectionariesView;
    private Parent csvDocView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        try {
            cakeView = loadFXML("/com/example/tema2_ps_final/PrajituraView.fxml");
            confectionariesView = loadFXML("/com/example/tema2_ps_final/ConfectionaryView.fxml");
            csvDocView = loadFXML("/com/example/tema2_ps_final/CsvDocView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create menu buttons
        Button buttonCakes = new Button("Cakes");
        Button buttonConfectionaries = new Button("Confectionaries");
        Button buttonCsvDoc = new Button("CSV and Doc");

        // Set button actions to switch views
        buttonCakes.setOnAction(e -> root.setCenter(cakeView));
        buttonConfectionaries.setOnAction(e -> root.setCenter(confectionariesView));
        buttonCsvDoc.setOnAction(e -> root.setCenter(csvDocView));

        // Create top menu bar
        HBox menuBar = new HBox(20, buttonCakes, buttonConfectionaries, buttonCsvDoc);
        menuBar.setPadding(new Insets(20));
        root.setTop(menuBar);

        // Set initial view (optional: CSV view or blank)
        root.setCenter(csvDocView); // or null

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sweet Treats Management");
        primaryStage.show();
    }

    private Parent loadFXML(String resourcePath) throws IOException {
        var resource = getClass().getResource(resourcePath);
        if (resource == null) {
            throw new IOException("FXML file not found: " + resourcePath);
        }
        return FXMLLoader.load(resource);
    }
}
