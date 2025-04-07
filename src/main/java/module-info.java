module com.example.tema2_ps_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

//    requires org.apache.poi.ooxml;
//    requires org.apache.poi.ooxml.schemas;
    requires org.apache.xmlbeans;

    opens com.example.tema2_ps_final to javafx.fxml;
    exports com.example.tema2_ps_final;
    exports com.example.tema2_ps_final.model;
    opens com.example.tema2_ps_final.model to javafx.fxml;
    exports com.example.tema2_ps_final.model.connection;
    opens com.example.tema2_ps_final.model.connection to javafx.fxml;
    opens com.example.tema2_ps_final.viewmodel.dto to javafx.base;

    exports com.example.tema2_ps_final.view;

    opens com.example.tema2_ps_final.view to javafx.fxml;
}