package Exception;

public class InvalidParkingFloor extends RuntimeException{
    public InvalidParkingFloor() {
    }

    public InvalidParkingFloor(String message) {
        super(message);
    }

    public InvalidParkingFloor(Throwable cause) {
        super(cause);
    }
}
