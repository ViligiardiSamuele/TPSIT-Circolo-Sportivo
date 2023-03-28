package ES05.Exception;

public class CircoloSportivoException extends Exception {
    public CircoloSportivoException() {
    }

    public CircoloSportivoException(String message) {
        super(message);
    }

    public CircoloSportivoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CircoloSportivoException(Throwable cause) {
        super(cause);
    }

    public CircoloSportivoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
