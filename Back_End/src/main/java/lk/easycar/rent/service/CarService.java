package lk.easycar.rent.service;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.entity.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    ArrayList<CarDTO> getAllCars();

    Car searchCar(String id);
}
