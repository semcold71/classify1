package ru.samcold.classify.domain;

import javafx.beans.property.*;
import ru.samcold.classify.utils.MatrixA;

public class Group {

    private final DoubleProperty pNom = new SimpleDoubleProperty();
    private final DoubleProperty pMax = new SimpleDoubleProperty();
    private final IntegerProperty daysCount = new SimpleIntegerProperty();
    private final DoubleProperty pDay = new SimpleDoubleProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();
    private final IntegerProperty p025 = new SimpleIntegerProperty();
    private final IntegerProperty p05 = new SimpleIntegerProperty();
    private final IntegerProperty p075 = new SimpleIntegerProperty();
    private final IntegerProperty p1 = new SimpleIntegerProperty();

    private final MatrixA matrix = MatrixA.getInstance();

    public DoubleProperty pNomProperty() {
        return pNom;
    }

    public DoubleProperty pMaxProperty() {
        return pMax;
    }

    public IntegerProperty daysCountProperty() {
        return daysCount;
    }

    public DoubleProperty pDayProperty() {
        return pDay;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public IntegerProperty p025Property() {
        return p025;
    }

    public IntegerProperty p05Property() {
        return p05;
    }

    public IntegerProperty p075Property() {
        return p075;
    }

    public IntegerProperty p1Property() {
        return p1;
    }

    // Output data
    private final DoubleProperty pYear = new SimpleDoubleProperty();
    private final DoubleProperty pMid = new SimpleDoubleProperty();
    private final IntegerProperty n = new SimpleIntegerProperty();
    private final StringProperty u = new SimpleStringProperty();
    private final DoubleProperty kp = new SimpleDoubleProperty();
    private final StringProperty q = new SimpleStringProperty();
    private final StringProperty aIso = new SimpleStringProperty();
    private final StringProperty aGgtn = new SimpleStringProperty();

    public DoubleProperty pYearProperty() {
        return pYear;
    }

    public DoubleProperty pMidProperty() {
        return pMid;
    }

    public IntegerProperty nProperty() {
        return n;
    }

    public StringProperty uProperty() {
        return u;
    }

    public DoubleProperty kpProperty() {
        return kp;
    }

    public StringProperty qProperty() {
        return q;
    }

    public StringProperty aIsoProperty() {
        return aIso;
    }

    public StringProperty aGgtnProperty() {
        return aGgtn;
    }

    private void setPYear() {
        pYear.set(daysCount.get() * pDay.get());
    }

    private void setPMid() {
        double x025 = (pMaxProperty().get() * 0.25) * (p025Property().get() / 100.0);
        double x05 = (pMaxProperty().get() * 0.5) * (p05Property().get() / 100.0);
        double x075 = (pMaxProperty().get() * 0.75) * (p075Property().get() / 100.0);
        double x1 = pMaxProperty().get() * (p1Property().get() / 100.0);
        pMid.set(Math.round((x025 + x05 + x075 + x1) * 100) / 100.0);
    }

    private void setN() {
        n.set((int) (pYearProperty().get() / pMidProperty().get() * ageProperty().get()));
    }

    private void setU() {
        int n = nProperty().get();
        String res;

        if (0 <= n && n < 16000) {
            res = "U0";
        } else if (16000 <= n && n < 32000) {
            res = "U1";
        } else if (32000 <= n && n < 63000) {
            res = "U2";
        } else if (63000 <= n && n < 125000) {
            res = "U3";
        } else if (125000 <= n && n < 250000) {
            res = "U4";
        } else if (250000 <= n && n < 500000) {
            res = "U5";
        } else if (500000 <= n && n < 1000000) {
            res = "U6";
        } else if (1000000 <= n && n < 2000000) {
            res = "U7";
        } else if (2000000 <= n && n < 4000000) {
            res = "U8";
        } else {
            res = "U9";
        }

        u.set(res);
    }

    private void setKp() {
        double x025 = Math.pow((pMaxProperty().get() * 0.25 / pNomProperty().get()), 3) * (p025Property().get() / 100.0);
        double x05 = Math.pow((pMaxProperty().get() * 0.5 / pNomProperty().get()), 3) * (p05Property().get() / 100.0);
        double x075 = Math.pow((pMaxProperty().get() * 0.75 / pNomProperty().get()), 3) * (p075Property().get() / 100.0);
        double x1 = Math.pow((pMaxProperty().get() * 1 / pNomProperty().get()), 3) * (p1Property().get() / 100.0);
        kp.set(Math.round((x025 + x05 + x075 + x1) * 1000) / 1000.0);
    }

    private void setQ() {
        String res = null;
        double kp = this.kpProperty().get();

        if (0.0 < kp && kp <= 0.125)
            res = "Q1";
        if (0.125 < kp && kp <= 0.25)
            res = "Q2";
        if (0.25 < kp && kp <= 0.5)
            res = "Q3";
        if (0.5 < kp && kp <= 1.0)
            res = "Q4";

        q.set(res);
    }

    private void setAIso() {
        aIsoProperty().set(matrix.getA(qProperty().get(), uProperty().get(), "a"));
    }

    private void setAGgtn() {
        aGgtnProperty().set(matrix.getA(qProperty().get(), uProperty().get(), "s"));
    }

    // Calculation of output data
    public void calculation() {
        setPYear();
        setPMid();
        setN();
        setU();
        setKp();
        setQ();
        setAIso();
        setAGgtn();
    }

    @Override
    public String toString() {
        return "Group{" +
                "pNom=" + pNom +
                ", pMax=" + pMax +
                ", daysCount=" + daysCount +
                ", pDay=" + pDay +
                ", age=" + age +
                ", p025=" + p025 +
                ", p05=" + p05 +
                ", p075=" + p075 +
                ", p1=" + p1 +
                ", matrix=" + matrix +
                ", pYear=" + pYear +
                ", pMid=" + pMid +
                ", n=" + n +
                ", u=" + u +
                ", kp=" + kp +
                ", q=" + q +
                ", aIso=" + aIso +
                ", aGgtn=" + aGgtn +
                '}';
    }
}
