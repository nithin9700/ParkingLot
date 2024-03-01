package models;

import models.enums.VehicleType;

import java.time.LocalDateTime;

public class Ticket extends BaseModel{
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean surge;

    public Ticket() {
    }

    public Ticket(LocalDateTime entryTime, ParkingSpot parkingSpot, VehicleType vehicleType, Vehicle vehicle, boolean surge) {
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicleType = vehicleType;
        this.vehicle = vehicle;
        this.surge = surge;
    }

    public boolean isSurge() {
        return surge;
    }

    public void setSurge(boolean surge) {
        this.surge = surge;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
