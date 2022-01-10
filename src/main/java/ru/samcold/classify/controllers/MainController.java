package ru.samcold.classify.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainController {

    @FXML
    private Button rorBtn;

    @FXML
    private Button groupBtn;

    @FXML
    private StackPane containerPane;

    @FXML
    public void initialize() {
//        groupParent = fxWeaver.loadView(OperatingModeController.class);
//
//        groupBtn.setOnAction(event -> showView.show(
//                containerPane,
//                groupParent,
//                AnimationDirection.HORIZONTAL));
//
//        rorBtn.setOnAction(event -> {
//            readFromFile();
//        });
    }

}
