package ru.samcold.classify.utils;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ShowView {
    // region singleton
    private static ShowView INSTANCE;

    private ShowView() {
    }

    public static ShowView getInstance() {
        if (INSTANCE == null) {
            synchronized (ShowView.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ShowView();
                }
            }
        }
        return INSTANCE;
    }
    // endregion singleton

    public void show(StackPane container, Parent parent) {

            KeyValue kv;

            container.getChildren().add(parent);

            parent.translateXProperty().set(container.getWidth());
            kv = new KeyValue(parent.translateXProperty(), 0, Interpolator.EASE_IN);

            KeyFrame kf = new KeyFrame(Duration.millis(750), kv);

            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(actionEvent -> container.getChildren().remove(0));
            timeline.play();
    }
}
