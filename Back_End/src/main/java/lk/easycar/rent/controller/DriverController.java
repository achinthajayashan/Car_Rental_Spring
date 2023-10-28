package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.DriverDTO;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.service.CustomerService;
import lk.easycar.rent.service.DriverService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;
    @PostMapping
    public ResponseUtil addDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO user){
        System.out.println(driverDTO);
        driverDTO.setUser(user);
        System.out.println(driverDTO);
        service.addDriver(driverDTO);
        return new ResponseUtil("Ok","Successfully Added",null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded",service.getAllDrivers());
    }

    @GetMapping(params = {"driverID"})
    public Driver searchDriverId(String driverID) {
        return service.searchDriver(driverID);
    }

    @PutMapping
    public ResponseUtil updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO user){
        System.out.println(driverDTO);
        driverDTO.setUser(user);
        System.out.println(driverDTO);
        service.updateDriver(driverDTO);
        return new ResponseUtil("Ok","Successfully Added",null);
    }

    @DeleteMapping(params = {"driverID"})
    public ResponseUtil deleteDriver(@RequestParam String id) {
        service.deleteDriver(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

}
