package ru.samcold.classify.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import ru.samcold.classify.MyApplication;
import ru.samcold.classify.domain.Group;
import ru.samcold.classify.domain.Proxy;
import ru.samcold.classify.utils.Decor;
import ru.samcold.classify.utils.FieldBinder;
import ru.samcold.classify.utils.NumberValidator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class GroupController {

    private Group group;
    private final FieldBinder binder = FieldBinder.getInstance();
    private final Decor decor = Decor.getInstance();
    private final NumberValidator numberValidator = NumberValidator.getInstance();

    // region FXML
    @FXML
    private Label warningLbl;

    @FXML
    private TitledPane inputPane;

    @FXML
    private TitledPane outputPane;

    @FXML
    private TextField pNomTxt;

    @FXML
    private TextField pMaxTxt;

    @FXML
    private TextField daysCountTxt;

    @FXML
    private TextField pDayTxt;

    @FXML
    private TextField ageTxt;

    @FXML
    private TextField p025Txt;

    @FXML
    private TextField p05Txt;

    @FXML
    private TextField p075Txt;

    @FXML
    private TextField p1Txt;

    @FXML
    private TextField pYearTxt;

    @FXML
    private TextField pMidTxt;

    @FXML
    private TextField nTxt;

    @FXML
    private TextField uTxt;

    @FXML
    private TextField kpTxt;

    @FXML
    private TextField qTxt;

    @FXML
    private TextField aIsoTxt;

    @FXML
    private TextField aGgtnTxt;

    @FXML
    private Button calcBtn;

    @FXML
    private Button wordBtn;
    // endregion

    private final BooleanProperty isCalculated = new SimpleBooleanProperty();

    public BooleanProperty isCalculatedProperty() {
        return isCalculated;
    }

    @FXML
    void initialize(Group group) {
        this.group = group;
        // Test
        group.pNomProperty().set(6.3);
        group.pMaxProperty().set(6.3);
        group.daysCountProperty().set(100);
        group.pDayProperty().set(10);
        group.ageProperty().set(34);
        group.p025Property().set(70);
        group.p05Property().set(20);
        group.p075Property().set(5);
        group.p1Property().set(5);

        initFields();
        initValidators();
        initButtons();
    }

    private void initFields() {
        binder.bind(pNomTxt, group.pNomProperty());
        binder.bind(pMaxTxt, group.pMaxProperty());
        binder.bind(daysCountTxt, group.daysCountProperty());
        binder.bind(pDayTxt, group.pDayProperty());
        binder.bind(ageTxt, group.ageProperty());
        binder.bind(p025Txt, group.p025Property());
        binder.bind(p05Txt, group.p05Property());
        binder.bind(p075Txt, group.p075Property());
        binder.bind(p1Txt, group.p1Property());

        binder.bind(pYearTxt, group.pYearProperty());
        binder.bind(pMidTxt, group.pMidProperty());
        binder.bind(nTxt, group.nProperty());
        binder.bind(uTxt, group.uProperty());
        binder.bind(kpTxt, group.kpProperty());
        binder.bind(qTxt, group.qProperty());
        binder.bind(aIsoTxt, group.aIsoProperty());
        binder.bind(aGgtnTxt, group.aGgtnProperty());

        // set tooltip for best view
        nTxt.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.isEmpty()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setShowDelay(Duration.seconds(0.3));
                tooltip.setHideDelay(Duration.seconds(2));
                tooltip.setStyle("-fx-font-size: 18");
                tooltip.setText(decor.decoration(group.nProperty().get()));
                nTxt.setTooltip(tooltip);
            }
        });

        // tracking changes in form
        setCalculatedListener(((Pane) inputPane.getContent()).getChildren());

    }

    private void initButtons() {
        calcBtn.setOnAction(event -> {
            if (!check100()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Сообщение программы");
                alert.setHeaderText("Сумма долей циклов должна быть равна 100");
                alert.setContentText("Нажмите ОК для продолжения");

                DialogPane pane = alert.getDialogPane();
                pane.getStylesheets().add(
                        MyApplication.class.getResource("styles/style.css").toExternalForm());

                alert.showAndWait();

                return;
            }

            group.calculation();
            writeToFile();
            isCalculated.set(true);
        });
    }

    private void writeToFile() {
        Proxy proxy = new Proxy(
                group.ageProperty().get(),
                group.daysCountProperty().get(),
                group.aIsoProperty().get());

        try {
            FileOutputStream fos = new FileOutputStream("group.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(proxy);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initValidators() {

        // set support
        ValidationSupport vs = new ValidationSupport();

        // number validation
        numberValidator.DoubleValidator(pNomTxt);
        numberValidator.DoubleValidator(pMaxTxt);
        numberValidator.IntegerValidator(daysCountTxt, 1, 365);
        numberValidator.DoubleValidator(pDayTxt);
        numberValidator.IntegerValidator(ageTxt, 1, 100);
        numberValidator.IntegerValidator(p025Txt, 0, 100);
        numberValidator.IntegerValidator(p05Txt, 0, 100);
        numberValidator.IntegerValidator(p075Txt, 0, 100);
        numberValidator.IntegerValidator(p1Txt, 0, 100);

        // empty or 0 validations
        Validator<String> emptyValidator = Validator.createEmptyValidator("Это поле по может быть пустым", Severity.ERROR);
        Validator<String> not0Validator = (control, value) -> {
            boolean condition = value != null && (value.equals("0.0") || value.equals("0"));
            return ValidationResult.fromMessageIf(control, "Значение в этом поле должно быть больше 0", Severity.ERROR, condition);
        };

        // set validators
        vs.registerValidator(pNomTxt, Validator.combine(emptyValidator, not0Validator));
        vs.registerValidator(pMaxTxt, Validator.combine(emptyValidator, not0Validator));
        vs.registerValidator(daysCountTxt, Validator.combine(emptyValidator, not0Validator));
        vs.registerValidator(pDayTxt, Validator.combine(emptyValidator, not0Validator));
        vs.registerValidator(ageTxt, Validator.combine(emptyValidator, not0Validator));
        vs.registerValidator(p025Txt, Validator.combine(emptyValidator));
        vs.registerValidator(p05Txt, Validator.combine(emptyValidator));
        vs.registerValidator(p075Txt, Validator.combine(emptyValidator));
        vs.registerValidator(p1Txt, Validator.combine(emptyValidator));

        // button validation
        calcBtn.disableProperty().bind(vs.invalidProperty());
    }

    private void setCalculatedListener(List<Node> nodeList) {
        for (Node node : nodeList) {
            if (node instanceof TextField) {
                final String sOld = ((TextField) node).getText();
                ((TextField) node).textProperty().addListener(
                        (observableValue, s, t1) -> warningLbl.setVisible(!t1.equals(sOld)));
            }

            if (node instanceof Pane) {
                setCalculatedListener(((Pane) node).getChildren());
            }
        }
    }

    private boolean check100() {
        int res =
                group.p025Property().get()
                        + group.p05Property().get()
                        + group.p075Property().get()
                        + group.p1Property().get();

        return res == 100;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "GroupController{}";
    }
}
