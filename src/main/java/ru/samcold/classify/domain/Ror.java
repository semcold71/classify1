package ru.samcold.classify.domain;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import ru.samcold.classify.utils.MatrixB;

public class Ror {

    private final Proxy proxy;
    private final MatrixB matrix = MatrixB.getInstance();

    private final IntegerProperty age = new SimpleIntegerProperty();
    private final IntegerProperty days = new SimpleIntegerProperty();

    private final IntegerProperty shifts = new SimpleIntegerProperty();
    private final IntegerProperty nominalN = new SimpleIntegerProperty();

    private final DoubleProperty kFactor = new SimpleDoubleProperty();
    private final IntegerProperty nFactor = new SimpleIntegerProperty();
    private final DoubleProperty qFactor = new SimpleDoubleProperty();

    private final IntegerProperty cyclesTotal = new SimpleIntegerProperty();
    private final IntegerProperty currentN = new SimpleIntegerProperty();

    private final IntegerProperty cyclesResource = new SimpleIntegerProperty();
    private final DoubleProperty yearsResource = new SimpleDoubleProperty();

    public Ror(Proxy proxy) {
        this.proxy = proxy;
        this.age.set(proxy.getAge());
        this.days.set(proxy.getDays());

        setShift();
        setNominalN();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public IntegerProperty daysProperty() {
        return days;
    }

    public IntegerProperty shiftsProperty() {
        return shifts;
    }

    public IntegerProperty nominalNProperty() {
        return nominalN;
    }

    public DoubleProperty kFactorProperty() {
        return kFactor;
    }

    public IntegerProperty nFactorProperty() {
        return nFactor;
    }

    public DoubleProperty qFactorProperty() {
        return qFactor;
    }

    public IntegerProperty cyclesTotalProperty() {
        return cyclesTotal;
    }

    public IntegerProperty currentNProperty() {
        return currentN;
    }

    public IntegerProperty cyclesResourceProperty() {
        return cyclesResource;
    }

    public DoubleProperty yearsResourceProperty() {
        return yearsResource;
    }

    private void setShift() {
        shifts.set(age.get() * days.get());
    }

    private void setNominalN() {
        nominalN.set(matrix.getN(proxy.getaIso()));
    }

    private void setCyclesTotal() {
        cyclesTotal.set(
                (int) (shifts.get() * kFactor.get() * nFactor.get()));
    }

    private void setCurrentN() {
        currentN.set(
                (int) (cyclesTotal.get() * Math.pow(qFactor.get(), 3))
        );
    }

    private void setCyclesResource() {
        cyclesResource.set(
                (int) ((nominalN.get() - currentN.get()) / Math.pow(qFactor.get(), 3))
        );
    }

    private void setYearsResource() {
        int c = cyclesResource.get();
        int n = nFactor.get();
        int d = proxy.getDays();
        double k = kFactor.get();

        double res = c / (n * k * d);
        res = Math.round(res *10) / 10.0;

        yearsResource.set(res);
    }

    // calculation
    public void calculation() {
        setCyclesTotal();
        setCurrentN();
        setCyclesResource();
        setYearsResource();
    }

    @Override
    public String toString() {
        return "Ror{" +
                "age=" + age +
                ", days=" + days +
                ", shifts=" + shifts +
                ", nominalN=" + nominalN +
                ", kFactor=" + kFactor +
                ", nFactor=" + nFactor +
                ", qFactor=" + qFactor +
                ", cyclesTotal=" + cyclesTotal +
                ", currentN=" + currentN +
                ", cyclesResource=" + cyclesResource +
                ", yearsResource=" + yearsResource +
                '}';
    }
}
