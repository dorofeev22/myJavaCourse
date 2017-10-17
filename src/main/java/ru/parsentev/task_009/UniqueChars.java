package ru.parsentev.task_009;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class UniqueChars {
    private final String line;

    public UniqueChars(final String line) {
        this.line = line;
    }

    public int unique() {
        char[] chars = line.toCharArray();
        Set<Character> uniqueChars = new HashSet<Character>();
        for (char ch : chars) {
            uniqueChars.add(ch);
        }
        return uniqueChars.size();
    }
}
