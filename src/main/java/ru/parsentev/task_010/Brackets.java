package ru.parsentev.task_010;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Brackets {
    private static final Logger log = getLogger(Brackets.class);
    private final String line;

    public Brackets(final String line) {
        this.line = line;
    }

    public boolean isCorrect() {
        char[] brackets = line.toCharArray();
        int openBrackets = 0;
        int closedBrackets = 0;
        for (char ch : brackets) {
            if (ch == '(') {
                openBrackets++;
            }
            if (ch == ')') {
                closedBrackets++;
            }
        }
        return openBrackets == closedBrackets;
    }
}
