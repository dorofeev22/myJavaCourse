package ru.parsentev.task_003;

import java.util.Arrays;
import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {

    private static final Logger log = getLogger(Triangle.class);
    protected static final double EPSILON = 0.0001;

    protected final Point first;
    protected final Point second;
    protected final Point third;

    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean exists() {
        double[] sideLenghts = getArraySideLenght();
        Arrays.sort(sideLenghts);
        return sideLenghts[2] < (sideLenghts[1] + sideLenghts[0]);
    }

    public double area() {
        if (exists()) {
            double perimeter = 0;
            double[] sideLenghts = getArraySideLenght();
            for (int i = 0; i < sideLenghts.length; i++) {
                perimeter += sideLenghts[i];
            }
            double halfPerimeter = perimeter / 2.0;
            return Math.sqrt(halfPerimeter
                    * (halfPerimeter - sideLenghts[0])
                    * (halfPerimeter - sideLenghts[1])
                    * (halfPerimeter - sideLenghts[2]));
        } else {
            throw new IllegalStateException("Triangle does not exist");
        }
    }

    private double[] getArraySideLenght() {
        double firstSideLenght = Math.abs(first.distanceTo(second));
        double secondSideLenght = Math.abs(second.distanceTo(third));
        double thirdSideLenght = Math.abs(third.distanceTo(first));
        double[] sideLenghts = {firstSideLenght, secondSideLenght, thirdSideLenght};
        return sideLenghts;
    }

    protected boolean nearlyEqual(double a, double b, double epsilon) {
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
