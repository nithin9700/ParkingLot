package services.Strategy.BillCalculationStrategy;

import models.Bill;
import models.Ticket;
import models.enums.BillStatus;
import models.enums.SurgePrice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public Bill parkingCharges(Ticket ticket) {
        Bill bill = new Bill();
        long totalTime = ChronoUnit.SECONDS.between(ticket.getEntryTime(), LocalDateTime.now());
        double amount = ParkingRate.basePrice + (totalTime + ParkingRate.perSecond);
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(LocalDateTime.now());
        amount = bill.getAmount();
         if(ticket.isSurge().equals(SurgePrice.FIFTY)){
             surgePercentage50(amount);
         }
         else if(ticket.isSurge().equals(SurgePrice.SEVENTYFIVE)){
             surgePercentage75(amount);
         }
         else if(ticket.isSurge().equals(SurgePrice.NINETY)){
             surgePercentage90(amount);
         }
         bill.setAmount(amount);
         return bill;
    }
    public double surgePercentage50(double amount){
        return amount + (amount * ParkingRate.surgePercentage50);
    }

    public double surgePercentage75(double amount){
        return amount + (amount * ParkingRate.surgePercentage75);
    }
    public double surgePercentage90(double amount){
        return amount + (amount * ParkingRate.surgePercentage90);
    }
}
