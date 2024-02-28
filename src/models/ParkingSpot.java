package models;

import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;

public class ParkingSpot extends BaseModel{
    private int parkingSpotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot() {
    }

    public ParkingSpot(int parkingSpotNumber, ParkingSpotStatus parkingSpotStatus, VehicleType vehicleType, Vehicle vehicle) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.parkingSpotStatus = parkingSpotStatus;
        this.vehicleType = vehicleType;
        this.vehicle = vehicle;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
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

