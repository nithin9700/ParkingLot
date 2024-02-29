package Exception;

public class InvalidParkingLot extends RuntimeException{
    public InvalidParkingLot() {
    }

    public InvalidParkingLot(String message) {
        super(message);
    }


}
