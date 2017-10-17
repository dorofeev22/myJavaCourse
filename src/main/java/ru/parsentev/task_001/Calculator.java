package ru.parsentev.task_001;

import java.math.BigDecimal;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author parsentev
 * @since 18.07.2016
 */
public class Calculator {
    private static final Logger log = getLogger(Calculator.class);
    private double result;

    public double getResult() {
        return result;
    }

    public void add(double first, double second) {
        BigDecimal addResult = BigDecimal.valueOf(first).add(BigDecimal.valueOf(second));
        result = addResult.doubleValue();
    }

    public void substract(double first, double second) {
        BigDecimal addResult = BigDecimal.valueOf(first).subtract(BigDecimal.valueOf(second));
        result = addResult.doubleValue();
    }

    public void multiple(double first, double second) {
        BigDecimal addResult = BigDecimal.valueOf(first).multiply(BigDecimal.valueOf(second));
        result = addResult.doubleValue();
    }

    public void div(double first, double second) {
        if (second == 0.0) {
            throw new IllegalStateException("division by zero");
        } else {
            BigDecimal addResult = BigDecimal.valueOf(first).divide(BigDecimal.valueOf(second));
            result = addResult.doubleValue();
        }
    }

    public void expand(double first, double second) {
        result = Math.pow(first, second);
    }
}
