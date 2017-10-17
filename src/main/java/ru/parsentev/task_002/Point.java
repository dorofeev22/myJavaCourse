package ru.parsentev.task_002;

import java.math.BigDecimal;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class Point defines a point in coordination system (x, y).
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
    private static final Logger log = getLogger(Point.class);

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(final Point point) {
        BigDecimal xSub = BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(point.x));
        BigDecimal ySub = BigDecimal.valueOf(y).subtract(BigDecimal.valueOf(point.y));
        return Math.sqrt(((xSub.multiply(ySub)).add(ySub.multiply(ySub))).doubleValue());
    }
}
