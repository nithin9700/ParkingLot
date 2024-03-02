package controller;

import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import repository.TicketRepository;
import services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(ParkingLot parkingLot, Vehicle vehicle, TicketRepository ticketRepository) {
        this.ticketService = new TicketService(parkingLot, vehicle, ticketRepository);

    }


    public Ticket getTicket(){
        return ticketService.ticketGenerate();
    }
}
