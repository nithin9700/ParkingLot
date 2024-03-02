package services;

import models.Bill;
import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import models.enums.BillCalculationStrategyType;
import models.enums.SurgePrice;
import repository.BillRepository;
import repository.ParkingFloorRepository;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import services.Strategy.BillCalculationStrategy.BillCalculationStrategyFactory;
import services.TicketService;

public class BillService {
    private final Ticket ticket;
    private final BillRepository billRepository;
    private final ParkingFloorRepository parkingFloorRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final TicketRepository ticketRepository;
    public BillService(BillRepository billRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, TicketRepository ticketRepository) {
        this.billRepository = billRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Bill billGenerator(int ticketID){
        Ticket ticket = ticketRepository.get(ticketID);
        BillCalculationStrategy billCalculationStrategy;
        billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(convertFromTicket());
        int floor = ticket.getParkingSpot().getParkingSpotNumber()/100;
        ParkingFloor parkingFloor =  parkingFloorRepository.get(floor);
        Bill bill = billCalculationStrategy.parkingCharges(ticket);
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpotRepository.remove(parkingSpot.getId());
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
