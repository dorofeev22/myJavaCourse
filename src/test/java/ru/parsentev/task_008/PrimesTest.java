package ru.parsentev.task_008;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class PrimesTest {
    @Test
    public void calc() {
        Primes primes = new Primes(20);
        List<Integer> result = primes.calc();
        assertThat(result, is(asList(2, 3, 5, 7, 11, 13, 17, 19)));
    }

}
