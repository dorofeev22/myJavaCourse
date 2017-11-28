package ru.parsentev.task_019;

import java.util.ArrayList;
import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Maze {
    private static final Logger log = getLogger(Maze.class);

    private final int[][] values;

    public Maze(final int[][] values) {
        this.values = values;
    }

    public List<Point> solution(Point start, Point finish) throws Exception {
        List<Point> points = new ArrayList<Point>();
        if (isPointsInBunch(start, finish)) {
            int startX = start.getX();
            int startY = start.getY();
            int finishX = finish.getX();
            int finishY = finish.getY();
            boolean xIncrease = toIncrease(startX, finishX);
            boolean yIncrease = toIncrease(startY, finishY);
            while (startX != finishX && startY != finishY) {
                int nextPointValue = values[startY][startX];
                if (xIncrease) {
                    while (nextPointValue == 1) {
                        Point point = new Point(startX, startY);
                        points.add(point);
                        startX++;
                        nextPointValue = values[startY][startX];
                    }
                }
                if (yIncrease) {
                    while (nextPointValue == 1) {
                        Point point = new Point(startX, startY);
                        points.add(point);
                        startY++;
                        nextPointValue = values[startY][startX];
                    }
                }
            }
        }
        return points;
    }

    private boolean isPointsInBunch(Point start, Point finish) throws Exception {
        try {
            int startValue = values[start.getY()][start.getX()];
            int finishValue = values[finish.getY()][finish.getX()];
            return startValue == 1 && finishValue == 1;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private boolean toIncrease(int start, int finish) {
        return start < finish;
    }
}
