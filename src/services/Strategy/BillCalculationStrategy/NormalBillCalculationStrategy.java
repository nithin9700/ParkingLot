package services.Strategy.BillCalculationStrategy;

import models.Bill;
import models.ParkingFloor;
import models.Ticket;
import models.enums.BillStatus;
import repository.ParkingFloorRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NormalBillCalculationStrategy implements BillCalculationStrategy{

    @Override
    public Bill parkingCharges(Ticket ticket) {

        Bill bill = new Bill();
        long totalTime = ChronoUnit.SECONDS.between(ticket.getEntryTime(), LocalDateTime.now());
        double amount = ParkingRate.basePrice + (totalTime + ParkingRate.perSecond);
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(LocalDateTime.now());

        return bill;
    }
}
