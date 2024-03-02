package services.Strategy.BillCalculationStrategy;

import models.Bill;
import models.Ticket;

public interface BillCalculationStrategy {

    Bill parkingCharges(Ticket ticket);

}
