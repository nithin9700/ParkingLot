package repository;

import models.ParkingFloor;
import Exception.InvalidParkingFloor;
import java.util.HashMap;

public class ParkingFloorRepository {
    private final HashMap<Integer, ParkingFloor> parkingFloorTable;
    private int parkingFloorId = 0;


    public ParkingFloorRepository() {
        this.parkingFloorTable = new HashMap<>();;
    }

    public void set(ParkingFloor parkingFloor) {
        parkingFloorTable.put(++parkingFloorId, parkingFloor);
        System.out.println("ParkingFloor has been added to repository" + parkingFloorId);
    }

    public ParkingFloor get(int ParkingFloorId) {
        ParkingFloor parkingFloor = parkingFloorTable.get(ParkingFloorId);
        if (parkingFloor == null) throw new InvalidParkingFloor("ParkingFloor id was not found in dataBase : " + ParkingFloorId);
        return parkingFloor;
    }
}
