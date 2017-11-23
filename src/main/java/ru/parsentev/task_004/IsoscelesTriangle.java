package ru.parsentev.task_004;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class IsoscelesTriangle extends Triangle {

    private static final Logger log = getLogger(IsoscelesTriangle.class);
    private static final double EPSILON = 0.0001;

    public IsoscelesTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        return super.exists() && isIsosceles();
    }

    private boolean isIsosceles() {
        double firstSideLenght = first.distanceTo(second);
        double secondSideLenght = second.distanceTo(third);
        double thirdSideLenght = third.distanceTo(first);
        return nearlyEqual(firstSideLenght, secondSideLenght, EPSILON)
                || nearlyEqual(secondSideLenght, thirdSideLenght, EPSILON)
                || nearlyEqual(thirdSideLenght, firstSideLenght, EPSILON);
    }

    public static boolean nearlyEqual(double a, double b, double epsilon) {
        final double absA = Math.abs(a);
        final double absB = Math.abs(b);
        final double diff = Math.abs(a - b);

        if (a == b) {
            return true;
        } else if (a == 0 || b == 0 || diff < Float.MIN_NORMAL) {
            return diff < (epsilon * Float.MIN_NORMAL);
        } else {
            return diff / Math.min((absA + absB), Float.MAX_VALUE) < epsilon;
        }
    }
}
