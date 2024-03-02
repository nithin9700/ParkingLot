package controller;

import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public Ticket getTicket(){
        return ticketService.ticketGenerate();
    }
}
