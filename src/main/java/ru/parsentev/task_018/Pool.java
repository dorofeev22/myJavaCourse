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
        List<int[][]> bunchs = new ArrayList<int[][]>();
        // выявляем множества единиц, складываем их в отдельные массивы, очищая при этом оригинальный от них
        while (getElementsSum(values) != 0) {
            int[][] bunch = getClearArrayCopy(values);

            for (int i = 0; i < values.length; i++) {
                //isRowContainSubBunch = false;
                int[] subBanchRowIdxs = new int[2];
                boolean isRowContainSubBunch = false; // признак, что строка содержит подмножество
                boolean startBunch = false; // флаг, показывает что идет подсчет множества по строке
                int j;
                for (j = 0; j < values[i].length; j++) {
                    int element = values[i][j];
                    // если обнаруженный элемент 1 и счета нет
                    if (element != 0 && !startBunch) {
                        startBunch = true; // стартуем счет
                        subBanchRowIdxs[0] = j; // кладем начальный индекс подмножества строки
                        values[i][j] = 0; // очищаем исходную матрицу от этого элемента
                    // если обнаруженный элемент 1 и счет уже ведется
                    } else if (element != 0 && startBunch) {
                        values[i][j] = 0; // очищаем исходную матрицу от этого элемента
                    // если обнаруженный элемент 0 и счет ведется
                    }
                    if (element == 0 && startBunch) {
                        subBanchRowIdxs[1] = j - 1; // кладем конечный индекс подмножества строки
                        startBunch = false; // прекращаем счет
                        if (i > 0) { // если текущая строка не первая
                            // анализируем может ли найденное подмножество на строке быть частью множества
                            if (isSubBunchOfBunch(bunch[i-1], subBanchRowIdxs)) {
                                // добавим (создадим) подстрочное множество в основное множество
                                addRowElementsToArray(bunch, i, subBanchRowIdxs);
                                isRowContainSubBunch = true;
                            }
                        } else {
                            // если строка первая, то добавим (создадим) подстрочное множество в основное множество
                            addRowElementsToArray(bunch, i, subBanchRowIdxs);
                            isRowContainSubBunch = true;
                            break; // и прекратим поиск следующего подмножества в этой строке
                        }
                    }
                }
                // если последний элемент строки был 1, то необходимо найденное подмножество проверить и учесть
                if (startBunch) {
                    subBanchRowIdxs[1] = j-1; // кладем конечный индекс подмножества строки (он излише увеличен после цикла)
                    if (i > 0) { // если текущая строка не первая
                        // анализируем может ли найденное подмножество на строке быть частью множества
                        if (isSubBunchOfBunch(bunch[i-1], subBanchRowIdxs)) {
                            // добавим (создадим) подстрочное множество в основное множество
                            addRowElementsToArray(bunch, i, subBanchRowIdxs);
                            isRowContainSubBunch = true;
                        }
                    } else {
                        // если строка первая, то добавим (создадим) подстрочное множество в основное множество
                        addRowElementsToArray(bunch, i, subBanchRowIdxs);
                        isRowContainSubBunch = true;
                    }
                }
                if (getElementsSum(bunch) > 0 && !isRowContainSubBunch) {
                    break;
                }
            }
            bunchs.add(bunch);
        }
        int result = getCountOfMaxBunch(bunchs);
        return result;
    }

    private static int[][] getClearArrayCopy(int[][] a) {
        return new int[a.length][a[0].length];
    }

    private static int getElementsSum(int[][] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result += a[i][j];
            }
        }
        return result;
    }

    private static boolean isSubBunchOfBunch(int[] previousBanchRowIdxs, int[] subBanchRowIdxs) {
        Integer elementMinIdx = null;
        int elementMaxIdx = 0;
        // определяем границы множества на предыдущей строке
        for (int b = 0; b < previousBanchRowIdxs.length; b++) {
            int bElement = previousBanchRowIdxs[b];
            if (bElement != 0 && elementMinIdx == null) {
                elementMinIdx = b;
            }
            if (elementMinIdx != null && elementMaxIdx == 0 && bElement == 0) {
                elementMaxIdx = b - 1;
            }
            if (bElement != 0 && b == previousBanchRowIdxs.length - 1) {
                elementMaxIdx = b;
            }
        }
        return elementMinIdx != null ?
                elementMinIdx <= subBanchRowIdxs[1] && elementMaxIdx >= subBanchRowIdxs[0]
                : true;
    }

    private static void addRowElementsToArray(int[][] array, int rowIdx, int[] subBanchRowIdxs) {
        for (int z = 0; z < array[rowIdx].length; z++) {
            if (z < subBanchRowIdxs[0] || z > subBanchRowIdxs[1]) {
                array[rowIdx][z] = 0;
            }
            if (z >= subBanchRowIdxs[0] && z <= subBanchRowIdxs[1]) {
                array[rowIdx][z] = 1;
            }
        }
    }

    private static int getCountOfMaxBunch(List<int[][]> bunchs) {
        int maxCount = 0;
        for (int[][] bunch : bunchs) {
            int count = getElementsSum(bunch);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

}
