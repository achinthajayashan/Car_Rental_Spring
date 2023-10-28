package lk.easycar.rent.service;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.DriverDTO;
import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.Driver;

import java.util.ArrayList;

public interface DriverService {

    void addDriver(DriverDTO driverDTO);
    ArrayList<DriverDTO> getAllDrivers();

    Driver searchDriver(String id);

    void updateDriver(DriverDTO dto);

    void deleteDriver(String id);
}
