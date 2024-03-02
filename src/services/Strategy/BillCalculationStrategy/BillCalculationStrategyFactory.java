package services.Strategy.BillCalculationStrategy;

import models.Ticket;
import models.enums.BillCalculationStrategyType;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategyType billCalculationStrategyType){
        if(billCalculationStrategyType.equals(BillCalculationStrategyType.SURGE))
            return new SurgeBillCalculationStrategy();
        return new NormalBillCalculationStrategy();
    }
}
