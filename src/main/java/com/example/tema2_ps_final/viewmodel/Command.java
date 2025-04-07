package com.example.tema2_ps_final.viewmodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Command extends SimpleObjectProperty<EventHandler<ActionEvent>> {
    public Command(Runnable action) {
        super(event -> action.run());
    }
}
