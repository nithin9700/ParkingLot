package Exception;

public class InvalidGateID extends RuntimeException{
    public InvalidGateID() {
    }

    public InvalidGateID(String message) {
        super(message);
    }
}
