package ru.parsentev.task_004;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class IsoscelesTriangle extends Triangle {
    private static final Logger log = getLogger(IsoscelesTriangle.class);

    public IsoscelesTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        boolean isExists = super.exists();
        if (isExists) {
            double firstSideLenght = Math.abs(first.distanceTo(second));
            double secondSideLenght = Math.abs(second.distanceTo(third));
            double thirdSideLenght = Math.abs(third.distanceTo(first));
            return firstSideLenght == secondSideLenght 
                    || secondSideLenght == thirdSideLenght 
                    || thirdSideLenght == firstSideLenght;
        }
        return isExists;
    }

    
}
