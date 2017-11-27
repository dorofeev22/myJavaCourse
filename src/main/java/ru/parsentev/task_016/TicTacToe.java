package ru.parsentev.task_016;

import java.util.Arrays;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {

    private static final Logger log = getLogger(TicTacToe.class);

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        // проверим наличие трех крестиков или ноликов по горизонтали
        for (int i = 0; i < values.length; i++) {
            int sumRowValues = Arrays.stream(values[i]).sum();
            if (sumRowValues == 3 || sumRowValues == 0) {
                return true;
            }
        }
        // приверим наличие трех крестиков или ноликов по вертикали
        for (int j = 0; j < values[0].length; j++) {
            int sumColValues = values[0][j] + values[1][j] + values[2][j];
            if (sumColValues == 3 || sumColValues == 0) {
                return true;
            }
        }
        int sumMainDiagonal = values[0][0] + values[1][1] + values[2][2];
        if (sumMainDiagonal == 3 || sumMainDiagonal == 0) {
            return true;
        }
        int sumAddDiagonal = values[0][2] + values[1][1] + values[2][0];
        if (sumAddDiagonal == 3 || sumAddDiagonal == 0) {
            return true;
        }
        return false;
    }
}
