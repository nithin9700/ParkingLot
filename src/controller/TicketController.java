package controller;

import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(ParkingLot parkingLot, Vehicle vehicle, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketService = new TicketService(parkingLot, vehicle, ticketRepository,parkingSpotRepository);
    }


    public Ticket getTicket(){
        return ticketService.ticketGenerate();
    }
}
