package Exception;

public class InvalidParkingSpot extends RuntimeException{
    public InvalidParkingSpot() {
    }

    public InvalidParkingSpot(String message) {
        super(message);
    }
}
