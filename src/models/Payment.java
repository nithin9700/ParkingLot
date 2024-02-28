package models;

import models.enums.PaymentMode;
import models.enums.PaymentStatus;

import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private Bill bill;
    private PaymentMode paymentMode;
    private String transactionId;
    private double amount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;

    public Payment() {
    }

    public Payment(Bill bill, PaymentMode paymentMode, String transactionId, double amount, PaymentStatus paymentStatus, LocalDateTime paymentTime) {
        this.bill = bill;
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
