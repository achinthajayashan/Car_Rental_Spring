package lk.easycar.rent.service;

import lk.easycar.rent.dto.CarDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    ArrayList<CarDTO> getAllCars();
}
