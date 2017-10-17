package ru.parsentev.task_007;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ExpressionTest {

    @Test
    public void calc() {
        Expression expr = new Expression("2+2");
        double result = expr.calc();
        assertThat(result, is(4d));
    }

    @Test
    public void calcSubtract() {
        Expression expr = new Expression("2-2");
        double result = expr.calc();
        assertThat(result, is(0d));
    }

    @Test
    public void calcMultiply() {
        Expression expr = new Expression("2*2");
        double result = expr.calc();
        assertThat(result, is(4d));
    }

    @Test
    public void calcDivision() {
        Expression expr = new Expression("2/2");
        double result = expr.calc();
        assertThat(result, is(1d));
    }

    @Test
    public void calcExp() {
        Expression expr = new Expression("2^2");
        double result = expr.calc();
        assertThat(result, is(4d));
    }

    @Test(expected = IllegalStateException.class)
    public void noValid() {
        new Expression("2+").calc();
    }
}