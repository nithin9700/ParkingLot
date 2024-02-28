package models;

import models.enums.ParkingLotStatus;
import models.enums.VehicleType;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategy;

import java.awt.desktop.AppReopenedEvent;
import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> floors;
    private int capacity;
    private ParkingLotStatus parkingLotStatus;;
    private String name;
    private List<VehicleType> vehicleTypesSupported;
    private String address;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

    public ParkingLot() {
    }

    public ParkingLot(List<ParkingFloor> floors, int capacity, ParkingLotStatus parkingLotStatus, String name, List<VehicleType> vehicleTypesSupported, String address, BillCalculationStrategy billCalculationStrategy, SpotAllocationStrategy spotAllocationStrategy) {
        this.floors = floors;
        this.capacity = capacity;
        this.parkingLotStatus = parkingLotStatus;
        this.name = name;
        this.vehicleTypesSupported = vehicleTypesSupported;
        this.address = address;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VehicleType> getVehicleTypesSupported() {
        return vehicleTypesSupported;
    }

    public void setVehicleTypesSupported(List<VehicleType> vehicleTypesSupported) {
        this.vehicleTypesSupported = vehicleTypesSupported;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
}
