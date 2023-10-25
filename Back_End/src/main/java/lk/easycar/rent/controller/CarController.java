package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.service.CarService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseUtil addCar(@ModelAttribute CarDTO carDTO){
        System.out.println(carDTO);
        carService.addCar(carDTO);
        return new ResponseUtil("Ok","Successfully Added",null);
    }
}
