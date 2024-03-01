package repository;

import models.ParkingFloor;
import models.Ticket;
import Exception.InvalidTicket;

import java.util.HashMap;

public class TicketRepository {
    private final HashMap<Integer, Ticket> ticketTable;
    private int ticketId = 0;


    public TicketRepository() {
        this.ticketTable = new HashMap<>();;
    }

    public void set(Ticket ticket) {
        ticketTable.put(++ticketId, ticket);
        System.out.println("Ticket has been added to repository" + ticketId);
    }

    public Ticket get(int ParkingFloorId) {
        Ticket ticket= ticketTable.get(ticketId);
        if (ticket == null) throw new InvalidTicket("Ticket id was not found in dataBase : " + ParkingFloorId);
        return ticket;
    }

}
