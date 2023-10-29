package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.entity.Car;
import lk.easycar.rent.service.CarService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded",carService.getAllCars());
    }

    @GetMapping(path = "/view")
    public ArrayList<CarDTO> getAllCarsList(){
        return carService.getAllCars();
    }

    @GetMapping(params = {"car_id"})
    public Car searchCar(String car_id) {
        System.out.println(car_id);
        return carService.searchCar(car_id);
    }

    @PutMapping
    public ResponseUtil updateCar(@ModelAttribute CarDTO carDTO){
        System.out.println(carDTO);
        carService.updateCar(carDTO);
        return new ResponseUtil("Ok","Successfully Updated",null);
    }

    @DeleteMapping(params = {"carId"})
    public ResponseUtil deleteCar(@RequestParam String carId) {
        carService.deleteCar(carId);
        return new ResponseUtil("OK", "Successfully Deleted. :" + carId, null);
    }
}
