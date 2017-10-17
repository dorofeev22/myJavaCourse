package ru.parsentev.task_003;

import java.math.BigDecimal;
import java.util.Arrays;
import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;
import ru.parsentev.task_001.Calculator;

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
        Calculator calculator = new Calculator();
        calculator.add(sideLenghts[1], sideLenghts[0]);
        return sideLenghts[2] < calculator.getResult();
    }

    public double area() {
        if (exists()) {
            Calculator calculator = new Calculator();
            double perimeter = 0;
            double[] sideLenghts = getArraySideLenght();
            for (int i = 0; i < sideLenghts.length; i++) {
                calculator.add(perimeter, sideLenghts[i]);
                perimeter = calculator.getResult();
            }
            calculator.div(perimeter, 2.0);
            double halfPerimeter = calculator.getResult();
            return Math.sqrt(
                    (BigDecimal.valueOf(halfPerimeter)
                            .multiply(substract(halfPerimeter, sideLenghts[0]))
                            .multiply(substract(halfPerimeter, sideLenghts[1]))
                            .multiply(substract(halfPerimeter, sideLenghts[2]))
                    ).doubleValue());            
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

    public BigDecimal substract(double first, double second) {
        return BigDecimal.valueOf(first).subtract(BigDecimal.valueOf(second));
    }


}
