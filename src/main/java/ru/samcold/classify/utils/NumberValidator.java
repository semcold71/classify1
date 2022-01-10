package ru.samcold.classify.utils;

import javafx.scene.control.TextField;

public class NumberValidator {
    // region singleton
    private static NumberValidator INSTANCE;

    private NumberValidator() {
    }

    public static NumberValidator getInstance() {
        if (INSTANCE == null) {
            synchronized (NumberValidator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NumberValidator();
                }
            }
        }
        return INSTANCE;
    }
    // endregion singleton

    public void DoubleValidator(TextField tf) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")) {
                tf.setText(oldValue);
            }
        });
    }

    public void IntegerValidator(TextField tf, int min, int max) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]*")) {
                tf.setText(oldValue);
            }
            if (Integer.parseInt(newValue) > max || Integer.parseInt(newValue) < min) {
                tf.setText(oldValue);
            }
        });
    }

}
