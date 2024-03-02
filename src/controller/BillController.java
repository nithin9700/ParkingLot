package controller;

import models.Bill;
import models.ParkingFloor;
import models.Ticket;
import repository.BillRepository;
import repository.ParkingFloorRepository;
import services.BillService;
import services.TicketService;

public class BillController {
    private BillService billService;

    public BillController(Ticket ticket, BillRepository billRepository, ParkingFloorRepository parkingFloorRepository) {
        billService = new BillService(ticket, billRepository, parkingFloorRepository);
    }

    public Bill billGenerator(){
        return billService.billGenerator();
    }
}
/*
int floor = ticket.getParkingSpot().getParkingSpotNumber()/100;
            ParkingFloor parkingFloor =  parkingFloorRepository.get(floor);
            bill.setExitGate(parkingFloor.getExitGate());
 */
