package models;

import models.enums.BillStatus;
import models.enums.FloorStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private Gate entryGate;
    private Gate exitGate;
    private FloorStatus floorStatus;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor() {
    }

    public ParkingFloor(int floorNumber, Gate entryGate, Gate exitGate, FloorStatus floorStatus, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.floorStatus = floorStatus;
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
