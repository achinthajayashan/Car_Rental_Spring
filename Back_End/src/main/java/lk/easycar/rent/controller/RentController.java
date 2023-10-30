package lk.easycar.rent.controller;

import lk.easycar.rent.dto.PaymentDTO;
import lk.easycar.rent.dto.RentCarDetailDTO;
import lk.easycar.rent.dto.RentalDTO;
import lk.easycar.rent.service.RentalService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    public ResponseUtil requestRent(@ModelAttribute RentalDTO  rentalDTO, @ModelAttribute RentCarDetailDTO rentCarDetailDTO, @ModelAttribute PaymentDTO paymentDTO){
        rentalDTO.setCusID("C00-001");

        rentalDTO.setRentDetails(Collections.singletonList(rentCarDetailDTO));

        rentCarDetailDTO.setPayment(paymentDTO);


        System.out.println(rentalDTO);

        rentalService.requestRent(rentalDTO);


        return new ResponseUtil("Ok","Successfully Added",rentalDTO);
    }
}