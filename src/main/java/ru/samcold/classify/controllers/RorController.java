package ru.samcold.classify.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import ru.samcold.classify.domain.Ror;
import ru.samcold.classify.utils.FieldBinder;
import ru.samcold.classify.utils.NumberValidator;

public class RorController {

    @FXML
    private TextField ageTxt;

    @FXML
    private TextField daysTxt;

    @FXML
    private TextField shiftsTxt;

    @FXML
    private TextField nominalNTxt;

    @FXML
    private ComboBox<Double> kFactorCbo;

    @FXML
    private TextField nFactorTxt;

    @FXML
    private ComboBox<Double> qFactorCbo;

    @FXML
    private TextField cyclesTxt;

    @FXML
    private TextField currentNTxt;

    @FXML
    private TextField cyclesResourceTxt;

    @FXML
    private TextField yearsResourceTxt;

    @FXML
    private Button calcBtn;

    @FXML
    private Button wordBtn;

    private Ror ror;
    private final FieldBinder binder = FieldBinder.getInstance();
    private final NumberValidator numberValidator = NumberValidator.getInstance();

    @FXML
    void initialize(Ror ror) {
        this.ror = ror;

        // fill combo-boxes && set listeners to their changes
        kFactorCbo.setItems(FXCollections.observableArrayList(1.5, 2.0));
        kFactorCbo.getSelectionModel().selectedItemProperty().addListener((observableValue, aDouble, t1) -> {
            this.ror.kFactorProperty().set(t1);
        });

        qFactorCbo.setItems(FXCollections.observableArrayList(0.3, 0.4, 0.5));
        qFactorCbo.getSelectionModel().selectedItemProperty().addListener((observableValue, aDouble, t1) -> {
            this.ror.qFactorProperty().set(t1);
        });

        initFields();
        initButtons();
    }

    private void initFields() {
        binder.bind(ageTxt, ror.ageProperty());
        binder.bind(daysTxt, ror.daysProperty());
        binder.bind(shiftsTxt, ror.shiftsProperty());
        binder.bind(nominalNTxt, ror.nominalNProperty());
        binder.bind(nFactorTxt, ror.nFactorProperty());
        binder.bind(cyclesTxt, ror.cyclesTotalProperty());
        binder.bind(currentNTxt, ror.currentNProperty());
        binder.bind(cyclesResourceTxt, ror.cyclesResourceProperty());
        binder.bind(yearsResourceTxt, ror.yearsResourceProperty());

        ValidationSupport vs = new ValidationSupport();
        Validator<String> emptyValidator = Validator.createEmptyValidator("Это поле по может быть пустым", Severity.ERROR);
        Validator<String> not0Validator = (control, value) -> {
            boolean condition = value != null && (value.equals("0.0") || value.equals("0"));
            return ValidationResult.fromMessageIf(control, "Значение в этом поле должно быть больше 0", Severity.ERROR, condition);
        };

        vs.registerValidator(kFactorCbo, Validator.combine(emptyValidator));
        vs.registerValidator(qFactorCbo, Validator.combine(emptyValidator));

        numberValidator.IntegerValidator(nFactorTxt, 1, 1000);
        vs.registerValidator(nFactorTxt, Validator.combine(emptyValidator, not0Validator));

        calcBtn.disableProperty().bind(vs.invalidProperty());
    }

    private void initButtons() {
        calcBtn.setOnAction(event -> ror.calculation());
    }

}
