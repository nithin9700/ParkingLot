package repository;

import models.Payment;
import Exception.InvalidPayment;
import java.util.HashMap;

public class PaymentRepository {
    private final HashMap<Integer, Payment> paymentTable;
    private int paymentId = 0;


    public PaymentRepository() {
        this.paymentTable = new HashMap<>();;
    }

    public void set(Payment parkingFloor) {
        paymentTable.put(++paymentId, parkingFloor);
        System.out.println("Payment has been added to repository" + paymentId);
    }

    public Payment get(int ParkingFloorId) {
        Payment payment = paymentTable.get(ParkingFloorId);
        if (payment == null) throw new InvalidPayment("Payment id was not found in dataBase : " + ParkingFloorId);
        return payment;
    }

}
