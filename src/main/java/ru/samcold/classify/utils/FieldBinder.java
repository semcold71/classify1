package ru.samcold.classify.utils;

import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class FieldBinder {
    // region singleton
    private static FieldBinder INSTANCE;

    private FieldBinder() {
    }

    public static FieldBinder getInstance() {
        if (INSTANCE == null) {
            synchronized (FieldBinder.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FieldBinder();
                }
            }
        }
        return INSTANCE;
    }
    // endregion singleton

    public void bind(TextField field, Property<?> property) {

        if (property.toString().contains("String")) {
            field.textProperty().bindBidirectional((StringProperty) property);

        } else {
            field.textProperty().bindBidirectional((Property<Number>) property, new StringConverter<>() {
                @Override
                public String toString(Number number) {
                    if (property.toString().contains("Integer")) {
                        if (number.intValue() == 0) {
                            return "";
                        } else {
                            return String.valueOf(number);
                        }
                    }
                    if (property.toString().contains("Double")) {
                        if (number.doubleValue() == 0) {
                            return "";
                        } else {
                            return String.valueOf(number);
                        }
                    }
                    return null;
                }

                @Override
                public Number fromString(String s) {
                    if (property.toString().contains("Double")) {
                        return Double.parseDouble(s);
                    } else if (property.toString().contains("Integer")) {
                        return Integer.parseInt(s);
                    }
                    return null;
                }
            });
        }
    }
}
