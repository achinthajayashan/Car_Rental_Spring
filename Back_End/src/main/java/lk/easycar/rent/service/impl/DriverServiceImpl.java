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

        Driver map =mapper.map(driverDTO,Driver.class);
        map.setUser(new User(driverDTO.getUser().getUserName(),driverDTO.getUser().getPassword(),"driver"));

        System.out.println(map);

        driverRepo.save(map);

    }
}
