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

}
