package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.dto.meta.PaymentMetaDTO;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        try {

            String projectPath = System.getProperty("user.dir");
            Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Projects/Easy Car Rental/Front_End");

//            String projectPath = System.getProperty("user.dir");
//            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(sourceCodePath + "/uploads");
            System.out.println(sourceCodePath);
            uploadsDir.mkdir();

            paymentDTO.getWaiverSlip().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + paymentDTO.getWaiverSlip().getOriginalFilename()));

            map.setWaiverSlip("uploads/" + paymentDTO.getWaiverSlip().getOriginalFilename());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        paymentRepo.save(map);
    }

    @Override
    public ArrayList<PaymentMetaDTO> getAllPayments() {
        List<Payment> all = paymentRepo.findAll();
        return mapper.map(all, new TypeToken<List<PaymentMetaDTO>>() {
        }.getType());
    }
}
