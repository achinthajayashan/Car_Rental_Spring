package lk.easycar.rent.service;

import lk.easycar.rent.dto.CustomDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.RentalDTO;

import java.util.ArrayList;

public interface RentalService {

    void requestRent(RentalDTO rentalDTO);

    ArrayList<RentalDTO> getAllRentals();

    CustomDTO rentIdGenerate();

    void updateStatus(String rentalID,String status);
}
