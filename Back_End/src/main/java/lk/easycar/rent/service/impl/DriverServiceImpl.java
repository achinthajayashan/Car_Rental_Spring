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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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

        try {

            String projectPath = System.getProperty("user.dir");
            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            driverDTO.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getFrontImage().getOriginalFilename()));
            driverDTO.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getBackImage().getOriginalFilename()));

            map.setFrontImage("uploads/" + driverDTO.getFrontImage().getOriginalFilename());
            map.setBackImage("uploads/" + driverDTO.getBackImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);

        driverRepo.save(map);

    }
}
