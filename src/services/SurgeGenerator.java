package services;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.SurgePrice;


import java.util.List;

public class SurgeGenerator {
    public SurgeGenerator() {
    }

    public SurgePrice getSurge(ParkingLot parkingLot){
        int capacity = parkingLot.getCapacity();
        int filledCapacity = filledCapacity(parkingLot);
        int percentage = (filledCapacity/capacity) * 100;
        return getSurgePercentage(percentage);
    }

    private SurgePrice getSurgePercentage(int percentage) {
        if(percentage >= 50 && percentage <=69){
            return SurgePrice.FIFTY;
        }
        if(percentage >= 70 && percentage <= 89){
            return SurgePrice.SEVENTYFIVE;
        }
        if(percentage >= 90 && percentage <= 100){
            return SurgePrice.NINETY;
        }
        return SurgePrice.NO;
    }


    private int filledCapacity(ParkingLot parkingLot){
        List<ParkingFloor> floors = parkingLot.getFloors();
        int filledSpots = 0;
        for (ParkingFloor floor : floors) {
            List<ParkingSpot> spots = floor.getParkingSpots();
            for (ParkingSpot parkingSpot : spots) {
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.FILLED)){
                    filledSpots++;
                }
            }
        }
        return filledSpots;
    }
}
