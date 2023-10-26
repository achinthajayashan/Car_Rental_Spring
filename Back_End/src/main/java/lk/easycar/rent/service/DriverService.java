package lk.easycar.rent.service;

import lk.easycar.rent.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    void addDriver(DriverDTO driverDTO);
    ArrayList<DriverDTO> getAllDrivers();
}
