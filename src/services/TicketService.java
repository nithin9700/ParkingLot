package services;

import controller.TicketController;
import models.ParkingLot;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.enums.SpotAllocationStrategyType;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

public class TicketService {
    private final ParkingLot parkingLot;
    private final Vehicle vehicle;
    private final TicketRepository ticketRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    public TicketService(ParkingLot parkingLot, Vehicle vehicle, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository) {
        this.parkingLot = parkingLot;
        this.vehicle = vehicle;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket ticketGenerate(){
        SurgeGenerator surgeGenerator = new SurgeGenerator();
        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicleType(vehicle.getVehicleType());
        ticket.setVehicle(vehicle);
        ticket.setSurge(surgeGenerator.getSurge(parkingLot));
        ticket.setParkingSpot(
                SpotAllocationStrategyFactory.
                        getSpotAllocationStrategy(
                                SpotAllocationStrategyType.LINER).
                        getVehicleSpot(parkingLot, vehicle));
        parkingSpotRepository.set(ticket.getParkingSpot());
        ticketRepository.set(ticket);
        return ticket;

    }
}
