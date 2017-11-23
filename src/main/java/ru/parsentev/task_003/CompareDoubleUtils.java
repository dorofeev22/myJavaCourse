package ru.parsentev.task_003;

/**
 * 
 */
public class CompareDoubleUtils {
    
    private static final double EPSILON = 0.0001;
    
    public static boolean nearlyEqual(double a, double b) {
        final double absA = Math.abs(a);
        final double absB = Math.abs(b);
        final double diff = Math.abs(a - b);

        if (a == b) {
            return true;
        } else if (a == 0 || b == 0 || diff < Float.MIN_NORMAL) {
            return diff < (EPSILON * Float.MIN_NORMAL);
        } else {
            return diff / Math.min((absA + absB), Float.MAX_VALUE) < EPSILON;
        }
    }

}
