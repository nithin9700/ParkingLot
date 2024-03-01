package Exception;

public class InvalidPayment extends RuntimeException{
    public InvalidPayment(String message) {
        super(message);
    }
}
