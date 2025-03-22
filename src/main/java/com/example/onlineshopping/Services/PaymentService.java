package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.Payment;
import com.example.onlineshopping.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    //add new payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    //update payment
    public Payment updatePayment(Long paymentId, Payment updatedPayment) {
        Optional<Payment> oldPayment = paymentRepository.findById(paymentId);
        if (oldPayment.isPresent()) {
            Payment payment = oldPayment.get();
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setAmount(updatedPayment.getAmount());
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment is not found by id : " + paymentId);
        }
    }

    //delete payment
    public void deletePayment(long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
    //get all payments

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    //get payment by id
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    //get payment by order id

    public Optional<Payment> getPaymentByOrderId(Long orderId) {
        return Optional.ofNullable(paymentRepository.findByOrder_OrderId(orderId));
    }

    //get payment by customer id

    public Optional<Payment> getPaymentByCustomerId(Long customerId) {
        return Optional.ofNullable(paymentRepository.findByCustomer_CustomerId(customerId));
    }

    // get payment by vendor id

    public Optional<Payment> getPaymentByVendorId(Long vendorId) {
        return Optional.ofNullable(paymentRepository.findByVendor_VendorId(vendorId));
    }



}
