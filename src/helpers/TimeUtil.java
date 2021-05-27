package helpers;

public class TimeUtil {
    private static long start;
    private static long stop;

    public static void startClock() {
        start = System.currentTimeMillis();
    }

    public static void stopClock() {
        stop = System.currentTimeMillis();
    }

    public static void outputMessage() {
        System.out.println("Time taken: " + (stop - start) + "ms");
    }
}
