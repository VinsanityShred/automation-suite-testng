package framework.utility;

public class Util {

    public static void waitMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch ( InterruptedException ignored ) {
        }
    }
}