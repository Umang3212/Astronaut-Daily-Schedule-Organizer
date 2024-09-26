package exceptions;
import logger.*;

public class ExceptionHandler {
    public static void handleException(Exception e) {
        Logger.log(e.getMessage());
    }
}

