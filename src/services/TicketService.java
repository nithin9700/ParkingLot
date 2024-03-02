package services;

import controller.TicketController;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import models.enums.SpotAllocationStrategyType;
import repository.TicketRepository;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

public class TicketService {
    private ParkingLot parkingLot;
    private Vehicle vehicle;
    private TicketRepository ticketRepository;

    public TicketService(ParkingLot parkingLot, Vehicle vehicle, TicketRepository ticketRepository){
        this.parkingLot = parkingLot;
        this.vehicle = vehicle;
        this.ticketRepository = ticketRepository;
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
        ticketRepository.set(ticket);
        return ticket;

    }
}
