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
        char firstBracket = brackets[0];
        if (Character.toString(firstBracket).equals("(")) {
            int bracketsCalc = 0;
            for (char ch : brackets) {
                if (ch == '(') {
                    bracketsCalc++;
                }
                if (ch == ')') {
                    bracketsCalc--;
                }
            }
            return bracketsCalc == 0;
        }
        return false;
    }
}
