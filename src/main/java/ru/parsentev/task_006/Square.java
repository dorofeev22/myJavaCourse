package ru.parsentev.task_006;

import java.util.Arrays;
import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Square {
    private static final Logger log = getLogger(Square.class);

    private final Point first;
    private final Point second;
    private final Point third;
    private final Point fourth;

    public Square(final Point first, final Point second, final Point third, final Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public boolean exists() {
        double firstDistance = first.distanceTo(second);
        double secondDistance = second.distanceTo(third);
        double thirdDistance = third.distanceTo(fourth);
        double fourthDistance = fourth.distanceTo(first);
        double fifthDistance = first.distanceTo(third);
        double sixthDistance = second.distanceTo(fourth);
        double[] distances = 
            {firstDistance, secondDistance, thirdDistance, 
                fourthDistance, fifthDistance, sixthDistance};
        Arrays.sort(distances);
        if (distances[0] != 0) {
            if (distances[4] == distances[5]) {
                if (distances[1] == distances[2]) {
                    return true;
                }
            }
        }
        return false;
    }
}
