package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.Payment;
import lk.easycar.rent.entity.Rental;
import lk.easycar.rent.repo.PaymentRepo;
import lk.easycar.rent.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addPayment(PaymentDTO paymentDTO) {
        Payment map =mapper.map(paymentDTO,Payment.class);

        paymentRepo.save(map);
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() {
        List<Payment> all = paymentRepo.findAll();
        return mapper.map(all, new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
