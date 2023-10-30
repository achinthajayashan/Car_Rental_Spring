package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CustomDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.service.CustomerService;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO user){
        System.out.println(customerDTO);
        customerDTO.setUser(user);
        System.out.println(customerDTO);
        service.addCustomer(customerDTO);
        return new ResponseUtil("Ok","Successfully Added",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded",service.getAllCustomers());
    }

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.customerIdGenerate();
    }
}
