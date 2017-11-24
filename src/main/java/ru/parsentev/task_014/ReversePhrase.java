package ru.parsentev.task_014;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ReversePhrase {
    private static final Logger log = getLogger(ReversePhrase.class);
    private final String line;

    public ReversePhrase(final String line) {
        this.line = line;
    }

    public String reverse() {
        List<String> words = Arrays.asList(line.split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
