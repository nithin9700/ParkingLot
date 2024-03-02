package services;

import models.Bill;
import models.ParkingFloor;
import models.Ticket;
import models.enums.BillCalculationStrategyType;
import models.enums.SurgePrice;
import repository.BillRepository;
import repository.ParkingFloorRepository;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategyFactory;
import services.TicketService;

public class BillService {
    private Ticket ticket;
    private BillCalculationStrategy billCalculationStrategy;
    private BillRepository billRepository;
    private ParkingFloorRepository parkingFloorRepository;
    public BillService(Ticket ticket, BillRepository billRepository, ParkingFloorRepository parkingFloorRepository) {
        this.ticket = ticket;
        this.billRepository = billRepository;
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public Bill billGenerator(){
        billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(convertFromTicket());
        int floor = ticket.getParkingSpot().getParkingSpotNumber()/100;
        ParkingFloor parkingFloor =  parkingFloorRepository.get(floor);
        Bill bill = billCalculationStrategy.parkingCharges(ticket);
        bill.setExitGate(parkingFloor.getExitGate());
        billRepository.set(bill);
        return bill;
    }

    private BillCalculationStrategyType convertFromTicket(){
        SurgePrice surgePrice = ticket.isSurge();
        if(surgePrice.equals(SurgePrice.NO)) return BillCalculationStrategyType.NORMAL;
        return BillCalculationStrategyType.SURGE;
    }
}
