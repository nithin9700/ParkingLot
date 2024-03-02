package controller;

import models.Bill;
import services.PaymentService;

public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void payBill(int billID){

    }
}
