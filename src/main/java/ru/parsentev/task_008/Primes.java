package ru.parsentev.task_008;

import java.util.ArrayList;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Primes {
    private static final Logger log = getLogger(Primes.class);

    private final int limit;

    public Primes(final int limit) {
        this.limit = limit;
    }

    public List<Integer> calc() {
        List<Integer> primes = new ArrayList<Integer>();
        List<Integer> dividers = new ArrayList<Integer>();
        for (int i = 2; i <= limit; i++) {
            boolean isPrime = true;
            for (Integer divider : dividers) {
                int y = i % divider;
                if (y == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
            dividers.add(i);
        }
        return primes;
    }
}
