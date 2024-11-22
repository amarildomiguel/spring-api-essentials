package ucan.edu.sistema_academico.utils;

public class LatencyUtils {
    public static void simulateLatency(int seconds) {
        try {
            long time = seconds * 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
