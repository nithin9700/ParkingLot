package repository;

import models.ParkingSpot;
import Exception.InvalidParkingSpot;
import java.util.HashMap;

public class ParkingSpotRepository {
    private final HashMap<Integer, ParkingSpot> parkingSpotTable;
    private int parkingSpotId = 0;

    public ParkingSpotRepository() {
        this.parkingSpotTable = new HashMap<>();;
    }

    public void set(ParkingSpot parkingSpot) {
        parkingSpotTable.put(++parkingSpotId, parkingSpot);
        System.out.println("ParkingSpot has been added to repository " + parkingSpotId);
    }

    public ParkingSpot get(int ParkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotTable.get(ParkingSpotId);
        if (parkingSpot == null) throw new InvalidParkingSpot("ParkingSpot id was not found in dataBase : " + ParkingSpotId);
        return parkingSpot;
    }

}
