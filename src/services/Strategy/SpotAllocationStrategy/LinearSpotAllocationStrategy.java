package services.Strategy.SpotAllocationStrategy;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import models.enums.ParkingSpotStatus;
import Exception.NoSpaceAvailable;
import models.enums.VehicleType;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot getVehicleSpot(ParkingLot parkingLot, Vehicle vehicle) {
        List<ParkingFloor> floorList = parkingLot.getFloors();

        for (ParkingFloor floor : floorList) {
            List<ParkingSpot> parkingSpotList = floor.getParkingSpots();
            for (ParkingSpot parkingSpot : parkingSpotList) {
                if(parkingSpot.getVehicleType().equals(vehicle.getVehicleType())
                        && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                    parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FILLED);
                    parkingSpot.setVehicle(vehicle);
                    parkingSpot.setVehicleType(vehicle.getVehicleType());
                    return parkingSpot;
                }
            }
        }
        throw new NoSpaceAvailable("No space available for the car");
    }
}
