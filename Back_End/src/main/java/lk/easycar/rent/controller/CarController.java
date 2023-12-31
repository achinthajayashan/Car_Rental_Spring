package lk.easycar.rent.controller;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.CustomDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.dto.meta.CarMetaDTO;
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
    public ArrayList<CarMetaDTO> getAllCarsList(){
        return carService.getAllCars();
    }

    @GetMapping(params = {"car_id"})
    public ResponseUtil searchCar(String car_id) {
        System.out.println(car_id);
        Car carDTO =carService.searchCar(car_id);
        return new ResponseUtil("Ok","Successfully Updated",carDTO);
    }

    @GetMapping(params = {"carId"})
    public Car searchCar2(String carId) {
        System.out.println(carId);
        return carService.searchCar(carId);
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

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO carIdGenerate() {
        return carService.carIdGenerate();
    }
}
