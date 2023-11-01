package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.DriverDTO;
import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.Customer;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.DriverRepo;
import lk.easycar.rent.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
            Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Projects/Easy Car Rental/Front_End");

//            String projectPath = System.getProperty("user.dir");
//            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(sourceCodePath + "/uploads");
            System.out.println(sourceCodePath);
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

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public Driver searchDriver(String id) {
        return mapper.map(driverRepo.findById(id).get(), Driver.class);
    }


    @Override
    public void updateDriver(DriverDTO driverDTO) {
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

    @Override
    public void deleteDriver(String id) {
        driverRepo.deleteById(id);
    }
}
