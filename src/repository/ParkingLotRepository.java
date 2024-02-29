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
        System.out.println("parkinglot has been added to repository" + parkingLotId);
    }

    public ParkingLot get(int parkinglotId) {
        ParkingLot parkinglot = parkingLotTable.get(parkinglotId);
        if (parkinglot == null) throw new InvalidParkingLot("parkinglot id was not found in dataBase : " + parkinglotId);
        return parkinglot;
    }
}


