package lk.easycar.rent.service;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.dto.meta.PaymentMetaDTO;

import java.util.ArrayList;

public interface PaymentService {

    void addPayment(PaymentDTO paymentDTO);

    ArrayList<PaymentMetaDTO> getAllPayments();

}
