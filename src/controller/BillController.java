package controller;

import models.Bill;
import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import repository.BillRepository;
import repository.ParkingFloorRepository;
import repository.ParkingSpotRepository;
import services.BillService;
import services.TicketService;

public class BillController {
    private final BillService billService;

    public BillController(BillRepository billRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository) {
        billService = new BillService(billRepository, parkingFloorRepository, parkingSpotRepository);
    }

    public Bill billGenerator(int ticket){
        return billService.billGenerator(ticket);
    }
}
/*
int floor = ticket.getParkingSpot().getParkingSpotNumber()/100;
            ParkingFloor parkingFloor =  parkingFloorRepository.get(floor);
            bill.setExitGate(parkingFloor.getExitGate());
 */
