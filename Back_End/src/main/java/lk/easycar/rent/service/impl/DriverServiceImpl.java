package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.DriverDTO;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.DriverRepo;
import lk.easycar.rent.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addDriver(DriverDTO driverDTO) {
        Driver driver = new Driver(driverDTO.getDriverID(), driverDTO.getDrivingLicenceNo(), driverDTO.getDriverName(),  driverDTO.getEmail(), driverDTO.getContactNo(),"","",new User(driverDTO.getUser().getUsername(),driverDTO.getUser().getPassword(),driverDTO.getUser().getRole()));


    }
}
