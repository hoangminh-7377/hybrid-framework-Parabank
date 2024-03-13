package browserFactory;

public class NotSupportedBrowserException extends IllegalStateException{

    public NotSupportedBrowserException(String browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}