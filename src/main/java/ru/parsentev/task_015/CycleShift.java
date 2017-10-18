package ru.parsentev.task_015;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public int[] shift(int position) {
        for (int p = 0; p < position; p++) {
            int lastValueIndex = values.length - 1;
            int lastValue = values[lastValueIndex];
            for (int i = lastValueIndex; i != 0; i--) {
                values[i] = values[i - 1];
            }
            values[0] = lastValue;
        }
        return values;
    }
}
