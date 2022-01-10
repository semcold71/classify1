module ru.samcold.classify {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ru.samcold.classify to javafx.fxml;
    exports ru.samcold.classify;
    exports ru.samcold.classify.controllers;
    opens ru.samcold.classify.controllers to javafx.fxml;
}