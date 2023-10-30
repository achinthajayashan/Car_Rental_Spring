package lk.easycar.rent.service;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentalDTO;

import java.util.ArrayList;

public interface PaymentService {

    void addPayment(PaymentDTO paymentDTO);

    ArrayList<PaymentDTO> getAllPayments();

}
