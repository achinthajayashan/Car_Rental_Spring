package lk.easycar.rent.controller;

import lk.easycar.rent.service.DriverService;
import lk.easycar.rent.service.PaymentService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseUtil getAllPayments(){
        return new ResponseUtil("OK","Successfully Loaded",service.getAllPayments());
    }
}
