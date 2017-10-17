package ru.parsentev.task_007;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
        String[] numbers = expr.split("\\+");
        if (numbers.length == 2) {
            return Double.valueOf(numbers[0]) + Double.valueOf(numbers[1]);
        }
        numbers = expr.split("-");
        if (numbers.length == 2) {
            return Double.valueOf(numbers[0]) - Double.valueOf(numbers[1]);
        }
        numbers = expr.split("/");
        if (numbers.length == 2) {
            return Double.valueOf(numbers[0]) / Double.valueOf(numbers[1]);
        }
        numbers = expr.split("\\*");
        if (numbers.length == 2) {
            return Double.valueOf(numbers[0]) * Double.valueOf(numbers[1]);
        }
        numbers = expr.split("\\^");
        if (numbers.length == 2) {
            return Math.pow(Double.valueOf(numbers[0]), Double.valueOf(numbers[1]));
        }
        throw new IllegalStateException(expr + " - not supported operation");
    }
}
