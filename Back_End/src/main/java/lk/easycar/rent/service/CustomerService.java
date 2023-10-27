package lk.easycar.rent.service;

import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.meta.CustomerMetaDTO;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    ArrayList<CustomerDTO> getAllCustomers();
}
