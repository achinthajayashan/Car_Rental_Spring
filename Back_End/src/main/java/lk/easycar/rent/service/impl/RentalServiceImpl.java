package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.entity.Rental;
import lk.easycar.rent.repo.RentalRepo;
import lk.easycar.rent.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepo rentalRepo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public void requestRent(RentalDTO rentalDTO) {
        System.out.println(rentalDTO);

//        rentalRepo.save(new Rental(rentalDTO.getRentID(),rentalDTO.getCusID(),rentalDTO.getPickupDate(),rentalDTO.getPickupTime(),rentalDTO.getDuration(),rentalDTO.getStatus(), rentalDTO.getDeclineReason(), rentalDTO.getRentDetails(rentalDTO.getRentDetails().getRentID(),rentalDTO.getRentDetails().getCarID(),rentalDTO.getRentDetails().getDriverID(),rentalDTO.getRentDetails().getPayment(rentalDTO.getRentDetails().getPayment().getPaymentID())),rentalDTO.getRentDetails().getPayment()));

        Rental rent = mapper.map(rentalDTO, Rental.class);


//        try {
//
//            String projectPath = System.getProperty("user.dir");
//            System.out.println("Project Location: " + projectPath);
//            File uploadsDir = new File(projectPath + "/uploads");
//            System.out.println(projectPath);
//            uploadsDir.mkdir();
//
////            if (!uploadsDir.exists()) {
////                if (uploadsDir.mkdirs()) {
////                    System.out.println("Directory created successfully: " + projectPath);
////                } else {
////                    System.err.println("Failed to create directory: " + projectPath);
////                }
////            } else {
////                System.out.println("Directory already exists: " + projectPath);
////            }
//
//
//            rentalDTO..transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
//            dto.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackImage().getOriginalFilename()));
//
//            map.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
//            map.setBackImage("uploads/" + dto.getBackImage().getOriginalFilename());
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        rentalRepo.save(rent);
        System.out.println(rent);
//        rentalRepo.save(new Rental(rentalDTO.getRentID(),rentalDTO.getCusID(),rentalDTO.getPickupDate(),rentalDTO.getPickupTime(),rentalDTO.getDuration(),rentalDTO.getStatus(),rentalDTO.getDeclineReason(),rentalDTO.getRentDetails().getRentID(),rentalDTO.getRentDetails().getCarID(),rentalDTO.getRentDetails().getDriverID(),rentalDTO.getRentDetails().getPayment().getPaymentID(),rentalDTO.getRentDetails().getPayment().getWaiverDeductions(),rentalDTO.getRentDetails().getPayment().getWaiverSlip(),rentalDTO.getRentDetails().getPayment().getExtraMileagePayment()));
    }
}
