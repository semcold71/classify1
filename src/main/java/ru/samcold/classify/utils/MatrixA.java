package ru.samcold.classify.utils;

import java.util.AbstractMap;
import java.util.Map;

public class MatrixA {
    // region singleton
    private static MatrixA INSTANCE;

    private MatrixA() {
    }

    public static MatrixA getInstance() {
        if (INSTANCE == null) {
            synchronized (MatrixA.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MatrixA();
                }
            }
        }
        return INSTANCE;
    }
    // endregion singleton

    private final Map<String, Map<String, Map<String, String>>> map = Map.ofEntries(
            // region Q1
            new AbstractMap.SimpleEntry<>("Q1", Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("U0", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U1", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U2", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U3", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A2"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U4", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A3"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U5", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A4"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U6", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A5"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U7", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A6"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U8", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A7"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U9", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A8"),
                            new AbstractMap.SimpleEntry<>("s", "Весьма тяжелый")
                    ))

            )),
            // endregion
            // region Q2
            new AbstractMap.SimpleEntry<>("Q2", Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("U0", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U1", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U2", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A2"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U3", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A3"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U4", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A4"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U5", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A5"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U6", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A6"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U7", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A7"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U8", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A8"),
                            new AbstractMap.SimpleEntry<>("s", "Весьма тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U9", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    ))
            )),
            // endregion
            // region Q3
            new AbstractMap.SimpleEntry<>("Q3", Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("U0", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A1"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U1", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A2"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U2", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A3"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U3", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A4"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U4", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A5"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U5", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A6"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U6", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A7"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U7", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A8"),
                            new AbstractMap.SimpleEntry<>("s", "Весьма тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U8", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    )),
                    new AbstractMap.SimpleEntry<>("U9", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    ))
            )),
            // endregion
            // region Q4
            new AbstractMap.SimpleEntry<>("Q4", Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("U0", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A2"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U1", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A3"),
                            new AbstractMap.SimpleEntry<>("s", "Легкий")
                    )),
                    new AbstractMap.SimpleEntry<>("U2", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A4"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U3", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A5"),
                            new AbstractMap.SimpleEntry<>("s", "Средний")
                    )),
                    new AbstractMap.SimpleEntry<>("U4", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A6"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U5", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A7"),
                            new AbstractMap.SimpleEntry<>("s", "Тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U6", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "A8"),
                            new AbstractMap.SimpleEntry<>("s", "Весьма тяжелый")
                    )),
                    new AbstractMap.SimpleEntry<>("U7", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    )),
                    new AbstractMap.SimpleEntry<>("U8", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    )),
                    new AbstractMap.SimpleEntry<>("U9", Map.ofEntries(
                            new AbstractMap.SimpleEntry<>("a", "-"),
                            new AbstractMap.SimpleEntry<>("s", "-")
                    ))
            ))
            // endregion
    );

    public String getA(String q, String u, String a) {
        return map.get(q).get(u).get(a);
    }

}
