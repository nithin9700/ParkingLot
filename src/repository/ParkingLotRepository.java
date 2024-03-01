package repository;

import models.ParkingLot;
import Exception.InvalidParkingLot;
import java.util.HashMap;

public class ParkingLotRepository {
    private final HashMap<Integer, ParkingLot> parkingLotTable;
    private int parkingLotId = 0;


    public ParkingLotRepository() {
        this.parkingLotTable = new HashMap<>();;
    }

    public void set(ParkingLot parkinglot) {
        parkingLotTable.put(++parkingLotId, parkinglot);
        System.out.println("ParkingLot has been added to repository" + parkingLotId);
    }

    public ParkingLot get(int parkingLotId) {
        ParkingLot parkinglot = parkingLotTable.get(parkingLotId);
        if (parkinglot == null) throw new InvalidParkingLot("ParkingLot id was not found in dataBase : " + parkingLotId);
        return parkinglot;
    }
}


