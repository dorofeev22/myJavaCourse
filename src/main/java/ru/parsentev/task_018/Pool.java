package ru.parsentev.task_018;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {

    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;

    public Pool(final int[][] values) {
        this.values = values;
    }

    public int maxUnion() {
        int result = 0;
        List<int[][]> bunchs = new ArrayList<int[][]>();
        // выявляем множества единиц, складываем их в отдельные массивы, очищая при этом оригинальный от них
        while (getElementsSum(values) != 0) {
            int[][] bunch = getClearArray(values);
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length; j++) {
                    int[] previousRow = bunch[i];
                    int elementMinIdx = 0;
                    int elementMaxIdx = 0;
                    for (int b = 0; b < values[i].length; b++) {
                        int bElement = previousRow[b];
                        if (bElement != 0 && elementMinIdx == 0) {
                            elementMinIdx = b;
                        }
                        if (elementMinIdx != 0 && bElement == 0) {
                            elementMaxIdx = b;
                        }
                    }
                    boolean startBunch = false; // флаг, показывает что идет подсчет множества по строке
                    int element = values[i][j];
                    // если взятый элемент 1 и счета нет
                    if (element != 0 && !startBunch) {
                        startBunch = true; // стартуем счет
                        bunch[i][j] = 1;
                        values[i][j] = 0; // очищаем исходную матрицу от этого элемента
                    } else if (element != 0 && startBunch) {
                        bunch[i][j] = 1;
                        values[i][j] = 0; // очищаем исходную матрицу от этого элемента
                    } else if (element == 0 && startBunch) {
                        startBunch = false;
                        break; // прекращаем поиск по этой строке
                    }
                }
            }
            bunchs.add(bunch);
        }
        return result;
    }

    private int[][] getClearArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }
        }
        return a;
    }

    private int getElementsSum(int[][] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result += a[i][j];
            }
        }
        return result;
    }

}
