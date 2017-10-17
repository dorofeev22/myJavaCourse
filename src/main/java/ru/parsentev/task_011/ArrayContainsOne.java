package ru.parsentev.task_011;

import java.util.Arrays;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ArrayContainsOne {
    private static final Logger log = getLogger(ArrayContainsOne.class);
    private final int[] values;

    public ArrayContainsOne(final int[] values) {
        this.values = values;
    }

    public boolean containsOnlyOne() {
        for (int value : values) {
            if (value != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean containsOnlyOne2() {
        return Arrays.stream(values).sum() == values.length;
    }
}
