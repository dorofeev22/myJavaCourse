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
            int z = i % 10;
            if ((i < 6) ||  (z == 1 || z == 3 || z == 7 || z == 9)) {
                boolean isPrime = true;
                double sqrtOfI = Math.sqrt((double)i);
                int divider = 0;
                if (dividers.size() > 0) {
                    for (int j = 0; (double)divider < sqrtOfI; j++) {
                        divider = dividers.get(j);
                        int y = i % divider;
                        if (y == 0) {
                            isPrime = false;
                            break;
                        }
                    }                
                }
                if (isPrime) {
                    primes.add(i);
                    dividers.add(i);
                }                
            }
        }
        return primes;
    }
}
