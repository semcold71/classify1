package ru.samcold.classify.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import ru.samcold.classify.MyApplication;
import ru.samcold.classify.domain.Group;
import ru.samcold.classify.domain.Proxy;
import ru.samcold.classify.domain.Ror;
import ru.samcold.classify.utils.ShowView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class MainController {

    @FXML
    private Button rorBtn;

    @FXML
    private Button groupBtn;

    @FXML
    private StackPane containerPane;

    private final ShowView showView = ShowView.getInstance();
    private Parent groupParent;
    private Parent rorParent;


    @FXML
    public void initialize() {
        initButton();
        createGroupView();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1500),
                        event -> groupBtn.fire()
                ));
        timeline.play();
    }


    private void createGroupView() {
        FXMLLoader loader = new FXMLLoader(MyApplication.class.getResource("group-view.fxml"));
        try {
            groupParent = loader.load();
            GroupController controller = loader.getController();
            controller.initialize(new Group());
            rorBtn.disableProperty().bind(controller.isCalculatedProperty().not());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createRorView() {
        FXMLLoader loader = new FXMLLoader(MyApplication.class.getResource("ror-view.fxml"));
        try {
            rorParent = loader.load();
            RorController controller = loader.getController();
            controller.initialize(new Ror(readFromFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Proxy readFromFile() {
        Proxy proxy = null;
        try {
            FileInputStream fis = new FileInputStream("group.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            proxy = (Proxy) ois.readObject();
            ois.close();
            return proxy;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return proxy;
    }

    private void initButton() {
        groupBtn.setOnAction(event -> {
            if (!Objects.equals(containerPane.getChildren().get(0).getId(), "group_root"))
                showView.show(containerPane, groupParent);
        });
        rorBtn.setOnAction(event -> {
            if (!Objects.equals(containerPane.getChildren().get(0).getId(), "ror_root")) {
                createRorView();
                showView.show(containerPane, rorParent);
            }
        });
    }
}
