package lk.easycar.rent.service;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.CustomDTO;
import lk.easycar.rent.dto.meta.CarMetaDTO;
import lk.easycar.rent.entity.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    ArrayList<CarMetaDTO> getAllCars();

    Car searchCar(String id);

    void updateCar(CarDTO dto);

    void deleteCar(String carId);

    CustomDTO carIdGenerate();

}
