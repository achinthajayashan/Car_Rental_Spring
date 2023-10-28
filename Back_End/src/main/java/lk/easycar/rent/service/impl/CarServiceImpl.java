package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.CarDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.Customer;
import lk.easycar.rent.repo.CarRepo;
import lk.easycar.rent.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addCar(CarDTO dto) {
        Car map= mapper.map(dto,Car.class);

        try {
            String projectPath = System.getProperty("user.dir");
            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
            dto.getRearImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getRearImage().getOriginalFilename()));
            dto.getSideImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getSideImage().getOriginalFilename()));
            dto.getInteriorImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getInteriorImage().getOriginalFilename()));


            map.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
            map.setRearImage("uploads/" + dto.getRearImage().getOriginalFilename());
            map.setSideImage("uploads/" + dto.getSideImage().getOriginalFilename());
            map.setInteriorImage("uploads/" + dto.getInteriorImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map);
        carRepo.save(map);
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all, new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public Car searchCar(String id) {
        return mapper.map(carRepo.findById(id).get(), Car.class);
    }

    @Override
    public void updateCar(CarDTO dto) {
        Car map= mapper.map(dto,Car.class);

        try {
            String projectPath = System.getProperty("user.dir");
            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
            dto.getRearImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getRearImage().getOriginalFilename()));
            dto.getSideImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getSideImage().getOriginalFilename()));
            dto.getInteriorImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getInteriorImage().getOriginalFilename()));


            map.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
            map.setRearImage("uploads/" + dto.getRearImage().getOriginalFilename());
            map.setSideImage("uploads/" + dto.getSideImage().getOriginalFilename());
            map.setInteriorImage("uploads/" + dto.getInteriorImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map);
        carRepo.save(map);
    }

    @Override
    public void deleteCar(String carId) {
        carRepo.deleteById(carId);
    }
}
