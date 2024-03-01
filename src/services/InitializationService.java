package services;

import models.*;
import models.enums.*;
import repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitializationService {
    private final GateRepository gateRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingFloorRepository parkingFloorRepository;

    public InitializationService( GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository) {
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;

    }

    public ParkingLot init(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress("Somewhere on the Earth");
        parkingLot.setCapacity(100);
        parkingLot.setParkingLotStatus(ParkingLotStatus.AVAILABLE);
        parkingLot.setName("Jai Shri Krishna Parking Lot");
        parkingLot.setVehicleTypesSupported(new ArrayList<>(Arrays.asList(VehicleType.EV_VEHICLE, VehicleType.LUXURY_VEHICLE,
                                                                VehicleType.FOUR_WHEELER, VehicleType.TWO_WHEELER)));
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            parkingFloor.setFloorStatus(FloorStatus.AVAILABLE);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                ParkingSpot parkingSpot = getParkingSpot(i, j);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.set(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            Gate entryGate = new Gate();
            entryGate.setGateNumber((i * 1000) + 1);
            entryGate.setGateStatus(GateStatus.OPENED);
            entryGate.setOperator("Operator : "+  (i * 1000) + 1);
            gateRepository.set(entryGate);
            parkingFloor.setEntryGate(entryGate);

            Gate exitGate = new Gate();
            exitGate.setGateNumber((i * 1000) + 2);
            exitGate.setGateStatus(GateStatus.OPENED);
            exitGate.setOperator("Operator : "+  (i * 1000) + 1);
            gateRepository.set(exitGate);
            parkingFloor.setExitGate(exitGate);
            parkingFloors.add(parkingFloor);
            parkingFloorRepository.set(parkingFloor);
        }
        parkingLot.setFloors(parkingFloors);
        parkingLotRepository.set(parkingLot);
        return parkingLot;

    }

    private static ParkingSpot getParkingSpot(int i, int j) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotNumber((i * 100) + j);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        if(i == 1){
            parkingSpot.setVehicleType(VehicleType.LUXURY_VEHICLE);
        }
        else if(i <=5){
            parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
        }
        else if(i <= 9){
            parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
        }
        else{
            parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
        }
        return parkingSpot;
    }
}
