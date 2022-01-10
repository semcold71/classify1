package ru.samcold.classify.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import ru.samcold.classify.MyApplication;
import ru.samcold.classify.domain.Group;
import ru.samcold.classify.utils.ShowView;

import java.io.IOException;

public class MainController {

    @FXML
    private Button rorBtn;

    @FXML
    private Button groupBtn;

    @FXML
    private StackPane containerPane;

    private final ShowView showView = ShowView.getInstance();
    private Parent groupParent;


    @FXML
    public void initialize() {
        initButton();
        createParents("group-view.fxml");
        //createParents("ror-view.fxml");
    }

    private void createParents(String fxml) {
        FXMLLoader loader = new FXMLLoader(MyApplication.class.getResource(fxml));
        try {
            groupParent = loader.load();
            GroupController controller = loader.getController();
            controller.initialize(new Group());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initButton() {
        groupBtn.setOnAction(event -> showView.show(containerPane, groupParent));

    }

}
