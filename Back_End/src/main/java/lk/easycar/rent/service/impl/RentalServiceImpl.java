package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.entity.Rental;
import lk.easycar.rent.repo.RentalRepo;
import lk.easycar.rent.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        rentalRepo.save(rent);
        System.out.println(rent);
//        rentalRepo.save(new Rental(rentalDTO.getRentID(),rentalDTO.getCusID(),rentalDTO.getPickupDate(),rentalDTO.getPickupTime(),rentalDTO.getDuration(),rentalDTO.getStatus(),rentalDTO.getDeclineReason(),rentalDTO.getRentDetails().getRentID(),rentalDTO.getRentDetails().getCarID(),rentalDTO.getRentDetails().getDriverID(),rentalDTO.getRentDetails().getPayment().getPaymentID(),rentalDTO.getRentDetails().getPayment().getWaiverDeductions(),rentalDTO.getRentDetails().getPayment().getWaiverSlip(),rentalDTO.getRentDetails().getPayment().getExtraMileagePayment()));
    }
}
