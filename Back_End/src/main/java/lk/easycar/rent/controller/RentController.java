package lk.easycar.rent.controller;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentCarDetailDTO;
import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {


    @PostMapping
    public ResponseUtil requestRent(@ModelAttribute RentalDTO  rentalDTO, @ModelAttribute RentCarDetailDTO rentCarDetailDTO, @ModelAttribute PaymentDTO paymentDTO){
        System.out.println(rentalDTO);
        System.out.println(rentCarDetailDTO.getPaymentDTO().getWaiverSlip());
        System.out.println(paymentDTO);
        return new ResponseUtil("Ok","Successfully Added",rentalDTO);
    }
}
