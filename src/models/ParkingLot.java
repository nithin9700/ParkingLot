package models;

import models.enums.ParkingLotStatus;
import models.enums.VehicleType;
import repository.*;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategyFactory;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> floors;
    private int capacity;
    private ParkingLotStatus parkingLotStatus;;
    private String name;
    private List<VehicleType> vehicleTypesSupported;
    private String address;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategyFactory spotAllocationStrategyFactory;

    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;




    public ParkingLot() {
    }

    public ParkingLot(List<ParkingFloor> floors, int capacity, ParkingLotStatus parkingLotStatus, String name,
                      List<VehicleType> vehicleTypesSupported, String address, BillCalculationStrategy billCalculationStrategy,
                      SpotAllocationStrategyFactory spotAllocationStrategyFactory, GateRepository gateRepository,
                      ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository,
                      ParkingFloorRepository parkingFloorRepository) {
        this.floors = floors;
        this.capacity = capacity;
        this.parkingLotStatus = parkingLotStatus;
        this.name = name;
        this.vehicleTypesSupported = vehicleTypesSupported;
        this.address = address;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotAllocationStrategyFactory = spotAllocationStrategyFactory;
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;

    }

    public SpotAllocationStrategyFactory getSpotAllocationStrategyFactory() {
        return spotAllocationStrategyFactory;
    }

    public void setSpotAllocationStrategyFactory(SpotAllocationStrategyFactory spotAllocationStrategyFactory) {
        this.spotAllocationStrategyFactory = spotAllocationStrategyFactory;
    }

    public GateRepository getGateRepository() {
        return gateRepository;
    }

    public void setGateRepository(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public ParkingSpotRepository getParkingSpotRepository() {
        return parkingSpotRepository;
    }

    public void setParkingSpotRepository(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingLotRepository getParkingLotRepository() {
        return parkingLotRepository;
    }

    public void setParkingLotRepository(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingFloorRepository getParkingFloorRepository() {
        return parkingFloorRepository;
    }

    public void setParkingFloorRepository(ParkingFloorRepository parkingFloorRepository) {
        this.parkingFloorRepository = parkingFloorRepository;
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

    public SpotAllocationStrategyFactory getSpotAllocationStrategy() {
        return spotAllocationStrategyFactory;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategyFactory spotAllocationStrategyFactory) {
        this.spotAllocationStrategyFactory = spotAllocationStrategyFactory;
    }

}
