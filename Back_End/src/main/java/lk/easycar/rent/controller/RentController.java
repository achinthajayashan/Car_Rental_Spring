package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CustomDTO;
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
        rentalDTO.setCustomerID("C00-001");
        rentalDTO.setStatus("PENDING");

        rentalDTO.setRentDetails(Collections.singletonList(rentCarDetailDTO));

        rentCarDetailDTO.setPayment(paymentDTO);
        paymentDTO.setWaiverSlip(paymentDTO.getWaiverSlip());
        System.out.println(rentalDTO);
        System.out.println(paymentDTO);

        rentalService.requestRent(rentalDTO);


        return new ResponseUtil("Ok","Successfully Added",rentalDTO);
    }

    @PostMapping(path = "/manyRents")
    public ResponseUtil requestRents(@RequestBody RentalDTO dto) {
        rentalService.requestRent(dto);
        return new ResponseUtil("Ok", "Successfully Purchased.!", dto);
    }


    @GetMapping
    public ResponseUtil getAllRentals(){
        return new ResponseUtil("OK","Successfully Loaded",rentalService.getAllRentals());
    }

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO rentIdGenerate() {
        return rentalService.rentIdGenerate();
    }


    @PostMapping(params = {"rentID","status"})
    public ResponseUtil updateStatus(String rentID,String status) {
        rentalService.updateStatus(rentID,status);
        return new ResponseUtil("Ok", "Successfully Purchased.!", status);
    }

}
