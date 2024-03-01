package Exception;

public class InvalidTicket extends RuntimeException{
    public InvalidTicket() {
    }

    public InvalidTicket(String message) {
        super(message);
    }
}
