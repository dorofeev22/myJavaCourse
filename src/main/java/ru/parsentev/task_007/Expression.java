package ru.parsentev.task_007;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        Pattern pattern = Pattern.compile("[+-/*^]");
        Matcher matcher = pattern.matcher(expr);
        if (matcher.find()) {
            String operator = matcher.group();
            String[] numbers = expr.split(Pattern.quote(operator));
            if (numbers.length == 2) {
                double number1 = Double.valueOf(numbers[0]);
                double number2 = Double.valueOf(numbers[1]);
                if (operator.equals("+")) {
                    return number1 + number2;
                } else if (operator.equals("-")) {
                    return number1 - number2;
                } else if (operator.equals("/")) {
                    return number1 / number2;
                } else if (operator.equals("*")) {
                    return number1 * number2;
                } else if (operator.equals("^")) {
                    return Math.pow(number1, number2);
                }
            }
            throw new IllegalStateException(expr + " - not found two numbers");
        }
        throw new IllegalStateException(expr + " - not supported operation");
    }
 
}
