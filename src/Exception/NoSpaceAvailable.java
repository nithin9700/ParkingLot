package Exception;

public class NoSpaceAvailable extends  RuntimeException{
    public NoSpaceAvailable() {
    }

    public NoSpaceAvailable(String message) {
        super(message);
    }
}
