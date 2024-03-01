package repository;

import models.Bill;
import Exception.Invalidbill;
import java.util.HashMap;

public class BillRepository {
    private final HashMap<Integer, Bill> billTable;
    private int billId = 0;


    public BillRepository() {
        this.billTable = new HashMap<>();;
    }

    public void set(Bill bill) {
        billTable.put(++billId, bill);
        System.out.println("Bill has been added to repository" + billId);
    }

    public Bill get(int ParkingFloorId) {
        Bill bill= billTable.get(billId);
        if (bill == null) throw new Invalidbill("Bill id was not found in dataBase : " + ParkingFloorId);
        return bill;
    }
}
